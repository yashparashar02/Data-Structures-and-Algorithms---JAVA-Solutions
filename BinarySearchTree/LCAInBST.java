package BinarySearchTree;

public class LCAInBST {
  static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null)
      return null;

    int curr=root.data;
    if(curr < p.data && curr < p.data)
      return LCA(root.right, p, q);

    if(curr > p.data && curr > q.data)
      return LCA(root.left, p, q);

    return root;
  }
  public static void main(String[] args) {
    TreeNode root=new TreeNode(10);
    root.left=new TreeNode(4);
    root.right=new TreeNode(13);
    root.left.left=new TreeNode(3);
    root.left.left.left=new TreeNode(1);
    root.left.left.left.right=new TreeNode(2);
    root.left.right=new TreeNode(8);
    root.left.right.right=new TreeNode(9);
    root.left.right.left=new TreeNode(6);
    root.left.right.left.left=new TreeNode(5);
    root.left.right.left.right=new TreeNode(4);
    root.right.left=new TreeNode(11);
    root.right.right=new TreeNode(15);

    TreeNode p=new TreeNode(1);
    TreeNode q=new TreeNode(9);

    TreeNode lca=LCA(root, p, q);
    System.out.println("The LCA of this BST is: "+lca.data);
  }
}