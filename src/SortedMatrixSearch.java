import java.io.BufferedReader;
import java.io.InputStreamReader;

// Given a matrix whose rows and columns are sorted, search for an element in that matrix.
public class SortedMatrixSearch {

    public static void main(String[] args) throws Exception {
        int[][] matrix = {
                { 5, 7, 8, 9 },
                { 6, 9, 11, 13 },
                { 7, 11, 12, 14 },
                { 8, 13, 16, 17 } };

        System.out.println("Enter a number tos earch for:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(reader.readLine());

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int minimum = matrix[0][0];
        int maximum = matrix[numRows-1][numCols-1];

        if ((target < minimum) || (target >  maximum)) {
            System.out.println("cannot find number");
            return;
        }

        // go through row by row
        if (searchMatrix(matrix, numRows, numCols, target)) {
            System.out.println("found!");
        } else {
            System.out.println("cannot find number");
        }
    }

    private static boolean searchMatrix(int[][] matrix, int numRows, int numCols, int target) {
        for (int row = 0; row < numRows; row++) {
            int localMin = matrix[row][0];
            int localMax = matrix[row][numCols-1];

            if ((target > localMin) && (target < localMax)) {
                for (int col = 0; col < numCols; col++) {
                    if (matrix[row][col] == target) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

}
