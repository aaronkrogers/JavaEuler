package javaeuler.euler;

import javaeuler.tools.EulerProblem;
import javaeuler.tools.EulerReader;

import java.util.*;

public class Euler022 extends EulerProblem {
    /* Names Scores
    Using resources/Euler022.txt, a 46K text file containing over five-thousand first names,
    begin by sorting it into alphabetical order. Then working out the alphabetical value for
    each name, multiply this value by its alphabetical position in the list to obtain a name score.

    For example, when the list is sorted into alphabetical order,
    COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name
    in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

    What is the total of all the name scores in the file?
     */
    public static void main(String[] args) {
        EulerProblem problem = new Euler022();
        System.out.println(problem.getSolution());
    }

    public long getSolution() {
        // create result to store the sum of all name scores
        long result = 0;

        // use custom reader to fetch all names from file
        EulerReader reader = new EulerReader("resources/Euler022.txt");
        // store all names found in the file into a TreeSet
        // for default sorting
        Set<String> names;
        names = new TreeSet<>(Arrays.asList(reader.read()
                        .replaceAll("\"", "")
                        .split(",")));

        int index = 0;
        long score;
        for (String name : names) {
            score = 0;  // reset score for new name
            index++;    // increment index for new name
            // for each character in the given name,
            // get that character's place in the alphabet
            // and add the alphabet index to score
            for (Character i : name.toCharArray()) {
                score += Character.getNumericValue(i) - 9;
            }
            result += score * index;    // add score(score * index) to result
        }
        return result;
    }
}
