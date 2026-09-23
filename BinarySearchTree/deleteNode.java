package BinarySearchTree;

import java.util.Scanner;

public class deleteNode {
  static TreeNode delete(TreeNode root, int key) {
    if(root == null) 
      return null;

    if(root.data == key) 
      return helper(root);

    TreeNode dummy = root;
    while(root != null) {
      if(root.data > key) {
        if(root.left != null && root.left.data == key) {
          root.left=helper(root.left);
          break;
        } 
        else root = root. left;
      } 
      else {
        if(root.right != null && root.right.data == key) {
          root.right = helper(root.right);
          break;
        } 
        else
          root = root.right;
      }
    }
    return dummy;
  }
  static  TreeNode helper(TreeNode root) {
    if(root.left == null) 
      return root.right;
    
    else if(root.right == null)
      return root.left;
    
    else {
      TreeNode rightChild = root.right;
      TreeNode lastRight = findLastRight(root.left);
      lastRight.right = rightChild;
      return root.left;
    }
  }
  static  TreeNode findLastRight(TreeNode root) {
    if(root.right == null)
      return root;

    return findLastRight(root.right);
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    TreeNode root=new TreeNode(8);
    root.left=new TreeNode(5);
    root.right=new TreeNode(12);
    root.left.left=new TreeNode(4);
    root.left.right=new TreeNode(7);
    root.left.right.left=new TreeNode(6);
    root.right.left=new TreeNode(10);
    root.right.right=new TreeNode(14);
    root.right.right.left=new TreeNode(13);

    System.out.println("Enter the Key value you want to delete from the BST");
    int key=s.nextInt();

    TreeNode result=delete(root, key);
    System.out.println("The Root of the updated BST after Deletion is: "+result.data);
    s.close();
  }
}