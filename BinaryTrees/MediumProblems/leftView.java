package BinaryTrees.MediumProblems;

import BinaryTrees.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class leftView {
  static List<Integer> viewLeft(TreeNode root) {
    List<Integer> result=new ArrayList<>();

    dfs(root, 0, result);

    return result;
  }
  static void dfs(TreeNode node, int level, List<Integer> result) {
    if(node == null)
      return;

    if(level == result.size())
      result.add(node.data);

    dfs(node.left, level+1, result);
    dfs(node.right, level+1, result);
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

    System.out.println("The Left View of the Binary Tree is "+viewLeft(root));
  }
}