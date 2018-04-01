package javaeuler.euler;

import javaeuler.tools.EulerProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Euler014 extends EulerProblem{
    /* Longest Collatz sequence

    The following iterative sequence is defined for the set of positive integers:

    n → n/2 (n is even)
    n → 3n + 1 (n is odd)

    Using the rule above and starting with 13, we generate the following sequence:

    13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
    It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
    Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

    Which starting number, under one million, produces the longest chain?
     */
    private Map<Integer, List<Integer>> knownChains = new HashMap<>();

    public static void main(String[] args) {
        Euler014 problem = new Euler014();
        problem.generateChains(1, 10);
        System.out.println(problem.knownChains);
    }

    private void generateChains(int start, int limit) {
        knownChains.put(start, new ArrayList<>());
        for (int chainStart = start; chainStart < limit; chainStart++) {
            System.out.println(chainStart);
            int nextLink;
            if (!knownChains.containsKey(chainStart)) {
                knownChains.get(chainStart).add(chainStart);
                nextLink = (chainStart % 2 == 0) ? (chainStart / 2) : (3 * chainStart + 1);
                generateChains(nextLink, limit);
                System.out.println(nextLink);
                System.out.println(knownChains.get(nextLink));
                System.out.println("TEST");
                knownChains.get(chainStart).addAll(knownChains.get(nextLink));
                System.out.println("WEST");
            }
        }
    }

    public long getSolution() {
        return 10L;
    }
}
