import java.util.*;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class TwiceExceptOne {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 3, 1, 4};
        printArray(arr);

        System.out.println(find_ineff(arr));
        System.out.println(find_ineff2(arr));
        System.out.println(find_eff(arr));
    }

    private static Integer find_ineff(int[] arr) {
        Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>(arr.length);

        for (int i : arr) {
            if (!frequencies.containsKey(i)) {
                frequencies.put(i, 1);
            } else {
                int temp = frequencies.get(i);
                frequencies.put(i, temp + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }

        return null;
    }

    private static Integer find_ineff2(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i : arr) {
            if (!set.add(i)) set.remove(i);
        }

        if (set.size() != 1) return null;

        Iterator<Integer> it = set.iterator();
        return it.next();
    }

    private static Integer find_eff(int[] arr) {
        int x = 0;
        for (int i : arr) {
            x ^= i;
        }
        return x;
    }

    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println("]");
    }
}
