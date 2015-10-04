import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by josephbaena on 9/27/15.
 */
public class Fibonacci {

    public static int recFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return recFibonacci(n - 1) + recFibonacci(n - 2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lengthOfSeries = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= lengthOfSeries; i++) {
            System.out.println(recFibonacci(i) + "\t");
        }
    }
}
