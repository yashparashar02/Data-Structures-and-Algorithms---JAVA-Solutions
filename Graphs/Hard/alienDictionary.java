package Graphs.Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class alienDictionary {
  static String getAlienDictionary(String dictionary[], int k) {
    List<List<Integer>> adj=new ArrayList<>();
    for(int i=0; i<k; i++)
      adj.add(new ArrayList<>());

    for(int i=0; i<dictionary.length - 1; i++) {
      String s1=dictionary[i], s2=dictionary[i+1];
      int len=Math.min(s1.length(), s2.length());
      for(int ptr=0; ptr<len; ptr++) {
        if(s1.charAt(ptr) != s2.charAt(ptr)) {
          adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
          break;
        }
      }
    }
    List<Integer> topo=topoSort(k, adj);
    String ans="";
    for(int it:topo)
      ans+=(char)(it+(int)('a'));

    return ans;
  }
  private static List<Integer> topoSort(int v, List<List<Integer>> adj) {
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
    List<Integer> topo=new ArrayList<>();
    while(!q.isEmpty()) {
      int node=q.peek();
      q.remove();
      topo.add(node);
      for(int it:adj.get(node)) {
        indegree[it]--;
        if(indegree[it] == 0)
          q.add(it);
      }
    }
    return topo;
  }
  public static void main(String arr[]) {
    Scanner s=new Scanner(System.in);
    
    System.out.println("Enter the number of words");
    int words=s.nextInt();
    String dictionary[]=new String[words];

    System.out.println("Enter "+words+" Alien Words");
    for(int i=0; i<words; i++)
      dictionary[i]=s.next();

    System.out.println("Enter the number of words, Alien Dictionary contatins");
    int k=s.nextInt();

    System.out.println("The Order of Characters in the Alien Language is: "+getAlienDictionary(dictionary, k));
    s.close();
  }
}