package BinarySearchTree;

import java.util.Scanner;

public class searchBST {
  static boolean searchInBST(TreeNode root, int value) {
    while(root != null) {
      if(root.data == value)
        return true;

      else if(value < root.data)
        root=root.left;

      else 
        root=root.right;
    }
    return false;
  }
  public static void main(String[] args) {
    
    TreeNode root=new TreeNode(8);
    root.left=new TreeNode(5);
    root.right=new TreeNode(12);
    root.left.left=new TreeNode(4);
    root.left.right=new TreeNode(7);
    root.left.right.left=new TreeNode(6);
    root.right.left=new TreeNode(10);
    root.right.right=new TreeNode(14);
    root.right.right.left=new TreeNode(13);

    Scanner s=new Scanner(System.in);
    System.out.println("Enter the value to be found in tree");
    int val=s.nextInt();

    if(searchInBST(root, val))
      System.out.println(val+" found in the Binary Search Tree");

    else System.out.println(val+" not found in the Binary Search Tree");
    s.close();
  }
}