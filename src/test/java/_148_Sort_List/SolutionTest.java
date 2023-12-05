package _148_Sort_List;

import static _148_Sort_List.Solution.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  void name() {
    ListNode n1 = new ListNode(4);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(1);
    ListNode n4 = new ListNode(3);
//

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;


    Solution solution = new Solution();
    solution.mergeSort(n1);
  }
}