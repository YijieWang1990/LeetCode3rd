package _2_Add_Two_Numbers;



class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode();
    ListNode p = result;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int a = 0;
      int b = 0;
      if (l1 != null) {
        a = l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        b = l2.val;
        l2 = l2.next;
      }
      int sum = a + b + carry;
      carry = sum / 10;
      p.next = new ListNode(sum % 10);
      p = p.next;
    }
    return result.next;
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