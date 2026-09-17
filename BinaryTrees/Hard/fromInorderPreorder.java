package BinaryTrees.Hard;

import BinaryTrees.TreeNode;
import java.util.*;

public class fromInorderPreorder {
  static TreeNode fromInPreOrder(int[] preorder, int[] inorder) {
    if(preorder == null || inorder == null || preorder.length != inorder.length)
      return null;
    
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i=0; i<inorder.length; i++)
      map.put(inorder[i], i);

    TreeNode root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);

    return root;
  }
  static TreeNode buildTree(int preorder[], int preStart, int preEnd, int inorder[], int inStart, int inEnd, Map<Integer, Integer> map) {
    if(preStart > preEnd || inStart > inEnd)
      return null;

    TreeNode root = new TreeNode(preorder[preStart]);

    int inRoot = map.get(root.data);
    int numsLeft = inRoot - inStart;

    root.left=buildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, map);
    root.right=buildTree(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, map);

    return root;
  }
  static List<Integer> serialize(TreeNode root) {
    List<Integer> result=new ArrayList<>();

    if(root == null) 
      return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while(!queue.isEmpty()) {
      TreeNode node=queue.poll();

      if(node == null)
          result.add(null);
      else {
          result.add(node.data);
          queue.offer(node.left);
          queue.offer(node.right);
      }
    }

    while(!result.isEmpty() && result.get(result.size() - 1) == null) 
      result.remove(result.size() - 1);

    return result;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number range of both Preorder and Inorder Arrays");
    int n=s.nextInt(),i;
    int preorder[]=new int[n], inorder[]=new int[n];

    System.out.println("Enter the values for Preorder");
    for(i=0; i<n; i++) 
      preorder[i]=s.nextInt();

    System.out.println("Enter the values for Inorder");
    for(i=0; i<n; i++) 
      inorder[i]=s.nextInt();

    TreeNode root=fromInPreOrder(preorder, inorder);
    System.out.println("The Binary Tree is: "+serialize(root));
    s.close();
  }
}