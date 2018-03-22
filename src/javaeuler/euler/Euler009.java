package javaeuler.euler;

public class Euler009 {
    /* Special Pythagorean Triplet
    A Pythagorean triplet is a set of three natural numbers, a < b < c,
    for which, a2 + b2 = c2
    For example, 32 + 42 = 9 + 16 = 25 = 52.
    There exists exactly one Pythagorean triplet for which a + b + c = 1000.
    Find the product abc.
    */
    public static void main(String[] args) {
        System.out.println(getResult());
    }

    private static Integer getResult() {
        for (int c = 0; c < 1000; c++) {
            for (int a = 1; a < 1000-c ; a++) {
                int b = 1000 - c - a;
                if (isPythagoreanTriplet(a, b, c)) {
                    return a * b * c;
                }
            }
        }
        return null;
    }

    private static boolean isPythagoreanTriplet(int a, int b, int c) {
        return (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2));
    }
}
