package _98_Validate_Binary_Search_Tree;


import java.util.ArrayList;
import java.util.List;

class Solution {
  private List<Integer> nodeList = new ArrayList<>();

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    traverse(root);
    for (int i = 0; i < nodeList.size() - 1; i++) {
      if (nodeList.get(i) >= nodeList.get(i + 1)) {
        return false;
      }
    }
    return true;
  }

  private void traverse(TreeNode root) {
    if (root == null) {
      return;
    }
    traverse(root.left);
    nodeList.add(root.val);
    traverse(root.right);
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
