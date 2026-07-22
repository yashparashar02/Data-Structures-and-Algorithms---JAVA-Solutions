package BinaryTrees.MediumProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

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

class Pair {
  TreeNode node;
  int hd;

  Pair(TreeNode node, int hd) {
    this.node = node;
    this.hd = hd;
  }
}

public class topView {
  static List<Integer> view(TreeNode root) {
    List<Integer> result=new ArrayList<>();

    if(root == null)
      return result;

    TreeMap<Integer, Integer> map=new TreeMap<>();

    Queue<Pair> queue=new LinkedList<>();
    queue.offer(new Pair(root, 0));

    while(!queue.isEmpty()) {
      Pair current=queue.poll();

      if(!map.containsKey(current.hd))
        map.put(current.hd, current.node.val);

      if(current.node.left != null)
        queue.offer(new Pair(current.node.left, current.hd-1));

      if(current.node.right != null)
        queue.offer(new Pair(current.node.right, current.hd+1));
    }
    result.addAll(map.values());

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

    System.out.println("The Top View of the Binary Tree is: "+view(root));
  }
}