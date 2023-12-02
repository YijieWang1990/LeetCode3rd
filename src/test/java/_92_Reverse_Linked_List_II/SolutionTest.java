package _92_Reverse_Linked_List_II;


import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  void name() {
    Solution solution = new Solution();
    Solution.ListNode listNode1 = new Solution.ListNode(1);
    Solution.ListNode listNode2 = new Solution.ListNode(2);
    Solution.ListNode listNode3 = new Solution.ListNode(3);
    Solution.ListNode listNode4 = new Solution.ListNode(4);
    Solution.ListNode listNode5 = new Solution.ListNode(5);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode5;
    solution.reverseBetween(listNode1, 2, 4);
  }
}