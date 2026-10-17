package Graphs.Cycles;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class topologicalSort {
  static int[] sortTopological(int edges[][], int v, int e) {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0; i<v; i++)
      adj.add(new ArrayList<>());

    for(int edge[]:edges) {
      int u=edge[0], w=edge[1];
      adj.get(u).add(w);
    }
    int vis[]=new int[v], i;
    Stack<Integer> st=new Stack<>();
    for(i=0; i<v; i++) {
      if(vis[i] == 0)
        dfs(i, vis, st, adj);
    }

    int ans[]=new int[v], j=0;
    while(!st.isEmpty()) {
      ans[j++]=st.peek();
      st.pop();
    }
    return ans;
  }
  static void dfs(int node, int vis[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
    vis[node]=1;
    for(int neighbor:adj.get(node)) {
      if(vis[neighbor] == 0)
        dfs(neighbor, vis, st, adj);
    }
    st.push(node);
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    
    System.out.println("Enter the number of Vertices");
    int v=s.nextInt();
    System.out.println("Enter the number of Edges");
    int e=s.nextInt();

    int edges[][]=new int[e][2], i;
    System.out.println("Enter each directed edge as: from to");
    for(i=0; i<e; i++) {
      edges[i][0]=s.nextInt();
      edges[i][1]=s.nextInt();
    }

    int result[]=sortTopological(edges, v, e);
    System.out.println("Topological Order: ");
    for(int vertex:result)
      System.out.print(vertex+" ");

    s.close();
  }
}