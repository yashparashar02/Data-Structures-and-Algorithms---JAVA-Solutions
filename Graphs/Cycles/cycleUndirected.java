package Graphs.Cycles;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
  int first, second;

  public Pair(int first, int second) {
    this.first=first;
    this.second=second;
  }
}
public class cycleUndirected {
  static boolean detectCycle(int V, int adj[][]) {
    boolean vis[]=new boolean[V];
    for(int i=0; i<V; i++) 
      vis[i]=false;

    for(int i=0; i<V; i++) {
      if(vis[i] == false) {
        if(checkCycle(i, V, adj, vis))
          return true;
      }
    }
    return false;
  }
  static boolean checkCycle(int src, int V, int adj[][], boolean vis[]) {
    vis[src]=true;
    Queue<Pair> q=new LinkedList<>();
    q.add(new Pair(src, -1));
    while(!q.isEmpty()) {
      int node=q.peek().first, parent=q.peek().second;
      q.remove();

      for(int adjacentNode:adj[node]) {
        if(vis[adjacentNode] == false) {
          vis[adjacentNode] = true;
          q.add(new Pair(adjacentNode, node));
        }
        else if(parent != adjacentNode)
          return true;
      }
    }
    return false;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of rows for the Graph");
    int row=s.nextInt(), r;
    System.out.println("Enter the number of columns for the Graph");
    int col=s.nextInt(), c;

    int graph[][]=new int[row][col];
    System.out.println("Enter "+row+"x"+col+" number of Graph nodes");
    for(r=0; r<row; r++) {
      for(c=0; c<col; c++)
        graph[r][c]=s.nextInt();
    }
    System.out.println("Enter the number of Vertices");
    int V=s.nextInt();

    if(detectCycle(V, graph))
      System.out.println("True, It is a Ccyclic Undirected Graph");

    else System.out.println("False, It is not a Cyclic Undirected Graph");

    s.close();
  }
}