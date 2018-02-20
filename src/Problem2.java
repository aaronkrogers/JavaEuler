public class Problem2 {
    private int thisI = 1;
    private int lastI = 0;

    public static void main(String[] args) {
        Problem2 p2 = new Problem2();
        int result = 0;
        int fib = 1;

        while (fib < 4000000) {
            if (fib % 2 == 0) {
                result += fib;
            }
            fib = p2.nextFib();
        }

        System.out.println(result);
    }

    private int nextFib() {
        int nextI = lastI + thisI;
        lastI = thisI;
        thisI = nextI;

        return nextI;
    }
}
