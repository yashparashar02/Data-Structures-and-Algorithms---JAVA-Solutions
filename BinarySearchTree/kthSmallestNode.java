package BinarySearchTree;

import java.util.Scanner;

public class kthSmallestNode {
  static int cnt=0, ans=0;
  static int kthSmallest(TreeNode root, int k) {
    inorder(root, k);
    return ans;
  }
  static void inorder(TreeNode root, int k) {
    if(root == null)
      return;

    inorder(root.left, k);
    if(cnt >= k)
      return;

    cnt++;
    if(cnt == k) {
      ans=root.data;
      return;
    }

    inorder(root.right, k);
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

    System.out.println("Enter the Kth value");
    int k=s.nextInt();

    System.out.println("The kth Smallest node is: "+kthSmallest(root, k));
    s.close();
  }
}