package Graphs.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {
  static ArrayList<Integer> bfsTraversal(int v, ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> res=new ArrayList<>();
    boolean vis[]=new boolean[v];
    Queue<Integer> q=new LinkedList<>();

    q.add(0);
    vis[0]=true;

    while(!q.isEmpty()) {
      Integer node=q.poll();
      res.add(node);

      for(Integer it:adj.get(node)) {
        if(vis[it] == false) {
          vis[it]=true;
          q.add(it);
        }
      }
    }
    return res;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of vertices");
    int v=s.nextInt(), i;

    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(i=0; i<v; i++)
      adj.add(new ArrayList<>());

    System.out.println("Enter the number of edges");
    int e=s.nextInt();

    System.out.println("Enter each edge as: from to");
    for(i=0; i<e; i++) {
      int from = s.nextInt(), to = s.nextInt();

      adj.get(from).add(to);
      adj.get(to).add(from); 
    }
    System.out.println(bfsTraversal(v, adj));
    s.close();
  }
}