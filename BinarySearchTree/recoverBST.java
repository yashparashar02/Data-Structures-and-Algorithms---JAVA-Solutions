package BinarySearchTree;

public class recoverBST {
  private static TreeNode first, prev, middle, last;

  static void inorder(TreeNode root) {
    if(root == null)
      return;

    inorder(root.left);
    if(prev != null && (root.data < prev.data)) {
      if(first == null) {
        first=prev;
        middle=root;
      }
      else last=root;
    }
    prev=root;
    inorder(root.right);
  }
  static TreeNode recover(TreeNode root) {
    first=middle=last=null;
    prev=new TreeNode(Integer.MIN_VALUE);
    inorder(root);
    if(first != null && last != null) {
      int t=first.data;
      first.data=last.data;
      last.data=t;
    }
    else if(first != null && middle != null) {
      int t=first.data;
      first.data=middle.data;
      middle.data=t;
    }
    return root;
  }
  public static void main(String[] args) {
    TreeNode root=new TreeNode(8);
    root.left=new TreeNode(5);
    root.right=new TreeNode(12);
    root.left.left=new TreeNode(4);
    root.left.right=new TreeNode(6);
    root.left.right.left=new TreeNode(7);
    root.right.left=new TreeNode(10);
    root.right.right=new TreeNode(14);
    root.right.right.left=new TreeNode(13);

    TreeNode result=recover(root);
    System.out.println("The root of the Recovered BST is: "+result.data);
  }
}