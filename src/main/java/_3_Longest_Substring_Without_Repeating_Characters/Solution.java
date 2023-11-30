package _3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    int slow = 0;
    int fast = 0;
    int longest = 0;
    Set<Character> characterSet = new HashSet<>();
    int length = s.length();

    while (fast < length) {
      char currentChar = s.charAt(fast);
      if (characterSet.contains(currentChar)) {
        while (characterSet.contains(currentChar)) {
          characterSet.remove(s.charAt(slow));
          slow++;
        }
      }
      characterSet.add(currentChar);
      longest = Math.max(longest, fast - slow + 1);
      fast++;
    }
    return longest;
  }
}