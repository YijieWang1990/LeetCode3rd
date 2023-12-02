package _92_Reverse_Linked_List_II;


import java.util.Stack;

class Solution {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummyHead = new ListNode();
    dummyHead.next = head;
    ListNode curr = dummyHead;
    int count = 1;
    while (count < left) {
      curr = curr.next;
      count++;
    }
    ListNode reversePrev = curr;
    count = right - left + 1;
    while (count > 0) {
      curr = curr.next;
      count--;
    }
    ListNode reverseEnd = curr;
    ListNode reverseTail = curr.next;
    reversePrev.next = reverse(reversePrev.next, reverseEnd, reverseTail);
    return dummyHead.next;
  }

  private ListNode reverse(ListNode start, ListNode end, ListNode tail) {
    ListNode dummyHead = new ListNode();
    dummyHead.next = start;
    ListNode curr = start;
    Stack<ListNode> listNodeStack = new Stack<>();
    while (curr != tail) {
      listNodeStack.push(curr);
      curr = curr.next;
    }
    curr = dummyHead;
    while (!listNodeStack.isEmpty()) {
      curr.next = listNodeStack.pop();
      curr = curr.next;
    }
    curr.next = tail;
    return dummyHead.next;
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
