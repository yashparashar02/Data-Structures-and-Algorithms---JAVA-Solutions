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

public class sameTree {
  static boolean isSame(TreeNode tree1, TreeNode tree2) {
    if(tree1 == null && tree2 == null)
      return true;

    if(tree1 == null || tree2 == null)
      return false;

    if(tree1.val != tree2.val)
      return false;

    return isSame(tree1.left, tree2.left) && isSame(tree1.right, tree2.right);
  }
  public static void main(String arr[]) {

    TreeNode tree1=new TreeNode(1), tree2=new TreeNode(1);
    tree1.left=new TreeNode(2); tree2.left=new TreeNode(2);
    tree1.right=new TreeNode(3); tree2.right=new TreeNode(3);
    
    if(isSame(tree1, tree2) == true)
      System.out.println("Yes both trees are same");
    else 
      System.out.println("No both trees are not same");
  }
}