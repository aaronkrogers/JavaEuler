package javaeuler.euler;

import javaeuler.tools.EulerProblem;
import javaeuler.tools.EulerReader;

import java.util.ArrayList;
import java.util.List;

public class Euler018 extends EulerProblem {
    private List<List<Integer>> lines = new ArrayList<>();

    public static void main(String[] args) {
        EulerProblem eulerProblem = new Euler018();
        System.out.println(eulerProblem.getSolution());
    }

    private void buildFrom(String fileName) {
        EulerReader file = new EulerReader(fileName);

        // for each line in the given file
        for (int i = 0; i < file.readLines().length; i++) {

            // create a new list containing the
            // integer value of each number in the line
            List<Integer> newLine = new ArrayList<>();

            for (String num : file.readLine(i).split(" ")) {
                newLine.add(Integer.valueOf(num));
            }

            // add newly created list to this.lines
            lines.add(newLine);
        }
    }

    private List<Integer> addLists(List<Integer> list1, List<Integer> list2) {
        /* addLists(List<Integer> list1, List<Integer> list2)
        return a new list containing the sum of each element
        in list1 with it's respective element from list2
         */

        if (list1.size() != list2.size()) {
            throw new IllegalArgumentException("list1 and list2 must be equal in size");
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {
            result.add(list1.get(i) + list2.get(i));
        }

        return result;
    }

    private List<Integer> reduceList(List<Integer> list) {
        List<Integer> result = new ArrayList<>();

        // add the maximum of each (index, index+1)
        // pair to list "result"
        for (int i = 0 ; i < list.size()-1; i++) {
            result.add(Integer.max(list.get(i), list.get(i+1)));
        }

        return result;
    }

    private void reduceLists() {
        while (lines.size() > 1) {
            List<Integer> lastLine = lines.get(lines.size() - 1); lines.remove(lastLine);
            List<Integer> nextLastLine = lines.get(lines.size() - 1); lines.remove(nextLastLine);
            lastLine = reduceList(lastLine);
            lines.add(addLists(nextLastLine, lastLine));
        }
    }

    @Override
    public long getSolution() {
        return getSolution("resources/Euler018.txt");
    }

    public long getSolution(String fileName) {
        buildFrom(fileName);
        reduceLists();
        return lines.get(0).get(0);
    }
}
