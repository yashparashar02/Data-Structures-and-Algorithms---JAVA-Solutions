package BinaryTrees.Hard;

import java.util.LinkedList;
import java.util.Queue;

public class maximumWidth {
  static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {}
    TreeNode(int val) {
      this.val=val;
    }

    TreeNode (int val, TreeNode left, TreeNode right) {
      this.val=val;
      this.left=left;
      this.right=right;
    }
  }
  static class Pair {
    TreeNode node;
    long index;

    Pair(TreeNode node, long index) {
      this.node=node;
      this.index=index;
    }
  }
  static int maxWidthBT(TreeNode root) {
    if(root == null)
      return 0;

    Queue<Pair> queue=new LinkedList<>();
    queue.offer(new Pair(root, 0));

    int maxWidth=0;

    while(!queue.isEmpty()) {
      int size=queue.size();

      long minIndex=queue.peek().index, first=0, last=0;

      for(int i=0; i<size; i++) {
        Pair current=queue.poll();

        long index=current.index-minIndex;

        if(i == 0)
          first = index;

        if(i == size-1) 
          last = index;

        if(current.node.left != null)
          queue.offer(new Pair(current.node.left, 2*index+1));

        if(current.node.right != null)
          queue.offer(new Pair(current.node.right, 2*index+2));
      }
      maxWidth=Math.max(maxWidth, (int)(last-first+1));
    }
    return maxWidth;
  }
  public static void main(String[] args) {
    
    TreeNode root=new TreeNode(1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(3);
    root.left.left=new TreeNode(4);
    root.left.right=new TreeNode(5);
    root.left.right.left=new TreeNode(8);
    root.right.left=new TreeNode(6);
    root.right.left.right=new TreeNode(9);
    root.right.right=new TreeNode(7);
    root.right.right.right=new TreeNode(10);

    System.out.println("The Maximum Width of the Binary Tree is: "+maxWidthBT(root));
  }
}