package _148_Sort_List;


class Solution {
  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode mid = findMid(head);
    ListNode secondHalf = mid.next;
    mid.next = null;
    ListNode first = mergeSort(head);
    ListNode second = mergeSort(secondHalf);
    return merge(first, second);
  }

  private ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;
    while (fast != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
      }
    }
    return prev;
  }

  private ListNode merge(ListNode first, ListNode second) {
    ListNode dummyHead = new ListNode();
    ListNode current = dummyHead;
    ListNode index1 = first;
    ListNode index2 = second;

    while (index1 != null || index2 != null) {
      if (index1 == null) {
        current.next = index2;
        current = current.next;
        index2 = index2.next;
      } else if (index2 == null) {
        current.next = index1;
        current = current.next;
        index1 = index1.next;
      } else {
        if (index1.val < index2.val) {
          current.next = index1;
          current = current.next;
          index1 = index1.next;
        } else {
          current.next = index2;
          current = current.next;
          index2 = index2.next;
        }
      }
    }
    return dummyHead.next;
  }


//  private ListNode mergeSort(ListNode head) {
//    ListNode index = head;
//    List<ListNode> nodeList = new ArrayList<>();
//    while (index != null) {
//      nodeList.add(index);
//      index = index.next;
//    }
//    nodeList.sort(Comparator.comparingInt(a -> a.val));
//    ListNode dummyHead = new ListNode();
//    index = dummyHead;
//    for (int i = 0; i < nodeList.size(); i++) {
//      index.next = nodeList.get(i);
//      index = index.next;
//    }
//    index.next = null;
//    return dummyHead.next;
//  }

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