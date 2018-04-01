package javaeuler.euler;

import javaeuler.tools.EulerProblem;
import javaeuler.tools.EulerReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Euler011 extends EulerProblem {
    private int[][] grid = new int[20][20];

    public Euler011() {
        this.fileToGrid();
    }

    public static void main(String[] args) {
        EulerProblem euler011 = new Euler011();
        System.out.println(euler011.getSolution());
    }

    private void fileToGrid() {
        EulerReader fileReader = new EulerReader("resources/Euler011.txt");
        String[] fileLines = fileReader.readLines();

        for (int rowIndex = 0; rowIndex < 20; rowIndex++) {
            Scanner line = new Scanner(fileLines[rowIndex]);
            for (int colIndex = 0; colIndex < 20; colIndex++) {
                this.grid[rowIndex][colIndex] = line.nextInt();
            }
        }
    }

    private int maxQuad(int row, int col) {
        List<Integer> results = new ArrayList<>(Collections.nCopies(4, 1));


        for (int i = 0; i < 4; i++) {
            // calculate from right to results[0]
            if (col < 20 - 4) {
                results.set(0, results.get(0) * grid[row][col + i]);
            }
            // calculate from right-down to results[1]
            if ((col < 20 - 4) && (row < 20 - 4)) {
                results.set(1, results.get(1) * grid[row + i][col + i]);
            }
            // calculate from right-up to results[2]
            if ((col < 20 - 4) && (row > 2)) {
                results.set(2, results.get(2) * grid[row - i][col + i]);
            }
            // calculate from down to results[3]
            if (row < 20 - 4) {
                results.set(3, results.get(3) * grid[row + i][col]);
            }
        }
        return Collections.max(results);
    }

    public long getSolution() {
        long result = 0;
        for (int rowIndex = 0; rowIndex < 20; rowIndex++) {
            for (int colIndex = 0; colIndex < 20; colIndex++) {
                int testResult = maxQuad(rowIndex, colIndex);
                result = (testResult > result) ? testResult : result;
            }
        }
        return result;
    }
}
