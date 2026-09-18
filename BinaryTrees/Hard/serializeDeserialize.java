package BinaryTrees.Hard;

import BinaryTrees.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class serializeDeserialize {
  static String serialize(TreeNode root) {
    if(root == null)
      return "";

    Queue<TreeNode> q=new LinkedList<>();
    StringBuilder res=new StringBuilder();
    q.add(root);

    while(!q.isEmpty()) {
      TreeNode node=q.poll();
      if(node == null) {
        res.append("n ");
        continue;
      }
      res.append(node.data+" ");
      q.add(node.left);
      q.add(node.right);
    }
    return res.toString().trim();
  }
  static TreeNode deserialize(String data) {
    if(data == null || data.isEmpty())
      return null;

    Queue<TreeNode> q=new LinkedList<>();
    String values[]=data.split(" ");
    TreeNode root=new TreeNode(Integer.parseInt(values[0]));
    q.add(root);

    for(int i=1; i < values.length; i+=2) {
      TreeNode parent=q.poll();
      if(!values[i].equals("n")) {
        TreeNode left=new TreeNode(Integer.parseInt(values[i]));
        parent.left=left;
        q.add(left);
      }
      if(i+1 < values.length && !values[i+1].equals("n")) {
        TreeNode right=new TreeNode(Integer.parseInt(values[i+1]));
        parent.right=right;
        q.add(right);
      }
    }
    return root;
  }
  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(3);
    root.left.left=new TreeNode(4);
    root.left.right=new TreeNode(5);
    root.right.left=new TreeNode(6);
    root.right.right=new TreeNode(7);
    root.left.left.left=new TreeNode(8);
    root.left.left.right=new TreeNode(9);
    root.left.right.left=new TreeNode(10);
    root.left.right.right=new TreeNode(11);

    String serilizedString=serialize(root);
    System.out.println("The Serialized String is: "+serilizedString);

    TreeNode deserializedRoot=deserialize(serilizedString);
    System.out.println("The Deserialized Tree is: "+serialize(deserializedRoot));
  }
}