// Print a matrix in spiral fashion.
public class PrintMatrixSpiral {

    public static void main(String[] args) {
        int[][] matrix =
                {
                { 3, 4, 5, 6, 2, 5 },
                { 2, 4, 6, 2, 5, 7 },
                { 2, 5, 7, 8, 9, 3 },
                { 2, 4, 7, 3, 5, 8 },
                { 6, 4, 7, 3, 5, 7 } };

        printSpiral(matrix, 0);
    }

    private static void printSpiral(int[][] matrix, int depth) {
        if (matrix == null) return;
        if (matrix.length == 0) return;

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        if ((2 * depth) > Math.min(numRows, numCols)) return;

        // print top side, left to right
        for (int i = depth; i < numCols - depth - 1; i++) {
            System.out.print(matrix[depth][i] + " ");
        }

        // print right side, top to bottom
        for (int i = depth; i < numRows - depth - 1; i++) {
            System.out.print(matrix[i][numCols - depth - 1] + " ");
        }

        // print bottom side, right to left
        for (int i = numRows - depth; i > depth; i--) {
            System.out.print(matrix[numRows - depth - 1][i] + " ");
        }

        // print left side, bottom to top
        for (int i = numRows - depth - 1; i > depth; i--) {
            System.out.print(matrix[i][depth] + " ");
        }

        printSpiral(matrix, depth+1);
    }
}
