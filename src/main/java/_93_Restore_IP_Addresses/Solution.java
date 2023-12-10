package _93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
  private final List<List<String>> result = new ArrayList<>();

  private final List<String> ans = new ArrayList<>();

  public List<String> restoreIpAddresses(String s) {
    backtrace(s, 0);
    return result.stream().map(ipList -> String.join(".", ipList)).collect(Collectors.toList());
  }

  private void backtrace(String s, int start) {
    if (ans.size() == 4 && start == s.length()) {
      result.add(new ArrayList<>(ans));
      return;
    }
    if (start >= s.length()) {
      return;
    }
    if (ans.size() >= 4) {
      return;
    }
    for (int j = 1; j <= 3; j++) {
      if (start + j <= s.length()) {
        String ip = s.substring(start, start + j);
        if (isValidIp(ip)) {
          ans.add(ip);
          backtrace(s, start + j);
          ans.remove(ans.size() - 1);
        }
      }
    }
  }

  private boolean isValidIp(String s) {
    if (null == s || s.isBlank()) {
      return false;
    }
    if (s.length() > 1 && s.charAt(0) == '0') {
      return false;
    }
    try {
      int parseInt = Integer.parseInt(s);
      if (parseInt < 0 || parseInt > 255) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}