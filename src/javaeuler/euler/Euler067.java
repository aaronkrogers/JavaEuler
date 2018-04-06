package javaeuler.euler;

import javaeuler.tools.EulerProblem;

public class Euler067 extends Euler018 {
    public static void main(String[] args) {
        EulerProblem eulerProblem = new Euler067();
        System.out.println(eulerProblem.getSolution());
    }

    @Override
    public long getSolution() {
        return super.getSolution("resources/Euler067.txt");
    }
}
