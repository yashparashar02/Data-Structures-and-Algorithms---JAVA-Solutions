package BinaryTrees.MediumProblems;

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

public class symmetricCheck {
  static boolean isSymmetric(TreeNode root) {
    return root == null || check(root.left, root.right);
  }
  static boolean check(TreeNode left, TreeNode right) {
    if(left == null && right == null)
      return true;

    if(left == null || right == null)
      return false;

    if(left.val != right.val)
      return false;

    return check(left.left, right.right) && check(left.right, right.left);
  }
  public static void main(String[] args) {
    
    TreeNode root=new TreeNode(1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(2);
    root.left.left=new TreeNode(3);
    root.left.right=new TreeNode(4);
    root.left.right.left=new TreeNode(5);
    root.right.left=new TreeNode(4);
    root.right.right=new TreeNode(3);
    root.right.left.right=new TreeNode(5);

    if(isSymmetric(root) == true)
      System.out.println("Yes the Binary Tree is Symmetric");
    else System.out.println("No the Binary Tree is not Symmetric");
  }
}