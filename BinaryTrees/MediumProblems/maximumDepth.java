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

public class maximumDepth {
  static int maxDepth(TreeNode root) {
    if(root == null)
      return 0;

    int leftDepth=maxDepth(root.left);

    int rightDepth=maxDepth(root.right);

    return 1+Math.max(leftDepth, rightDepth);
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

    System.out.println("The Maximum Depth of Binary Tree is "+maxDepth(root));
  }
}