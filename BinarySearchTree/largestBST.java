package BinarySearchTree;

class NodeValue {
	public int maxNode, minNode, maxSize;

	NodeValue(int minNode, int maxNode, int maxSize) {
		this.minNode=minNode;
		this.maxNode=maxNode;
		this.maxSize=maxSize;
	}
}
public class largestBST {
  static NodeValue largestBSTSubtree(TreeNode root) {
    if(root == null)
			return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

		NodeValue left=largestBSTSubtree(root.left);
		NodeValue right=largestBSTSubtree(root.right);

		if(left.maxNode < root.data && root.data < right.minNode) 
			return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode), left.maxSize + right.maxSize + 1);

		return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
  }
  static int largest(TreeNode root) {
    return largestBSTSubtree(root).maxSize;
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

    System.out.println("The Largest BST Subtree is: "+largest(root));
  }
}