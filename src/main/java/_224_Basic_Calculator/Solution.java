package _224_Basic_Calculator;

import java.util.Stack;

class Solution {
  public int calculate(String s) {
    Stack<Integer> symbol = new Stack<>();
    symbol.push(1);
    int sign = 1;

    long sum = 0;

    int index = 0;
    while (index < s.length()) {
      char currentChar = s.charAt(index);
      if (currentChar == ' ') {
        index++;
      } else if (currentChar == '+') {
        sign = symbol.peek();
        index++;
      } else if (currentChar == '-') {
        sign = -symbol.peek();
        index++;
      } else if (currentChar == '(') {
        symbol.push(sign);
        index++;
      } else if (currentChar == ')') {
        symbol.pop();
        index++;
      } else {
        int start = index;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
          index++;
        }
        String numberString = s.substring(start, index);
        sum += sign * Long.parseLong(numberString);
      }
    }
    return (int)sum;
  }
}