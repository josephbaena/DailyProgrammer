import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by josephbaena on 8/29/15.
 * https://www.reddit.com/r/dailyprogrammer/comments/s6bas/4122012_challenge_39_easy/
 */
public class FizzBuzz {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= n; i++) {
            boolean printed = false;
            if (i % 3 == 0) {
                System.out.print("Fizz");
                printed = true;
            }
            if (i % 5 == 0) {
                System.out.print("Buzz");
                printed = true;
            }

            if (!printed) {
                System.out.print(i);
            }

            System.out.println();
        }
    }
}
