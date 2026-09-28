package BinarySearchTree;

import java.util.Scanner;
import java.util.Stack;

class BSTIterator {
  private Stack<TreeNode> stack=new Stack<TreeNode>();
  private boolean reverse=true;

  public BSTIterator(TreeNode root, boolean isReverse) {
    reverse=isReverse;
    pushAll(root);
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public int next() {
    TreeNode temp=stack.pop();
    if(reverse == false)
      pushAll(temp.right);

    else pushAll(temp.left);

    return temp.data;
  }

  public void pushAll(TreeNode node) {
    while(node != null) {
      stack.push(node);
      if(reverse == true)
          node=node.right;

      else node=node.left;
    }
  }
}

public class twoSum {
  static boolean twoSumBST(TreeNode root, int k) {
    if(root == null)
      return false;

    BSTIterator l=new BSTIterator(root, false);
    BSTIterator r=new BSTIterator(root, true);

    int i=l.next(), j=r.next();
    while(i < j) {
      if(i+j == k)
        return true;

      else if(i+j < k)
        i=l.next();

      else j=r.next();
    }
    return false;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the Sum Target");
    int n=s.nextInt();
    
    TreeNode root=new TreeNode(10);
    root.left=new TreeNode(4);
    root.right=new TreeNode(13);
    root.left.left=new TreeNode(3);
    root.left.left.left=new TreeNode(1);
    root.left.left.left.right=new TreeNode(2);
    root.left.right=new TreeNode(8);
    root.left.right.right=new TreeNode(9);
    root.left.right.left=new TreeNode(6);
    root.left.right.left.left=new TreeNode(5);
    root.left.right.left.right=new TreeNode(4);
    root.right.left=new TreeNode(11);
    root.right.right=new TreeNode(15);

    if(twoSumBST(root, n))
      System.out.println("True, The Sum Value exists in the BST");
    else System.out.println("False, The Sum Target does not exist in BST");
    s.close();
  }
}