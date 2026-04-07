import java.util.Arrays;

public class ZeroConvert {
  public static void main(String[] args) {
    int[][] matrix = {
      {1,2,3},
      {4,0,6},
      {7,8,0},
    };

    boolean[] rows = new boolean[matrix.length];
    boolean[] cols = new boolean[matrix[0].length];

    findZero(matrix, rows, cols);
    rowsConvert(matrix, rows);
    colsConvert(matrix, cols);

    for (int i = 0; i < matrix.length; i++) {
       System.out.println(Arrays.toString(matrix[i]));
     }
  }

  public static void findZero(int[][] matrix, boolean[] rows, boolean[] cols) {
    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[0].length; j++){
        if(matrix[i][j] == 0) {
          rows[i] = true;
          cols[j] = true;
        }
      }
    }
  }

  public static void rowsConvert(int[][] matrix, boolean[] rows) {
    for(int i = 0; i < rows.length; i++){
      if(rows[i]) {
        for(int j = 0; j < matrix[0].length; j++) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  public static void colsConvert(int[][] matrix, boolean[] cols) {
    for(int i = 0; i < cols.length; i++){
      if(cols[i]) {
        for(int j = 0; j < matrix.length; j++) {
          matrix[j][i] = 0;
        }
      }
    }
  }
}