import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Number of ways to climb " + n + " steps: " + climb(n));
    }

    private static Map<Integer, Integer> storage = new HashMap<Integer, Integer>();
    private static int climb(int nSteps) {
        if (nSteps <= 2) {
            return nSteps;
        }

        if (!storage.containsKey(nSteps)) {
            storage.put(nSteps, climb(nSteps-1) + climb(nSteps-2));
        }

        return storage.get(nSteps);
    }
}
