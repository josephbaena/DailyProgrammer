import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by josephbaena on 8/25/15.
 * https://www.reddit.com/r/dailyprogrammer/comments/3fmke1/20150803_challenge_226_easy_adding_fractions/
 */
public class AddFractions {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numFractions = Integer.parseInt(reader.readLine());
        int numerator = 0, denominator = 1;

        // add up all the fracrtions, don't simplify yet
        for (int i = 0; i < numFractions; i++) {
            String line = reader.readLine();
            String[] tokens = line.split("/");
            int currNumerator = Integer.parseInt(tokens[0]);
            int currDenominator = Integer.parseInt(tokens[1]);

            int newNumerator = numerator*currDenominator + denominator*currNumerator;
            int newDenominator = denominator * currDenominator;

            numerator = newNumerator;
            denominator = newDenominator;
        }

        // simplify the fraction
        int divisor = gcd(numerator, denominator);

        if (divisor != 0) {
            numerator /= divisor;
            denominator /= divisor;
        }

        System.out.println(numerator + "/" + denominator);
    }

    static int gcd(int a, int b) {
        if(a == 0 || b == 0) {
            return a+b;
        }
        return gcd(b, a % b);
    }
}
