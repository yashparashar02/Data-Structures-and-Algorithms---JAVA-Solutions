package BinarySearchTree;

import java.util.Stack;

public class bstIterator {
  private Stack<TreeNode> stack=new Stack<>();

  public bstIterator(TreeNode root) {
    pushAll(root);
  }

  public int next() {
    TreeNode temp=stack.pop();
    pushAll(temp.right);
    return temp.data;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public void pushAll(TreeNode node) {
    for(; node!=null; stack.push(node), node=node.left);
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

    bstIterator iterator = new bstIterator(root);

    System.out.println("The Values of the Binary ST Iterator are: ");
    while(iterator.hasNext())
      System.out.print(iterator.next()+" ");
  }
}