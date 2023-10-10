package pl.infoshare.guessthemovie;

import java.io.*;
import java.util.*;

public class FileOperations {
    public static List<String> loadMovies(String filePath) {
        List<String> moviesList = new ArrayList();

        try (
                FileReader fileReader = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                ) {
            String newLine = null;
            while ((newLine = bufferedReader.readLine()) != null) {
                moviesList.add(newLine);
            }
        } catch (IOException e) {
            System.err.println("Nie znaleziono pliku");;
        }
        return moviesList;
    }

}
