package BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
  int data;
  TreeNode left, right;

  TreeNode(int data) {
    this.data=data;
  }
}

public class inorderTraversalP {
  static List<Integer> inorder(TreeNode root) {
    List<Integer> ans=new ArrayList<>();

    Stack<TreeNode> stack=new Stack<>();
    
    TreeNode current=root;

    while(current != null || !stack.isEmpty()) {
      while (current != null) {
        stack.push(current);
        current=current.left;
      }

      current=stack.pop();

      ans.add(current.data);

      current=current.right;
    }
    return ans;
  }
  public static void main(String[] args) {
    
    System.out.println("Preorder Traversal");
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

    System.out.println(inorder(root));
  }
}