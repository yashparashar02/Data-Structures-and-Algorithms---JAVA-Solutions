package BinaryTrees.MediumProblems;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode() {}
  TreeNode(int val) {
    this.val=val;
  }

  TreeNode (int val, TreeNode left, TreeNode right) {
    this.val=val;
    this.left=left;
    this.right=right;
  }
}

public class leftView {
  static List<Integer> view(TreeNode root) {
    List<Integer> result=new ArrayList<>();

    dfs(root, 0, result);

    return result;
  }
  static void dfs(TreeNode node, int level, List<Integer> result) {
    if(node == null)
      return;

    if(level == result.size())
      result.add(node.val);

    dfs(node.right, level+1, result);
    dfs(node.left, level+1, result);
  }
  public static void main(String[] args) {
    
    TreeNode root=new TreeNode(1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(3);
    root.left.left=new TreeNode(4);
    root.left.right=new TreeNode(5);
    root.left.right.left=new TreeNode(8);
    root.right.left=new TreeNode(6);
    root.right.left.right=new TreeNode(9);
    root.right.right=new TreeNode(7);
    root.right.right.right=new TreeNode(10);

    System.out.println("The Left View of the Binary Tree is "+view(root));
  }
}