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

public class maximumPath {
  static int maxSum=Integer.MIN_VALUE;

  static int maxPath(TreeNode root) {
    maxSum=Integer.MIN_VALUE;

    maxPathSum(root);

    return maxSum;
  }
  static int maxPathSum(TreeNode node) {
    if(node == null)
      return 0;

    int leftSum=Math.max(0, maxPathSum(node.left)), rightSum=Math.max(0, maxPathSum(node.right));

    int currPath=leftSum + node.val + rightSum;

    maxSum=Math.max(maxSum, currPath);

    return node.val + Math.max(leftSum, rightSum);
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

    System.out.println("The Maximum Path Sum of the Binary Tree is: "+maxPath(root));
  }
}