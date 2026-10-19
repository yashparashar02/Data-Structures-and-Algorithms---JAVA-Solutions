package Graphs.Cycles;

import java.util.ArrayList;
import java.util.Scanner;

public class cycleDirectedDfs {
  static boolean isCyclic(int edges[][], int v, int e) {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0; i<v; i++)
      adj.add(new ArrayList<>());

    for(int edge[]:edges) {
      int u=edge[0], v1=edge[1];
      adj.get(u).add(v1);
    }

    int vis[]=new int[v], pathVis[]=new int[v];
    for(int i=0; i<v; i++) {
    if(vis[i] == 0) {
      if(dfsCheck(i, adj, vis, pathVis) == true)
        return true;
      }
    }
    return false;
  }
  static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[]) {
    vis[node]=1;
    pathVis[node]=1;

    for(int adjNode:adj.get(node)) {
      if(vis[adjNode] == 0) {
        if(dfsCheck(adjNode, adj, vis, pathVis) == true)
          return true;
    }
    else if(pathVis[adjNode] == 1)
      return true;
    }
    pathVis[node]=0;
    return false;
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

    if(isCyclic(edges, v, e))
      System.out.println("True, It is a Directed Cyclic Graph");
    else System.out.println("False, It is not a Directed Cyclic Graph");

    s.close();
  }
}