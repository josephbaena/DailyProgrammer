import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by josephbaena on 9/27/15.
 */
public class Fibonacci {

    private static Map<Integer, Integer> dpMap = new HashMap<Integer, Integer>();

    public static int dpFibonacci(int n) {
        if ((n == 0) || (n == 1)) return n; // 0 or 1

        if (!dpMap.containsKey(n)) {
         dpMap.put(n, dpFibonacci(n - 1) + dpFibonacci(n - 2));
        }

        return dpMap.get(n);
    }

    // O(2^n) implementation
    public static int recFibonacci(int n) {
        if ((n == 0) || (n == 1)) return n; // 0 or 1

        return recFibonacci(n - 1) + recFibonacci(n - 2);
    }

    // iterative implementation
    public static int iterFibonacci(int n) {
        if ((n == 0) || (n == 1)) return n; // 0 or 1

        // at this point, n >= 2
        int x1 = 0;
        int x2 = 1;
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = x1 + x2;
            x1 = x2;
            x2 = sum;
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lengthOfSeries = Integer.parseInt(reader.readLine());

        assert(lengthOfSeries >= 0);

        for (int i = 1; i <= lengthOfSeries; i++) {
            System.out.println(i + ":\t" + dpFibonacci(i));
        }
    }
}
