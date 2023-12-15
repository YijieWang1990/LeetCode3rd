package _23_Merge_k_Sorted_Lists;


class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    return mergeLists(lists, 0, lists.length - 1);
  }

  private ListNode mergeLists(ListNode[] lists, int start, int end) {
    if (start == end) {
      return lists[start];
    }
    if (start + 1 == end) {
      return mergeTwoLists(lists[start], lists[end]);
    }
    int mid = start + (end - start) / 2;
    ListNode firstHalf = mergeLists(lists, start, mid);
    ListNode secondHalf = mergeLists(lists, mid + 1, end);
    return mergeTwoLists(firstHalf, secondHalf);
  }

  private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummyHead = new ListNode();
    ListNode curr = dummyHead;
    ListNode p1 = list1;
    ListNode p2 = list2;
    while (p1 != null || p2 != null) {
      if (p1 == null) {
        curr.next = p2;
        curr = curr.next;
        p2 = p2.next;
      } else if (p2 == null) {
        curr.next = p1;
        curr = curr.next;
        p1 = p1.next;
      } else {
        if (p1.val <= p2.val) {
          curr.next = p1;
          curr = p1;
          p1 = p1.next;
        } else {
          curr.next = p2;
          curr = curr.next;
          p2 = p2.next;
        }
      }
    }
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