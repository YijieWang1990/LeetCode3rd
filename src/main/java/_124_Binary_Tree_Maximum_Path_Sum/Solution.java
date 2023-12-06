package _124_Binary_Tree_Maximum_Path_Sum;


class Solution {
  private int max = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    int rootMax = calculatePathSum(root);
    return Math.max(max, rootMax);
  }

  private int calculatePathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = calculatePathSum(root.left);
    int right = calculatePathSum(root.right);
    int sumWithRoot = root.val + left + right;
    max = Math.max(max, sumWithRoot);
    max = Math.max(max, Math.max(Math.max(root.val + left, root.val + right), root.val));
    return Math.max(Math.max(root.val + left, root.val + right), root.val);
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
