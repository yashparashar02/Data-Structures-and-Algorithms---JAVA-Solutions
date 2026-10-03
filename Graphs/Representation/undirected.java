package Graphs.Representation;

import java.util.ArrayList;

public class undirected {
  public static void main(String[] args) {
    int v=4, i;

    ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

    for(i=0; i<=v; i++)
      graph.add(new ArrayList<>());

    graph.get(1).add(2);
    graph.get(2).add(3);

    graph.get(3).add(4);
    graph.get(4).add(1);

    for(i=1; i<=v; i++)
      System.out.println(i+" -> "+graph.get(i));
  }
}