package _143_Reorder_List;


import java.util.Stack;

class Solution {
  public void reorderList(ListNode head) {
    ListNode current = head;
    Stack<ListNode> stack = new Stack<>();
    while (current != null) {
      stack.add(current);
      current = current.next;
    }
    current = head;
    int total = stack.size();
    while (stack.size() > total / 2 + 1) {
      ListNode pop = stack.pop();
      pop.next = current.next;
      current.next = pop;
      current = pop.next;
    }
    stack.peek().next = null;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
