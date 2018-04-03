package javaeuler.euler;

import javaeuler.tools.EulerProblem;
import java.math.BigInteger;

public class Euler016 extends EulerProblem {
    /* Power Digit Sum
    215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

    What is the sum of the digits of the number 21000?
     */
    public static void main(String[] args) {
        EulerProblem eulerProblem = new Euler016();
        System.out.println(eulerProblem.getSolution());
    }


    public long getSolution() {
        int result = 0;

        BigInteger number = new BigInteger("2").pow(1000);

        for (char digit : number.toString().toCharArray()) {
            result += Character.getNumericValue(digit);
        }
        return result;
    }
}
