package BinaryTrees.Hard;

class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int x) {
    val=x;
  }
}

public class lowestCommonAncestor {
  static TreeNode lowestCommAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || root == p || root == q)
      return root;

    TreeNode left=lowestCommAncestor(root.left, p, q), right=lowestCommAncestor(root.right, p, q);

    if(left != null && right != null)
      return root;

    return (left != null) ? left : right;
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

    TreeNode p = root.right.right, q = root.right.left.right;

    TreeNode result = lowestCommAncestor(root, p, q);
    System.out.println("The Lowest Common Ancestor of 7 and 9 is: "+result.val);
  }
}