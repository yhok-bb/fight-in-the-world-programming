import java.util.Arrays;

public class Rotate {
  public static void main(String[] args) {
    int[][] matrix = {
      {1,2,3},
      {4,5,6},
      {7,8,9},
    };

    rotate(matrix);

    int[][] matrix2 = {
      {1,  2,  3,  4,  5},
      {6,  7,  8,  9, 10},
      {11,12,13,14,15},
      {16,17,18,19,20},
      {21,22,23,24,25}
    };
    rotate(matrix2);
  }

  private static void rotate(int[][] matrix) {
    int n = matrix.length;
    for(int i=0; i < n-1; i++) {
      int tmp = matrix[0][i];
      matrix[0][i] = matrix[n-1-i][0];
      matrix[n-1-i][0] = matrix[n-1][n-1-i];
      matrix[n-1][n-1-i] = matrix[0][n-1-i];
      matrix[i][n-1] = tmp;
    }
    System.out.println(Arrays.deepToString(matrix));
  }
}