import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by josephbaena on 8/24/15.
 * https://www.reddit.com/r/dailyprogrammer/comments/3i99w8/20150824_challenge_229_easy_the_dottie_number/
 */
public class DottieNumber {

    public static double THRESHOLD = 0.001;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(reader.readLine());

        double previous = start;
        while (true) {
            double current = Math.cos(previous);
            if (Math.abs(current - previous) < THRESHOLD) {
                System.out.println(current);
                break;
            }
            previous = current;
        }
    }
}