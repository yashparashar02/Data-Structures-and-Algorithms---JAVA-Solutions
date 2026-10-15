package Graphs.Cycles;

import java.util.Scanner;

public class isBipartite {
  static boolean bipartite(int graph[][]) {
    int m=graph.length;
    int color[]=new int[m], i;
    for(i=0; i<m; i++)
      color[i]=-1;

    for(i=0; i<m; i++) {
      if(color[i] == -1) {
        if(dfs(i, 0, graph, color) == false)
          return false;
      }
    }
    return true;
  }
  static boolean dfs(int node, int col, int graph[][], int color[]) {
    color[node]=col;
    for(int neighbor:graph[node]) {
      if(color[neighbor] == -1) {
        if(dfs(neighbor, 1-col, graph, color) == false)
          return false;
      }
      else if(color[neighbor] == col)
        return false;
    }
    return true;
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

    if(bipartite(graph))
      System.out.println("True, The Graph is Bipartite");

    else System.out.println("False, The Graph is not Bipartite");

    s.close();
  }
}