package javaeuler.euler;

public class Euler006 {
    /* Find the difference between the sum of the squares of the first
    /* one hundred natural numbers and the square of the sum.
     */
    public static void main(String[] args) {
        int output;
        int squareSum = 0;
        int numberSum = 0;

        for (int i = 1; i < 100; i++) {
            numberSum += i;
            squareSum += (int) Math.pow(i, 2);
        }
        output = (int) Math.pow(numberSum, 2) - squareSum;
        System.out.println(output);
    }


}