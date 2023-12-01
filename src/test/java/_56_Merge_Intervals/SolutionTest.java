package _56_Merge_Intervals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  void name() {
//    [[4,5],[2,4],[4,6],[3,4],[0,0],[1,1],[3,5],[2,2]]
    int[][] a = new int[][]{new int[]{4, 5}, new int[]{2, 4}, new int[]{4, 6}, new int[]{3, 4}, new int[]{0, 0}, new int[]{1, 1}, new int[]{3, 5}, new int[]{2, 2}};
    Solution solution = new Solution();
    solution.merge(a);
  }
}