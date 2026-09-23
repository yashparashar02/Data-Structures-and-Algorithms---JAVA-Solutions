package BinaryTrees.MediumProblems;

import BinaryTrees.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class verticalTraversal {
  private static class NodePosition {
    TreeNode node;
    int row;
    int col;

    NodePosition(TreeNode node, int row, int col) {
      this.node = node;
      this.row = row;
      this.col = col;
    }
  }
  static List<List<Integer>> verticalTraversalTree(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if(root == null)
      return result;

    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

      Queue<NodePosition> queue = new LinkedList<>();
      queue.offer(new NodePosition(root, 0, 0));

      while (!queue.isEmpty()) {
        NodePosition current = queue.poll();

        map.putIfAbsent(current.col, new TreeMap<>());
        map.get(current.col).putIfAbsent(current.row, new PriorityQueue<>());

        map.get(current.col).get(current.row).offer(current.node.data);

        if (current.node.left != null) 
          queue.offer(new NodePosition(current.node.left, current.row + 1, current.col - 1));

        if (current.node.right != null) 
          queue.offer(new NodePosition(current.node.right, current.row + 1, current.col + 1));
      }

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