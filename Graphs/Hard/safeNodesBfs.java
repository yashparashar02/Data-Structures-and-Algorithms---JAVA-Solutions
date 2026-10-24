package Graphs.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class safeNodesBfs {
  static List<Integer> safeNodes(int graph[][], int v, int e) {
    ArrayList<ArrayList<Integer>> adjRev=new ArrayList<>();
    for(int i=0; i<v; i++) 
      adjRev.add(new ArrayList<>());

    int indegree[]=new int[v], i;
    for(int edge[]:graph) {
      int from=edge[0], to=edge[1];
        adjRev.get(to).add(from);
        indegree[from]++;
    }
    Queue<Integer> q=new LinkedList<Integer>();
    for(i=0; i<v; i++) {
      if(indegree[i] == 0)
        q.add(i);
    }
    List<Integer> safeNode=new ArrayList<>();
    while(!q.isEmpty()) {
      int node=q.poll();
      safeNode.add(node);
      for(int pred:adjRev.get(node)) {
        indegree[pred]--;
        if(indegree[pred] == 0)
          q.add(pred);
      }
    }
    Collections.sort(safeNode);
    return safeNode;
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