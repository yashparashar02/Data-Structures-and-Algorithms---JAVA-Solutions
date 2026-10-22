package Graphs.Cycles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class cycleDirectedBFS {
  static boolean isCyclic(int edges[][], int v, int e) {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0; i<v; i++)
      adj.add(new ArrayList<>());

    for(int edge[]:edges) {
      int u=edge[0], v1=edge[1];
      adj.get(u).add(v1);
    }

    int indegree[]=new int[v], i;
    for(i=0; i<v; i++) {
      for(int it:adj.get(i))
        indegree[it]++;
    }

    Queue<Integer> q=new LinkedList<Integer>();
    for(i=0; i<v; i++) {
      if(indegree[i] == 0)
        q.add(i);
    }
    int cnt=0;
    while(!q.isEmpty()) {
      int node=q.peek();
      q.remove();
      cnt++;
      for(int it:adj.get(node)) {
        indegree[it]--;
        if(indegree[it] == 0)
          q.add(it);
      }
    }
    if(cnt == v)
      return false;

    return true;
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
      edges[i][0]=s.nextInt()-1;
      edges[i][1]=s.nextInt()-1;
    }

    if(isCyclic(edges, v, e))
      System.out.println("True, It is a Directed Cyclic Graph");
    else System.out.println("False, It is not a Directed Cyclic Graph");
    s.close();
  }
}