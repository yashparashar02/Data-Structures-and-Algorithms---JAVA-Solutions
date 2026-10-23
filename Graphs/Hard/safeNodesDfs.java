package Graphs.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class safeNodesDfs {
  static List<Integer> safeNodes(int graph[][], int v, int e) {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0; i<v; i++)
      adj.add(new ArrayList<>());

    for(int edge[]:graph) 
      adj.get(edge[0]).add(edge[1]);

    int vis[]=new int[v], pathVis[]=new int[v], check[]=new int[v], i;
    for(i=0; i<v; i++) {
      if(vis[i] == 0)
        dfsCheck(i, adj, vis, pathVis, check);
    }
    List<Integer> safeNode=new ArrayList<>();
    for(i=0; i<v; i++) {
      if(check[i] == 1)
        safeNode.add(i);
    }
    return safeNode;
  }
  private static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[], int check[]) {
    vis[node]=1;
    pathVis[node]=1;
    check[node]=0;
    for(int neighbor:adj.get(node)) {
      if(vis[neighbor] == 0) {
        if(dfsCheck(neighbor, adj, vis, pathVis, check) == true)
          return true;
      }
      else if(pathVis[neighbor] == 1)
        return true;
    }
    check[node]=1;
    pathVis[node]=0;
    return false;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    
    System.out.println("Enter the number of Vertices");
    int v=s.nextInt();
    System.out.println("Enter the number of Edges");
    int e=s.nextInt();

    int graph[][]=new int[e][2], i;
    System.out.println("Enter each directed edge as: from to");
    for(i=0; i<e; i++) {
      graph[i][0]=s.nextInt();
      graph[i][1]=s.nextInt();
    }
    List<Integer> result=safeNodes(graph, v, e);
    System.out.println("The Safe Nodes are: ");
    for(int vertex:result)
      System.out.print(vertex+" ");

    s.close();
  }
}