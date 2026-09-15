package BinaryTrees.Hard;

import BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class fromInorderPostorder {
  static TreeNode fromInPostOrder(int postorder[], int inorder[]) {
    if(inorder == null || postorder == null || inorder.length != postorder.length) 
      return null;

    HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();

    for(int i=0; i<inorder.length; ++i) 
      map.put(inorder[i], i);

    return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
  }
  static TreeNode buildTree(int inorder[], int inStart, int inEnd, int postorder[], int postStart, int postEnd, HashMap<Integer, Integer> map) {
    if(postStart > postEnd || inStart > inEnd)
      return null;

    TreeNode root=new TreeNode(postorder[postEnd]);

    int inRoot=map.get(root.data);
    int numsLeft=inRoot-inStart;

    root.left=buildTree(inorder, inStart, inRoot-1, postorder, postStart, postStart+numsLeft-1, map);
    root.right=buildTree(inorder, inRoot+1, inEnd, postorder, postStart+numsLeft, postEnd-1, map);

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

    System.out.println("Enter the number range of both Postorder and Inorder Arrays");
    int n=s.nextInt(),i;
    int postorder[]=new int[n], inorder[]=new int[n];

    System.out.println("Enter the values for Postorder");
    for(i=0; i<n; i++) 
      postorder[i]=s.nextInt();

    System.out.println("Enter the values for Inorder");
    for(i=0; i<n; i++) 
      inorder[i]=s.nextInt();

    TreeNode root=fromInPostOrder(postorder, inorder);
    System.out.println("The Binary Tree is: "+serialize(root));
    s.close();
  }
}