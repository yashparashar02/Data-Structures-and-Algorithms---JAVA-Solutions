package Graphs.Traversals;

import java.util.ArrayList;
import java.util.Scanner;

public class dfs {
  static ArrayList<Integer> dfsTraversal(int v, ArrayList<ArrayList<Integer>> adj) {
    boolean vis[]=new boolean[v+1];
    vis[0]=true;
    ArrayList<Integer> ls=new ArrayList<>();
    depthFirstSearch(1, vis, adj, ls);
    return ls;
  }
  static void depthFirstSearch(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
    vis[node]=true;
    ls.add(node);

    for(Integer it:adj.get(node)) {
      if(vis[it] == false)
        depthFirstSearch(it, vis, adj, ls);
    }
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of vertices");
    int v=s.nextInt(), i;

    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(i=0; i<=v; i++)
      adj.add(new ArrayList<>());
    
    System.out.println("Enter the number of edges");
    int e=s.nextInt();

    System.out.println("Enter each edge as: from to");
    for(i=0; i<e; i++) {
      int from = s.nextInt(), to = s.nextInt();

      adj.get(from).add(to);
      adj.get(to).add(from); 
    }
    System.out.println(dfsTraversal(v, adj));
    s.close();
  }
}