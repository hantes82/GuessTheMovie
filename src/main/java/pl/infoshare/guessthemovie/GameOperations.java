package pl.infoshare.guessthemovie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameOperations {

    public static List<Character> encryptTitle(List<Character> title) {
        List<Character> letters = new ArrayList<>();
        for (int i = 0; i < title.size(); i++) {
            if (title.get(i) != ' ') {
                letters.add('_');
            } else {
                letters.add(' ');
            }
        }
        return letters;
    }

    public static List<Character> chooseTitle(List<String> moviesList) {
        List<Character> letters = new ArrayList<>();
        Random rand = new Random();
        int rangeLimit = moviesList.size() - 1;
        String title = moviesList.get(rand.nextInt(rangeLimit));
        for (int i = 0; i < title.length(); i++) {
            letters.add(title.charAt(i));
        }
        return letters;
    }

    public static boolean guessCheck(List<Character> letters, char letter) {
        return (letters.contains(letter));
    }

    public static boolean winCheck(List<Character> letters, List<Character> encryptedLetters) {
        return letters.equals(encryptedLetters);
    }

    public static List<Character> updateEncrypted(List<Character> title, List<Character> encryptedTitle, char letter) {
        for (int i = 0; i < title.size(); i++) {
            if (title.get(i) == letter) {
                encryptedTitle.set(i, letter);
            }
        }
        return encryptedTitle;
    }

    public static void printList(List<Character> list) {
        StringBuilder builder = new StringBuilder();
        for (Character character : list) {
            builder.append(character);
        }
        System.out.println(builder.toString());
    }
}