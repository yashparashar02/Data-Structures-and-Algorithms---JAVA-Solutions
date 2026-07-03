package BinaryTrees.Traversals;


class TreeNode {
  int data;
  TreeNode left, right;
  
  TreeNode(int data) {
    this.data=data;
  }
}

public class inorderTraversal {
  static void inorder(TreeNode root) {
    if(root == null)
      return;

    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
  }
  public static void main(String[] args) {
    
    System.out.println("Inorder Traversal");
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

    inorder(root);
  }
}