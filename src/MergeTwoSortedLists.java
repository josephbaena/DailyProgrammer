public class MergeTwoSortedLists {

    public static void main(String[] args) {
        int[] arr1 = new int[8];
        arr1[0] = 1;
        arr1[1] = 3;
        arr1[2] = 4;
        arr1[3] = 7;
        arr1[4] = 9;
        int[] arr2 = {2, 6, 8};

        printArray(arr1);
        printArray(arr2);

        merge(arr1, arr2, 5);

        printArray(arr1);
    }

    private static void merge(int[] arr1, int[] arr2, int last1) {
        int index1 = last1-1;
        int index2 = arr2.length-1;

        int mergedIndex = index1 + index2 + 1;

        while ((index1 >= 0) && (index2 >= 0)) {
            if (arr1[index1] > arr2[index2]) {
                arr1[mergedIndex] = arr1[index1];
                index1--;
                mergedIndex--;
            } else {
                arr1[mergedIndex] = arr2[index2];
                index2--;
                mergedIndex--;
            }
        }

        while (index2 >= 0) {
            arr1[mergedIndex] = arr2[index2];
            index2--;
            mergedIndex--;
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println("]");
    }

}
