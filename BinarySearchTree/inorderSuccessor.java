package BinarySearchTree;

import java.util.Scanner;

public class inorderSuccessor {
  static TreeNode successor(TreeNode root, TreeNode val) {
    TreeNode successor=null;

		while(root != null) {
			if(val.data >= root.data)
				root=root.right;

			else {
				successor=root;
				root=root.left;
			}
		}
		return successor;
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

    System.out.println("Enter the Node value you want the successor for: ");
    int n=s.nextInt();

    TreeNode val=new TreeNode(n);

    TreeNode result=successor(root, val);
    System.out.println("The Successor of "+n+" is: "+result.data);
    s.close();
  }
}