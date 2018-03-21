package javaeuler.tools;

import java.util.ArrayList;
import java.util.List;

public class PrimeGen implements Generator {
    private int nextPrime = 2;
    private List<Integer> pastPrimes = new ArrayList<>();

    @Override
    public Integer next() {
        pastPrimes.add(nextPrime);

        for (int np = nextPrime ;; ++np) {
            boolean testPassed = true;
            for (int prime : pastPrimes) {

                if (np % prime == 0) {
                    testPassed = false;
                    break;
                }
            }
            if (testPassed) {
                nextPrime = np;
                return pastPrimes.get(pastPrimes.size() - 1);
            }
        }
    }
}
