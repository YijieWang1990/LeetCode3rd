package _56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 1) {
      return intervals;
    }
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    int slow = 0;
    int fast = 1;
    List<int[]> result = new ArrayList<>();
    result.add(intervals[0]);
    int index = 0;
    while (fast < intervals.length) {
      if (result.get(index)[1] < intervals[fast][0]) {
        result.add(intervals[fast]);
        index++;
      } else {
        if (result.get(index)[1] <= intervals[fast][1]) {
          result.get(index)[1] = intervals[fast][1];
        }
      }
      fast++;
    }
    return result.toArray(new int[][]{});
  }
}
