import java.util.Arrays;


public class GridTravelerTabulation {
  public static void main(String ... args) {
    System.out.println("Number of ways: " + gridTraveler(4, 4));
  }


  private static int gridTraveler(int m, int n) {
    int[][] grid = new int[m][n];
    grid[1][1] = 1;
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (j < n - 1) grid[i][j + 1] += grid[i][j];
        if (i < m - 1) grid[i + 1][j] += grid[i][j];
      }
    }
    System.out.println("Resulting grid: " + Arrays.deepToString(grid));
    return grid[m - 1][n - 1];
  }
}
