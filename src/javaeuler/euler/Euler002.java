package javaeuler.euler;

import javaeuler.tools.EulerProblem;

public class Euler002 extends EulerProblem {
    private int thisI = 1;
    private int lastI = 0;

    public static void main(String[] args) {
        EulerProblem problem = new Euler002();
        System.out.println(problem.getSolution());
    }

    public long getSolution() {
        Euler002 p2 = new Euler002();
        long result = 0;

        int fib = 1;
        while (fib < 4000000) {
            if (fib % 2 == 0) {
                result += fib;
            }
            fib = p2.nextFib();
        }

        return result;
    }

    private int nextFib() {
        int nextI = lastI + thisI;
        lastI = thisI;
        thisI = nextI;

        return nextI;
    }
}
