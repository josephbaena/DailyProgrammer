/**
 * How to implement a function to check whether there is a path for a string in a matrix of characters?
 * It moves to left, right, up and down in a matrix, and a cell for a movement.
 * The path can start from any entry in a matrix.
 * If a cell is occupied by a character of a string on the path, it cannot be occupied by another character again.
 */
public class StringPathInMatrix {

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};

        boolean hasPath = hasPath(matrix, "bcced", new boolean[matrix.length][matrix[0].length]);

        System.out.println("Has path? " + (hasPath ? "yes!" : "no"));
    }

    public static boolean hasPath(char[][] matrix, String str, boolean[][] visited) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (hashPathCore(matrix, str, visited, i, j, 0)) return true;
            }
        }

        return false;
    }

    public static boolean hashPathCore(char[][] matrix, String str, boolean[][] visited, int row, int col, int length) {
        if (length == 0) return true;
        int nRows = matrix.length, nCols = matrix[0].length;

        boolean hasPath = false;
        if ((row >= 0) && (row < nRows) && (col >= 0) && (col < nCols)) {
            if (matrix[row][col] == str.charAt(length)) {
                if (visited[row][col] == false) {
                    length++;
                    visited[row][col] = true;

                    hasPath = hashPathCore(matrix, str, visited, row-1, col, length)
                            || hashPathCore(matrix, str, visited, row, col-1, length)
                            || hashPathCore(matrix, str, visited, row+1, col, length)
                            || hashPathCore(matrix, str, visited, row, col+1, length);

                    if (hasPath == false) {
                        length--;
                        visited[row][col] = false;
                    }

                }
            }
        }
        return hasPath;
    }

}
