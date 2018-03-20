package javaeuler.euler;


public class Euler004 {
    /* Largest Palindrome Product
     * A palindromic number reads the same both ways. The largest
     * palindrome made from the product of two 2-digit numbers is
     * 9009 = 91 * 99.
     * Find the largest palindrome made from the product of two
     * 3-digit numbers.
     */
    public static void main(String[] args) {
        int result = 0;
        int palTest;

        for (int x=100; x<1000; ++x) {
            for (int y=100; y<x; ++y) {
                palTest = x * y;
                if (isPalindrome(palTest) && palTest>result) {
                    result = palTest;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean isPalindrome(int num) {
        int n = num;
        int rev = 0;
        int dig;

        while (n > 0) {
            dig = n % 10;
            rev = rev * 10 + dig;
            n = n / 10;
        }
        return (num == rev);
    }
}
