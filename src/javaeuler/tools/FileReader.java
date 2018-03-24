package javaeuler.tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    private String fileName;
    public String[] lines;

    public FileReader(String fileName) {
        this.fileName = fileName;
        init();
    }

    private void init() {

        String line;
        StringBuilder fileContents = new StringBuilder();

        try {
            java.io.FileReader fileReader = new java.io.FileReader(this.fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                fileContents.append(line);
                fileContents.append("\n");

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File IO Error");
        }

        this.lines = fileContents.toString().split("[\r\n]");
    }
}