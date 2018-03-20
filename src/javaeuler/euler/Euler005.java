package javaeuler.euler;

public class Euler005 {
    /* 2520 is the smallest number that can be divided by
    /* each of the numbers from 1 to 10 without any remainder.
    /* What is the smallest positive number that is evenly
    /* divisible by all of the numbers from 1 to 20?
    */

    public static void main(String[] args) {

        int limit = 20;

        int[] numbers = new int[limit-1];
        for (int num = 1; num < limit; num++) {
            numbers[num-1] = num;
        }

        System.out.println(lcm(numbers));
    }

    static int lcm(int[] numbers) {
        int result = 1;
        for (int num : numbers) {
            result = lcm(result, num);
        }
        return result;
    }

    static int lcm(int x, int y) {
        if (y < x) {
            int t = x;
            x = y;
            y = t;
        }

        int nextX, nextY;
        for (nextX = x ;; nextX += x) {
            for (nextY = y; nextY < nextX; nextY += y) {
            }
            if (nextX == nextY) {
                break;
            }
        }

        return nextX;
    }
}
