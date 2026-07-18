package BinaryTrees.MediumProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
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

public class zigzagLevelOrder {
  static List<List<Integer>> zigzag(TreeNode root) {
    List<List<Integer>> result=new ArrayList<>();

    if(root == null)
      return result;

    Queue<TreeNode> queue=new LinkedList<>();
    queue.offer(root);

    boolean leftToRight=true;
    while(!queue.isEmpty()) {
      int size=queue.size(), i;
      Integer[] level=new Integer[size];

      for(i=0; i<size; i++) {
        TreeNode current=queue.poll();

        int index=leftToRight ? i : size-i-1;
        level[index] = current.val;

        if(current.left != null)
          queue.offer(current.left);

        if(current.right != null)
          queue.offer(current.right);
      }
      result.add(Arrays.asList(level));
      leftToRight = !leftToRight;
    }
    return result;
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

    System.out.println("The Zigzag Level Order Binary Tree is "+zigzag(root));
  }
}