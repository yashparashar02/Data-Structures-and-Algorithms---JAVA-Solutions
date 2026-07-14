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

public class balancedTree {
  static boolean isBalanced(TreeNode root) {
    return check(root) != -1;
  }
  static int check(TreeNode root) {
    if(root == null)
      return 0;

    int lH=check(root.left);
    if(lH == -1)
      return -1;

    int rH=check(root.right);
    if(rH == -1)
      return -1;

    if(Math.abs(lH - rH) > 1)
      return -1;

    return 1+Math.max(lH, rH);
  }
  public static void main(String[] args) {
    
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
    
    if(isBalanced(root) == true)
      System.out.println(isBalanced(root)+", Yes the tree is Balanced");

    else 
      System.out.println(isBalanced(root)+", No the Tree is not Balanced");
  }
}