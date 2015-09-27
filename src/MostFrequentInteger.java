import java.util.HashMap;
import java.util.Map;

/**
 * Created by josephbaena on 9/27/15.
 */

// Find the most frequent integer in an array
public class MostFrequentInteger {

    static int[] arr = {2, 4, 6, 3, 4, 6, 2, 8, 5, 7, 4, 5, 3, 2};

    public static void main(String[] args) {
        int arrLength = arr.length;
        Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();

        // populate frequency map
        for (int i = 0; i < arrLength; i++) {
            int num = arr[i];
            int existingCount = frequencies.containsKey(num) ? frequencies.get(num) : 0;
            frequencies.put(num, existingCount+1);
        }

        // find the most frequent key
        int maxKey = -1;
        int maxFrequency = -1;
        for (int key : frequencies.keySet()) {
            int value = frequencies.get(key);
            if (value > maxFrequency) {
                maxFrequency = value;
                maxKey = key;
            }
        }

        System.out.println("The most frequency integer is " + maxKey + " with frequency " + maxFrequency);
    }

}
