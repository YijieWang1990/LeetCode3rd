package quick_sort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  void name() {
    Solution solution = new Solution();
    int[] nums = {7, 6, 5, 4, 3, 8, 9};
    solution.quickSort(nums);
    System.out.println(Arrays.toString(nums));
  }
}