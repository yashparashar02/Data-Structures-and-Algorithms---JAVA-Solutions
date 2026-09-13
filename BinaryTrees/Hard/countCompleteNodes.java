package BinaryTrees.Hard;

import BinaryTrees.TreeNode;

public class countCompleteNodes {
  static int countNodes(TreeNode root) {
    if(root == null)
      return 0;

    int left=getHeightLeft(root), right=getHeightRight(root);

    if(left == right)
      return ((2 << (left)) - 1);

    else 
      return countNodes(root.left) + countNodes(root.right) + 1;
  }
  static int getHeightLeft(TreeNode root) {
    int count=0;
    while(root.left != null) {
      count++;
      root=root.left;
    }
    return count;
  }
  static int getHeightRight(TreeNode root) {
    int count=0;
    while(root.right != null) {
      count++;
      root=root.right;
    }
    return count;
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

    System.out.println("The No. of Complete Binary Tree Nodes are: "+countNodes(root));
  }
}