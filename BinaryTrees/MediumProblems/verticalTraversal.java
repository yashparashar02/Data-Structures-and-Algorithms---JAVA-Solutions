package BinaryTrees.MediumProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
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
  int row;
  int col;

  Pair(TreeNode node, int row, int col) {
    this.node = node;
    this.row = row;
    this.col = col;
  }
}

public class verticalTraversal {
  static List<List<Integer>> verticalTraversalTree(TreeNode root) {
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

      Queue<Pair> queue = new LinkedList<>();
      queue.offer(new Pair(root, 0, 0));

      while (!queue.isEmpty()) {
        Pair current = queue.poll();

        map.putIfAbsent(current.col, new TreeMap<>());
        map.get(current.col).putIfAbsent(current.row, new PriorityQueue<>());

        map.get(current.col).get(current.row).offer(current.node.val);

        if (current.node.left != null) 
          queue.offer(new Pair(current.node.left, current.row + 1, current.col - 1));

        if (current.node.right != null) 
          queue.offer(new Pair(current.node.right, current.row + 1, current.col + 1));
      }

      List<List<Integer>> result = new ArrayList<>();

      for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
        List<Integer> column = new ArrayList<>();

        for (PriorityQueue<Integer> pq : rows.values()) {
          while (!pq.isEmpty())
            column.add(pq.poll());
        }

        result.add(column);
      }

    return result;
  }
  public static void main(String arr[]) {

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

    System.out.println("The Vertical Traversal of The Binary Tree is "+verticalTraversalTree(root));
  }
}