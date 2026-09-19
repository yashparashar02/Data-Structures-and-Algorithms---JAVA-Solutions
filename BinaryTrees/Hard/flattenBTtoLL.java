package BinaryTrees.Hard;

import BinaryTrees.TreeNode;

public class flattenBTtoLL {
  static TreeNode prev=null;

  static void flatten(TreeNode root) {
    if(root == null)
      return;

    flatten(root.right);
    flatten(root.left);

    root.right=prev;
    root.left=null;

    prev=root;
  }
  static void printFlattened(TreeNode root) {
    while(root != null) {
      System.out.print(root.data);

      if(root.right != null) {
        System.out.print(" -> ");
      }

      root=root.right;
  }
  System.out.println();
}
  public static void main(String[] args) {
    
    TreeNode root = new TreeNode(1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(3);
    root.left.left=new TreeNode(4);
    root.left.right=new TreeNode(5);
    root.right.left=new TreeNode(6);
    root.right.right=new TreeNode(7);
    root.left.left.left=new TreeNode(8);
    root.left.left.right=new TreeNode(9);
    root.left.right.left=new TreeNode(10);
    root.left.right.right=new TreeNode(11);

    prev=null;
    flatten(root);
    System.out.println("The Flattened Binary Tree is: ");
    printFlattened(root);
  }
}