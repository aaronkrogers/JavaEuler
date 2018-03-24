package javaeuler.euler;

import javaeuler.tools.EulerProblem;
import javaeuler.tools.FileReader;

import java.math.BigInteger;

public class Euler013 implements EulerProblem {
    public static void main(String[] args) {
        EulerProblem problem = new Euler013();
        System.out.println(problem.getSolution());
    }

    public long getSolution() {
        BigInteger result = BigInteger.ZERO;
        FileReader file = new FileReader("resources/Euler013.txt");
        for (String line : file.lines) {
            result = result.add(new BigInteger(line));
        }
        return getNDigits(result, 10);
    }

    private static long getNDigits(BigInteger number, int n) {
        String result = number.toString();
        return new Long(result.substring(0, 10));
    }
}
