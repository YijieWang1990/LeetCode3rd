package _76_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Solution {
  public String minWindow(String s, String t) {
    int start = 0;
    int end = 0;
    int currentMin = Integer.MAX_VALUE;
    String result = "";
    Map<Character,Integer> tMap = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
    }
    Map<Character, Integer> referenceMap = new HashMap<>();

    while (end < s.length()) {
      while (!isMatch(referenceMap, tMap) && end < s.length()) {
        char current = s.charAt(end);
        if (tMap.containsKey(current)) {
          referenceMap.put(current, referenceMap.getOrDefault(current, 0) + 1);
        }
        end++;
      }
      if (end == s.length() && !isMatch(referenceMap, tMap)) {
        return result;
      }
      while (isMatch(referenceMap, tMap)) {
        char current = s.charAt(start);
        if (referenceMap.containsKey(current)) {
          referenceMap.put(current, referenceMap.get(current) - 1);
          if (referenceMap.get(current) == 0) {
            referenceMap.remove(current);
          }
        }
        start++;
      }

      int length = end - start + 1;
      if (length < currentMin) {
        currentMin = length;
        result = s.substring(start - 1, end);
      }
    }
    return result;
  }

  private boolean isMatch(Map<Character, Integer> a, Map<Character, Integer> b) {
    return b.entrySet().stream().allMatch(entry -> a.getOrDefault(entry.getKey(), 0) >= entry.getValue());
  }
}
