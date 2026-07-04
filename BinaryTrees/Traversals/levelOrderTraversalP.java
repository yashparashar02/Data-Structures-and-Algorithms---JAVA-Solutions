package BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
  int data;
  TreeNode left, right;

  TreeNode(int data) {
    this.data = data;
  }
}
public class levelOrderTraversalP {
  static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans=new ArrayList<>();
    
    if(root == null)
      return ans;

    Queue<TreeNode> queue=new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size=queue.size();

      List<Integer> level=new ArrayList<>();

      for(int i=0; i<size; i++) {
        TreeNode node=queue.poll();

        level.add(node.data);

        if(node.left != null)
          queue.offer(node.left);

        if(node.right != null)
          queue.offer(node.right);
      }
      ans.add(level);
    }
    return ans;
  }
  public static void main(String[] args) {
    
    System.out.println("Level Order Traversal");
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

    System.out.println(levelOrder(root));
  }
}