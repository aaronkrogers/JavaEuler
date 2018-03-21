package javaeuler.tools;

public class Primes {
    public static int getNthPrime(int n) {
        assert (n > 0);

        Generator primeGen = new PrimeGen();

        for (int np = 1; np < n; np++) {
            primeGen.next();
        }

        return (int) primeGen.next();
    }
}
