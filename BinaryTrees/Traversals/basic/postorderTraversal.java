package BinaryTrees.Traversals.basic;

class TreeNode {
  int data;
  TreeNode left, right;

  TreeNode(int data) {
    this.data=data;
  }
}

public class postorderTraversal {
  static void postorder(TreeNode node) {
    if(node == null)
      return;

    postorder(node.left);
    postorder(node.right);
    System.out.print(node.data+" ");
  }
  public static void main(String[] args) {
    
    System.out.println("Postorder Traversal");
    TreeNode node=new TreeNode(1);
    node.left=new TreeNode(2);
    node.right=new TreeNode(3);
    node.left.left=new TreeNode(4);
    node.left.right=new TreeNode(5);
    node.left.right.left=new TreeNode(8);
    node.right.left=new TreeNode(6);
    node.right.left.right=new TreeNode(9);
    node.right.right=new TreeNode(7);
    node.right.right.right=new TreeNode(10);

    postorder(node);
  }
}