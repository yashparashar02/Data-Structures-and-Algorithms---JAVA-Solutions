package BinarySearchTree;

public class isValid {
  static boolean isValidBST(TreeNode root) {
    return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  static boolean valid(TreeNode root, long minVal, long maxVal) {
    if(root == null)
      return true;

    if(root.data >= maxVal || root.data <= minVal)
      return false;

    return valid(root.left, minVal, root.data) && valid(root.right, root.data, maxVal);
  }
  public static void main(String[] args) {
    TreeNode root=new TreeNode(8);
    root.left=new TreeNode(5);
    root.right=new TreeNode(12);
    root.left.left=new TreeNode(4);
    root.left.right=new TreeNode(7);
    root.left.right.left=new TreeNode(6);
    root.right.left=new TreeNode(10);
    root.right.right=new TreeNode(14);
    root.right.right.left=new TreeNode(13);

    if(isValidBST(root) == true)
      System.out.println("True, this BST is Valid");

    else System.out.println("False, this BST is Invalid");
  }
}