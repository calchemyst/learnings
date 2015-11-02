import java.util.Arrays;

/**
 * Created by afuller on 11/1/15.
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        spiral(matrix);

    }

    private static void spiral(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        int currRow = 0;
        int currColumn = 0;
        int numEntries = height*width;

        while (numEntries > 0) {
            // Go right.
            for (int i = currColumn; i < width -1; i++) {
                System.out.print(matrix[currRow][i] + " ");
                numEntries--;
            }
            int prevColumn = currColumn;
            currColumn = width -1;

            // Go down.
            for (int j = currRow; j < height -1; j++) {
                System.out.print(matrix[j][currColumn] + " ");
                numEntries--;
            }
            int prevRow = currRow;
            currRow = height -1;

            // Go left.
            for (int k = currColumn; k > prevColumn; k--) {
                System.out.print(matrix[currRow][k] + " ");
                numEntries--;
            }

            currColumn = prevColumn;
            // Go up.
            for (int k = currRow; k > prevRow; k--) {
                System.out.print(matrix[k][currColumn] + " ");
                numEntries--;
            }

            currRow = prevRow + 1;
            currColumn = prevColumn + 1;
            height--;
            width--;

        }
    }

}
