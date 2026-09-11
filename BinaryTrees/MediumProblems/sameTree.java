package BinaryTrees.MediumProblems;

import BinaryTrees.TreeNode;

public class sameTree {
  static boolean isSame(TreeNode tree1, TreeNode tree2) {
    if(tree1 == null && tree2 == null)
      return true;

    if(tree1 == null || tree2 == null)
      return false;

    if(tree1.data != tree2.data)
      return false;

    return isSame(tree1.left, tree2.left) && isSame(tree1.right, tree2.right);
  }
  public static void main(String arr[]) {

    TreeNode tree1=new TreeNode(1), tree2=new TreeNode(1);
    tree1.left=new TreeNode(2); tree2.left=new TreeNode(2);
    tree1.right=new TreeNode(3); tree2.right=new TreeNode(3);
    
    if(isSame(tree1, tree2) == true)
      System.out.println("Yes both trees are same");
    else 
      System.out.println("No both trees are not same");
  }
}