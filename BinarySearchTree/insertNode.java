package BinarySearchTree;

import java.util.Scanner;

public class inserNode {
  static TreeNode insert(TreeNode root, int val) {
    if(root == null)
      return new TreeNode(val);

      TreeNode curr=root;

      while(true) {
        if(curr.data <= val) {
          if(curr.right != null)
            curr=curr.right;

          else {
            curr.right=new TreeNode(val);
            break;
          }
        }

        else {
          if(curr.left != null)
            curr=curr.left;

          else {
            curr.left=new TreeNode(val);
            break;
          }
        }
      }
    return root;
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

    System.out.println("Enter the Node you want to enter into the Tree");
    int val=s.nextInt();

    TreeNode result=insert(root, val);
    System.out.println("The root of the New BST is: "+result.data);
    s.close();
  }
}