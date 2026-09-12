package BinaryTrees.Hard;

import BinaryTrees.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class burnTreeTime {
  static int findMaxDistance(HashMap<TreeNode, TreeNode> map, TreeNode target) {
		Queue<TreeNode> q=new LinkedList<>();
		q.offer(target);

		HashMap<TreeNode, Integer> vis = new HashMap<>();
		vis.put(target, 1);
		int maxi=0;

		while(!q.isEmpty()) {
			int sz=q.size(), fl=0, i;

			for(i=0; i<sz; i++) {
				TreeNode node=q.poll();
				if(node.left != null && vis.get(node.left) == null) {
					fl=1;
					vis.put(node.left, 1);
					q.offer(node.left);
				}
				if(node.right != null && vis.get(node.right) == null) {
					fl=1;
					vis.put(node.right, 1);
					q.offer(node.right);
				}
				if(map.get(node) != null && vis.get(map.get(node)) == null) {
					fl=1;
					vis.put(map.get(node), 1);
					q.offer(map.get(node));
				}
			}
			if(fl == 1)
				maxi++;
		}
		return maxi;
	}
	static TreeNode bfsToMapParents(TreeNode root, HashMap<TreeNode, TreeNode> map, int start) {
		Queue<TreeNode> q=new LinkedList<>();
		q.offer(root);

		TreeNode res = new TreeNode(-1);
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			if(node.data == start)
				res=node;
			if(node.left != null) {
				map.put(node.left, node);
				q.offer(node.left);
			}
			if(node.right != null) {
				map.put(node.right, node);
				q.offer(node.right);
			}
		}
		return res;
	}
	public static int timeToBurnTree(TreeNode root, int start) {
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
		TreeNode target = bfsToMapParents(root, map, start);
		int maxi=findMaxDistance(map, target);
		return maxi;
  }

  public static void main(String arr[]) {
    Scanner s=new Scanner(System.in);

    TreeNode root = new TreeNode(1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(3);
    root.left.left=new TreeNode(4);
    root.left.right=new TreeNode(5);
    root.right.left=new TreeNode(6);
    root.right.right=new TreeNode(7);
    root.left.left.right=new TreeNode(8);
    root.left.right.left=new TreeNode(9);
    root.left.right.right=new TreeNode(10);

    System.out.println("Enter Start Value");
    int value=s.nextInt();

    System.out.println("The Total Burn time to burn the whole tree is: "+timeToBurnTree(root, value));
    s.close();
  }
}