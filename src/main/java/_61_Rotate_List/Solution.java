package _61_Rotate_List;



class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || k == 0) {
      return head;
    }
    int length = getListLength(head);
    int stepToMove = k % length;
    if (stepToMove == 0) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    int move = 0;
    while (move < stepToMove) {
      fast = fast.next;
      move++;
    }
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    ListNode newHead = slow.next;
    fast.next = head;
    slow.next = null;
    return newHead;
  }

  private int getListLength(ListNode head) {
    int count = 0;
    ListNode index = head;
    while (index != null) {
      count++;
      index = index.next;
    }
    return count;
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
