package BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Hashing.HashMap.linkedHashSetDemo;

class TreeNode {
  int data;
  TreeNode left, right;

  TreeNode(int data) {
    this.data=data;
  }
}

public class preorderTraversalP {
  static List<Integer> preorder(TreeNode root) {
    List<Integer> ans=new ArrayList<>();

    if(root == null)
      return ans;

    Stack<TreeNode> stack=new Stack<>();
    stack.push(root);

    while(!stack.isEmpty()) {
      TreeNode node=stack.pop();

      ans.add(node.data);

      if(node.right != null)
        stack.push(node.right);

      if(node.left != null)
        stack.push(node.left);
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

    System.out.println(preorder(root));
  }
}