package BinaryTrees.Hard;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode(int val) {
      this.val = val;
    }
  }

public class childrenSumProperty {
  static void childrenSum(TreeNode root) {
    if(root == null)
      return;

    int child=0, total=0;

    if(root.left != null)
      child+=root.left.val;

    if(root.right != null)
      child+=root.right.val;

    if(child >= root.val)
      root.val=child;

    else {
      if(root.left != null)
        root.left.val = root.val;

      if(root.right != null)
        root.right.val = root.val;
    }

    childrenSum(root.left);
    childrenSum(root.right);

    if(root.left != null)
      total+=root.left.val;

    if(root.right != null)
      total+=root.right.val;

    if(root.left != null || root.right != null)
      root.val=total;
  }
  public static void main(String[] args) {
    
    TreeNode root=new TreeNode(40);
    root.left=new TreeNode(10);
    root.right=new TreeNode(20);
    root.left.left=new TreeNode(2);
    root.left.right=new TreeNode(5);
    root.right.left=new TreeNode(30);
    root.right.right=new TreeNode(40);

    childrenSum(root);
    System.out.println("Valid Children Sum Property Executed");
  }
}