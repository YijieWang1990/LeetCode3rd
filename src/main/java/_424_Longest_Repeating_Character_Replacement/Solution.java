package _424_Longest_Repeating_Character_Replacement;

class Solution {
  public int characterReplacement(String s, int k) {
    int[] nums = new int[26];
    int low = 0;
    int high = 0;
    int max = 0;
    while (high < s.length()) {
      char currentChar = s.charAt(high);
      nums[currentChar - 'A']++;
      max = Math.max(max, nums[currentChar - 'A']);
      if (high - low + 1 - max > k) {
        nums[s.charAt(low) - 'A']--;
        low++;
      }
      high++;
    }
    return high - low;
  }
}
//aabaacaa