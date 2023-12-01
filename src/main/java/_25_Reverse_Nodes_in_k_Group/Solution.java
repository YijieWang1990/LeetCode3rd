package _25_Reverse_Nodes_in_k_Group;

import java.util.Stack;

class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummyHead = new ListNode();
    dummyHead.next = head;
    ListNode current = head;
    ListNode prev = dummyHead;
    while (current != null) {
      ListNode nextHead = getNextHead(current, k);
      prev.next = reverse(current, k, nextHead);
      while (current != nextHead) {
        prev = current;
        current = current.next;
      }
    }
    return dummyHead.next;
  }

  private ListNode reverse(ListNode current, int k, ListNode nextHead) {
    ListNode dummyHead = new ListNode();
    dummyHead.next = current;
    Stack<ListNode> stack = new Stack<>();
    while (current != null && stack.size() < k) {
      stack.push(current);
      current = current.next;
    }
    if (stack.size() < k) {
      return dummyHead.next;
    }
    ListNode cur = dummyHead;
    while (!stack.isEmpty()) {
      ListNode nextNode = stack.pop();
      cur.next = nextNode;
      cur = cur.next;
    }
    cur.next = nextHead;
    return dummyHead.next;
  }

  private ListNode getNextHead(ListNode head, int k) {
    ListNode result = head;
    while (result != null && k > 0) {
      result = result.next;
      k--;
    }
    return result;
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

