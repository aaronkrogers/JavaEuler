package javaeuler.tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EulerReader {
    public final String fileName;
    private String fileContents;
    private String[] lines;

    public EulerReader(String fileName) {
        this.fileName = fileName;
        init();
    }

    private void init() {

        String line;
        StringBuilder fileContents = new StringBuilder();

        try {
            FileReader fileReader = new FileReader(this.fileName);
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

        this.fileContents = fileContents.toString();
        this.lines = fileContents.toString().split("[\r\n]");
    }

    public String read() {
        return fileContents;
    }

    public String[] readLines() {
        return lines;
    }

    @Override
    public String toString() {
        return fileContents;
    }
}