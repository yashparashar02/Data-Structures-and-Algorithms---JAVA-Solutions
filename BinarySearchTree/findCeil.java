package BinarySearchTree;

import java.util.Scanner;

public class findCeil {
  static int ceil(TreeNode root, int key) {
    int ceil=-1;
    while(root != null) {
      if(root.data == key) {
        ceil=root.data;
        return ceil;
      }
      
      if(key > root.data)
        root=root.right;

      else {
        ceil=root.data;
        root=root.left;
      }
    }
    return ceil;
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

    System.out.println("Enter the Key value");
    int key=s.nextInt();

    System.out.println("The Ceil Value of the Tree for Key("+key+") is: "+ceil(root, key));
    s.close();
  }
}