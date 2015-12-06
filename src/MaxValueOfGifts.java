/**
 * A board has n*m cells, and there is a gift with some value (value is greater than 0) in every cell.
 * You can get gifts starting from the top-left cell, and move right or down in each step,
 * and finally reach the cell at the bottom-right cell.
 * What’s the maximal value of gifts you can get from the board?
 */
public class MaxValueOfGifts {

    public static void main(String[] args) {
        int[][] board = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};

        System.out.println("The maximum value of gifts on the board is " + maxValueOptimized(board) + ".");
    }

    private static int maxValue(int[][] board) {
        int nRows = board.length;
        int nCols = board[0].length;

        int[][] maxValuesBoard = new int[nRows][nCols];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                int left = 0, above = 0;

                if (i > 0) {
                    above = maxValuesBoard[i-1][j];
                }

                if (j > 0) {
                    left = maxValuesBoard[i][j-1];
                }

                maxValuesBoard[i][j] = Math.max(left, above) + board[i][j];
            }
        }

        return maxValuesBoard[nRows-1][nCols-1];
    }

    private static int maxValueOptimized(int[][] board) {
        int nRows = board.length;
        int nCols = board[0].length;

        int[] maxValuesBoard = new int[nCols];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                int left = 0, above = 0;

                if (i > 0) {
                    above = maxValuesBoard[j];
                }

                if (j > 0) {
                    left = maxValuesBoard[j-1];
                }

                maxValuesBoard[j] = Math.max(left, above) + board[i][j];
            }
        }

        return maxValuesBoard[nCols-1];
    }

}
