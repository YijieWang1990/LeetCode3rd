package LCR_143;


class Solution {
  public boolean isSubStructure(TreeNode A, TreeNode B) {
    if (B == null) {
      return false;
    }
    if (A == null) {
      return false;
    }
    return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
  }

  private boolean isSub(TreeNode a, TreeNode b) {
    if (b == null) {
      return true;
    }
    if (a == null) {
      return false;
    }
    if (a.val == b.val) {
      return isSub(a.left, b.left) && isSub(a.right, b.right);
    }
    return false;
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}