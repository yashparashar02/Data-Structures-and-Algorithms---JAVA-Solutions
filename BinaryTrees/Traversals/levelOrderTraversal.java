package BinaryTrees.Traversals;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
  int data;
  TreeNode left, right;

  TreeNode(int data) {
    this.data=data;
  }
}

public class levelOrderTraversal {
  static void levelOrder(TreeNode root) {
    if(root == null)
      return;

    Queue<TreeNode> queue=new LinkedList<>();
    queue.offer(root);

    while(!queue.isEmpty()) {
      TreeNode current=queue.poll();

      System.out.print(current.data+" ");

      if(current.left != null)
        queue.offer(current.left);

      if(current.right != null)
        queue.offer(current.right);
    }
  }
  public static void main(String[] args) {
    
    System.out.println("Level-Order Traversal");
    TreeNode node=new TreeNode(1);
    node.left=new TreeNode(2);
    node.right=new TreeNode(3);
    node.left.left=new TreeNode(4);
    node.left.right=new TreeNode(5);
    node.left.right.left=new TreeNode(8);
    node.right.left=new TreeNode(6);
    node.right.left.right=new TreeNode(9);
    node.right.right=new TreeNode(7);
    node.right.right.right=new TreeNode(10);

    levelOrder(node);
  }
}