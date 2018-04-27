import com.sun.tools.javac.util.Assert;

public class MaxIncreaseToKeepCitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int len = grid.length;
        int[] row = new int[len];
        int[] column = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                row[j] = Math.max(row[j], grid[i][j]);
                column[i] = Math.max(column[i], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                res += Math.min(row[j], column[i]) - grid[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] { { 3, 0, 8, 4 }, { 2, 4, 5, 7 }, { 9, 2, 6, 3 }, { 0, 3, 1, 0 } };
        Assert.check(new MaxIncreaseToKeepCitySkyline().maxIncreaseKeepingSkyline(grid) == 35);
    }
}
