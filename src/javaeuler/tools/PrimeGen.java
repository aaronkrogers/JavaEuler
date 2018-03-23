package javaeuler.tools;

import io.herrmann.generator.Generator;
import java.util.ArrayList;
import java.util.List;

public class PrimeGen extends Generator<Integer> {
    private List<Integer> pastPrimes = new ArrayList<>();

    public PrimeGen() {
        pastPrimes.add(2);
    }

    @Override
    public void run() throws InterruptedException {
        int nextPrime;
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
            // javeee
            if (testPassed) {
                nextPrime = pastPrimes.get(pastPrimes.size() - 1);
                pastPrimes.add(testPrime);
                yield(nextPrime);
            }
        }
    }
}
