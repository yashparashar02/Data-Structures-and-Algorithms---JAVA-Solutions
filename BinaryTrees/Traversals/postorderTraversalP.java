package BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
  int data;
  TreeNode left, right;

  TreeNode() {}

  TreeNode(int data) {
    this.data=data;
  }
  
  TreeNode(int data, TreeNode left, TreeNode right) {
    this.data=data;
    this.left=left;
    this.right=right;
  }
}

public class postorderTraversalP {
  static List<Integer> postorder(TreeNode root) {
    List<Integer> ans=new ArrayList<>();
    Stack<TreeNode> stack=new Stack<>();

    TreeNode current=root, lastVisited=null;

    while(current != null || !stack.isEmpty()) {
      if(current != null) {
        stack.push(current);
        current=current.left;
      }

      else {
        TreeNode peek=stack.peek();

        if(peek.right != null && lastVisited != peek.right)
          current=peek.right;

        else {
          ans.add(peek.data);
          lastVisited=stack.pop();
        }
      }
    }
    return ans;
  }
  public static void main(String[] args) {
    
    System.out.println("Postorder Traversal");
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

    System.out.println(postorder(root));
  }
}