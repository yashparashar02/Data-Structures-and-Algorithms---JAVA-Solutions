package BinaryTrees.MediumProblems;

import BinaryTrees.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class boundaryTraversal {
  static List<Integer> boundary(TreeNode root) {
    List<Integer> result=new ArrayList<>();

    if(root == null)
      return result;

    if(!isLeaf(root))
      result.add(root.data);

    leftBoundary(root.left, result);
    leaves(root, result);
    rightBoundary(root.right, result);

    return result;
  }

  static boolean isLeaf(TreeNode node) {
    return node.left == null && node.right == null;
  }

  static void leftBoundary(TreeNode node, List<Integer> result) {
    while(node != null) {
      if(!isLeaf(node))
        result.add(node.data);

      if(node.left != null)
        node=node.left;

      else node=node.right;
    }
  }

  static void leaves(TreeNode node, List<Integer> result) {
    if(node == null)
      return;

    if(isLeaf(node)) {
      result.add(node.data);
      return;
    }
    leaves(node.left, result);
    leaves(node.right, result);
  }

  static void rightBoundary(TreeNode node, List<Integer> result) {
    List<Integer> temp=new ArrayList<>();

    while(node != null) {
      if(!isLeaf(node))
        temp.add(node.data);

      if(node.right != null)
        node=node.right;

      else node=node.left;
    }
    for(int i=temp.size()-1; i>0; i--)
      result.add(temp.get(i));
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

    System.out.println("The Boundary Traversal of The Binary Tree is "+boundary(root));
  }
}