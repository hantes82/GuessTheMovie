package pl.infoshare.guessthemovie;

import java.util.*;


public class Game {
    public static void main(String[] args) {
        String filePath = "src/main/resources/movies.txt";
        List<String> moviesList = FileOperations.loadMovies(filePath);
        List<Character> title = GameOperations.chooseTitle(moviesList);
        List<Character> encryptedTitle = GameOperations.encryptTitle(title);
        int errorsCounter = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("You are guessing: ");
        GameOperations.printList(encryptedTitle);
        GameOperations.encryptTitle(title);

        while (errorsCounter < 10) {
            System.out.println("You have guessed (" + errorsCounter + ") wrong letters");
            GameOperations.printList(encryptedTitle);
            System.out.println("Guess a letter: ");
            char letter = scan.next().charAt(0);
            if (GameOperations.guessCheck(title, letter)) {
                encryptedTitle = GameOperations.updateEncrypted(title, encryptedTitle, letter);
                GameOperations.printList(encryptedTitle);
                if (GameOperations.winCheck(title, encryptedTitle)) {
                    System.out.println("You win!");
                    System.out.print("You have guessed ");
                    GameOperations.printList(encryptedTitle);
                    System.out.println(" correctly");
                    break;
                }
            } else {
                errorsCounter++;
            }
        }
    }
}

