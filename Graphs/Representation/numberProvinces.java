package Graphs.Representation;

import java.util.ArrayList;
import java.util.Scanner;


public class numberProvinces {
  static int findProvinces(int isConnected[][]) {
    int v=isConnected.length;

    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0; i<v; i++) 
      adj.add(new ArrayList<>());

    for(int i=0; i<v; i++) {
      for(int j=0; j<v; j++) {
        if(isConnected[i][j] == 1 && i != j) {
          adj.get(i).add(j);
          adj.get(j).add(i);
        }
      }
    }

    int vis[]=new int[v], cnt=0;
    for(int i=0; i<v; i++) {
      if(vis[i] == 0) {
        cnt++;
        dfs(i, adj, vis);
      }
    }
    return cnt;
  }
  static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis[]) {
    vis[node]=1;
    for(Integer it:adj.get(node)) {
      if(vis[it] == 0)
        dfs(it, adj, vis);
    }
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of cities");
    int v=s.nextInt(), i, j;

    int isConnected[][]=new int[v][v];
    System.out.println("Enter "+v+"x"+v+" cities in whatever number of provinces you want");
    for(i=0; i<v; i++) {
      for(j=0; j<v; j++)
        isConnected[i][j]=s.nextInt();
    }

    System.out.println("The total number of provinces are: "+findProvinces(isConnected));
    s.close();
  }
}