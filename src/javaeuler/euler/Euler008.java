package javaeuler.euler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Euler008 {
    private static final String FILENAME = "src/resources/Euler008.txt";

    public static void main(String[] args) {
        String line;
        StringBuilder contents = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(FILENAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                contents.append(line);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File IO Error");
        }

        List<String> substrings = new ArrayList<>();
        for (int i=0; i + 13 < contents.length(); i++) {
            substrings.add(contents.substring(i, i+13));
        }

        System.out.println(largestProduct(substrings));
    }

    private static long largestProduct(List substrings) {
        long result = 0;
        for (Object substring : substrings) {
            long mulResult = mul((String) substring);
            if (mulResult > result) {
                result = mulResult;
            }
        }
        return result;
    }

    private static long mul(String substring) {
        long result = 1;
        for (Character i : substring.toCharArray()) {
            long num = Character.getNumericValue(i);
            result *= num;
        }
        return result;
    }
}
