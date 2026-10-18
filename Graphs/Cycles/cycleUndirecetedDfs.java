package Graphs.Cycles;

import java.util.Scanner;

public class cycleUndirecetedDfs {
  static boolean detectCycle(int V, int adj[][]) {
    int vis[]=new int[V], i;
    for(i=0; i<V; i++) {
      if(vis[i] == 0) {
        if(checkCycle(i, -1, adj, vis) == true)
          return true;
      }
    }
    return false;
  }
  static boolean checkCycle(int node, int parent, int adj[][], int vis[]) {
    vis[node]=1;
    for(int adjNode:adj[node]) {
      if(vis[adjNode] == 0) {
        if(checkCycle(adjNode, node, adj, vis) == true)
          return true;
      }
      else if(adjNode != parent)
        return true;
    }
    return false;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of Vertices");
    int v=s.nextInt();
    System.out.println("Enter the number of Edges");
    int e=s.nextInt();

    int adj[][]=new int[e][2], i;
    System.out.println("Enter each directed edge as: from to");
    for(i=0; i<e; i++) {
      adj[i][0]=s.nextInt();
      adj[i][1]=s.nextInt();
    }
    if(detectCycle(v, adj))
      System.out.println("True, It is a Cyclic Undirected Graph");

    else System.out.println("False, It is not a Cyclic Undirected Graph");

    s.close();
  }
}