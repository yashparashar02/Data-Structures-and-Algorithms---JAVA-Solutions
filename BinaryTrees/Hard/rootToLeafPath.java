package BinaryTrees.Hard;

import java.util.ArrayList;

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

public class rootToLeafPath {
  static ArrayList<ArrayList<Integer>> rootToLeaf(TreeNode root) {
    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    ArrayList<Integer> path=new ArrayList<>();

    pathSearch(root, path, result);

    return result;
  }
  static void pathSearch(TreeNode node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
    if(node == null)
      return;

    path.add(node.val);

    if(node.left == null && node.right == null)
      result.add(new ArrayList<>(path));

    else {
      pathSearch(node.left, path, result);
      pathSearch(node.right, path, result);
    }
    path.remove(path.size() - 1);
  }
  public static void main(String[] args) {
    
    TreeNode node=new TreeNode(1);
    node.left=new TreeNode(2);
    node.right=new TreeNode(2);
    node.left.left=new TreeNode(3);
    node.left.right=new TreeNode(4);
    node.left.right.left=new TreeNode(5);
    node.right.left=new TreeNode(4);
    node.right.right=new TreeNode(3);
    node.right.left.right=new TreeNode(5);

    System.out.println("The Root to Leaf Path is: "+rootToLeaf(node));
  }
}