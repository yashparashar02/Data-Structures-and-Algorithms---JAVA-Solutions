package Graphs.Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class courseSchedule2 {
  static int[] courseCompleted(int numCourses, int prerequisites[][]) {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0; i<numCourses; i++)
      adj.add(new ArrayList<>());

    for(int[] pair:prerequisites) {
      int course=pair[0], prereq=pair[1];
      adj.get(prereq).add(course);
    }

    int indegree[]=new int[numCourses], i;
    for(i=0; i<numCourses; i++) {
      for(int it:adj.get(i))
        indegree[it]++;
    }
    Queue<Integer> q=new LinkedList<Integer>();
    for(i=0; i<numCourses; i++) {
      if(indegree[i] == 0)
        q.add(i);
    }
    int topo[]=new int[numCourses], ind=0;
    while(!q.isEmpty()) {
      int node=q.peek();
      q.remove();
      topo[ind++]=node;
      for(int it:adj.get(node)) {
        indegree[it]--;
        if(indegree[it] == 0)
          q.add(it);
      }
    }
    if(ind == numCourses)
      return topo;

    int arr[]={};
    return arr;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of rows for prerequisites");
    int row=s.nextInt(), r;
    System.out.println("Enter the number of columns for prerequisites");
    int col=s.nextInt(), c;

    int prerequisites[][]=new int[row][col];
    System.out.println("Enter "+row+"x"+col+" number of prerequisites");
    for(r=0; r<row; r++) {
      for(c=0; c<col; c++)
        prerequisites[r][c]=s.nextInt();
    }

    System.out.println("Enter the number of courses");
    int courses=s.nextInt();

    System.out.println("The Courses Completed are: ");
    int result[]=courseCompleted(courses, prerequisites);
    for(int res:result)
      System.out.print(res+" ");
    s.close();
  }
}