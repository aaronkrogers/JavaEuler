package javaeuler.tools;

import java.util.ArrayList;
import java.util.List;

public class PrimeGen {
    private List<Integer> pastPrimes = new ArrayList<>();

    public PrimeGen() {
        pastPrimes.add(2);
    }

    public Integer nextPrime() {
        Integer result = 0;
        int testPrime = pastPrimes.get(pastPrimes.size() - 1);
        while (++testPrime > 0) {
            boolean testPassed = true;
            for (int prime : pastPrimes) {
                if (prime > Math.sqrt(testPrime)) {
                    testPassed = true;
                    break;
                }

                if (testPrime % prime == 0) {
                    testPassed = false;
                    break;
                }
            }
            if (testPassed) {
                result = pastPrimes.get(pastPrimes.size() - 1);
                pastPrimes.add(testPrime);
                return result;
            }
        }
        return result;
    }
}
