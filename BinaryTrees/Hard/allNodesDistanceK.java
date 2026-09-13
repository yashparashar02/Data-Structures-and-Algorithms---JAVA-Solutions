package BinaryTrees.Hard;

import BinaryTrees.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class allNodesDistanceK {
  static void markParents(TreeNode root, Map<TreeNode, TreeNode> parentTrack, TreeNode target) {
    Queue<TreeNode> queue=new LinkedList<TreeNode>();
    queue.offer(root);

    while(!queue.isEmpty()) {
      TreeNode current=queue.poll();

      if(current.left != null) {
        parentTrack.put(current.left, current);
        queue.offer(current.left);
      }

      if(current.right != null) {
        parentTrack.put(current.right, current);
        queue.offer(current.right);
      }
    }
  }

  static List<Integer> NodesDistanceK(TreeNode root, TreeNode target, int k) {
    Map<TreeNode,TreeNode> parentTrack = new HashMap<>();
    markParents(root, parentTrack, root);

    Map<TreeNode, Boolean> visited = new HashMap<>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(target);
    visited.put(target, true);
    int dist=0;

    while(!queue.isEmpty()) {
      int size=queue.size(), i;

      if(dist == k) 
        break;

      dist++;
      for(i=0; i<size; i++) {
        TreeNode current = queue.poll();
        if(current.left != null && visited.get(current.left) == null) {
          queue.offer(current.left);
          visited.put(current.left, true);
        }

        if(current.right != null && visited.get(current.right) == null) {
          queue.offer(current.right);
          visited.put(current.right, true);
        }

        if(parentTrack.get(current) != null && visited.get(parentTrack.get(current)) == null) {
          queue.offer(parentTrack.get(current));
          visited.put(parentTrack.get(current), true);
        }
      }
    }
    List<Integer> result = new ArrayList<>();
    while(!queue.isEmpty()) {
      TreeNode current = queue.poll();
      result.add(current.data);
    }
    return result;
  }

  static TreeNode findNode(TreeNode root, int value) {
    if(root == null) 
      return null;

    if(root.data == value) 
      return root;

    TreeNode leftResult = findNode(root.left, value);
    if(leftResult != null) 
      return leftResult;

    return findNode(root.right, value);
  }

  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    TreeNode root = new TreeNode(1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(3);
    root.left.left=new TreeNode(4);
    root.left.right=new TreeNode(5);
    root.right.left=new TreeNode(6);
    root.right.right=new TreeNode(7);
    root.left.left.right=new TreeNode(8);
    root.left.right.left=new TreeNode(9);
    root.left.right.right=new TreeNode(10);

    System.out.println("Enter Target Node");
    int value=s.nextInt();
    TreeNode target = findNode(root, value);

    System.out.println("Enter the distance");
    int k=s.nextInt();

    List<Integer> result = NodesDistanceK(root, target, k);
    System.out.println("The Nodes at Distance "+k+" is: "+result);
    s.close();
  }
}