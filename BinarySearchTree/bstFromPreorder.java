package BinarySearchTree;

import java.util.Scanner;

public class bstFromPreorder {
  static TreeNode fromPreorder(int preorder[]) {
    return Preorder(preorder, Integer.MAX_VALUE, new int[]{0});
  }
  static TreeNode Preorder(int preorder[], int maxVal, int i[]) {
    if(i[0] == preorder.length || preorder[i[0]] > maxVal)
      return null;

    TreeNode root=new TreeNode(preorder[i[0]++]);

    root.left=Preorder(preorder, root.data, i);

    root.right=Preorder(preorder, maxVal, i);

    return root;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of values for the BST");
    int n=s.nextInt();

    System.out.println("Enter "+n+" Preorder Traversal values");
    int preorder[]=new int[n], i;
    for(i=0; i<n; i++)
      preorder[i]=s.nextInt();

    TreeNode result=fromPreorder(preorder);
    System.out.println("The Root of the BST is: "+result.data);
    s.close();
  }
}