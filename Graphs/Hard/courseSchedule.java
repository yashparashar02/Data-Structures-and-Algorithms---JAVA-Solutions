package Graphs.Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class courseSchedule {
  static boolean canFinish(int numCourses, int prerequisites[][]) {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    int indegree[]=new int[numCourses], i;

    for(i=0; i<numCourses; i++)
      adj.add(new ArrayList<>());

    for(int[] pair:prerequisites) {
      int course=pair[0], prereq=pair[1];
      adj.get(prereq).add(course);
      indegree[course]++;
    }
    Queue<Integer> queue=new LinkedList<>();
    for(i=0; i<numCourses; i++) {
      if(indegree[i] == 0)
        queue.offer(i);
    }
    int processedCount = 0;
    while(!queue.isEmpty()) {
      int curr=queue.poll();
      processedCount++;
      for(int neighbor:adj.get(curr)) {
        indegree[neighbor]--;
        if(indegree[neighbor] == 0)
          queue.offer(neighbor);
      }
    }
    return processedCount == numCourses;
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

    if(canFinish(courses, prerequisites))
      System.out.println("True, "+courses+" courses can be completed");

    else System.out.println("False, "+courses+" courses cannot be completed");
    s.close();
  }
}