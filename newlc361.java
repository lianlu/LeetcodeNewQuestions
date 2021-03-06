// Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
// The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
// Note that you can only put the bomb at an empty cell.
//
// Example:
// For the given grid
//
// 0 E 0 0
// E 0 W E
// 0 E 0 0
//
// return 3. (Placing a bomb at (1,1) kills 3 enemies)
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
      int h = grid.length;
      if (h == 0) return 0;
      int w = grid[0].length;
      int left[][] = new int[h][w];
      int right[][] = new int[h][w];
      int top[][] = new int[h][w];
      int bottom[][] = new int[h][w];
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++){
          if (grid[i][j] == 'W') continue;
          else left[i][j] = ((grid[i][j] == 'E')?1:0) + ((j-1>=0)?left[i][j-1]:0);
        }
      }
      for (int i = 0; i < h; i++){
        for (int j = w-1; j >=0; j--){
          if (grid[i][j] == 'W') continue;
          else right[i][j] = ((grid[i][j] == 'E')?1:0) + ((j+1<w)?right[i][j+1]:0);
        }
      }
      for (int j = 0; j < w; j++){
        for (int i = 0; i < h; i++){
          if (grid[i][j] == 'W') continue;
          else top[i][j] = ((grid[i][j] == 'E')?1:0) + ((i-1>=0)?top[i-1][j]:0);
        }
      }
      for (int j = 0; j < w; j++){
        for (int i = h-1; i >= 0; i--){
          if (grid[i][j] == 'W') continue;
          else bottom[i][j] = ((grid[i][j] == 'E')?1:0) + ((i+1<h)?bottom[i+1][j]:0);
        }
      }
      int max = 0;
      for (int i = 0; i < h; i++)
      {
        for (int j = 0; j < w; j++){
          if (grid[i][j] == '0')
            max = Math.max(max, left[i][j]+right[i][j]+top[i][j]+bottom[i][j]);
        }
      }
      return max;
    }
}
