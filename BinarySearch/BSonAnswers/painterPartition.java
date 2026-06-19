package BinarySearch.BSonAnswers;

import java.util.Scanner;

public class painterPartition {
  static int countPainters(int boards[], int limit) {
    int painters=1, work=0;

    for(int board: boards) {
      if(work+board <= limit)
        work+=board;

      else {
        painters++;
        work=board;
      }
    }
    return painters;
  }
  static int maxMinTime(int boards[], int k) {
    if(k > boards.length)
      return -1;

    int low=Integer.MIN_VALUE, mid, high=0;

    for(int board: boards) {
      low=Math.max(low, board);
      high+=board;
    }

    while (low <= high) {
      mid=low+(high-low)/2;

      int painters=countPainters(boards, mid);

      if(painters <= k)
        high=mid-1;

      else low= mid+1;
    }
    return low;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of boards to be painted");
    int n=s.nextInt(), boards[]=new int[n], i;

    System.out.println("Enter the length of each boards to be painted");
    for(i=0; i<n; i++)
      boards[i]=s.nextInt();

    System.out.println("Enter the number of painters");
    int k=s.nextInt();

    System.out.println("The maximum possible minimum time required to paint the boards are: "+maxMinTime(boards, k));
    s.close();
  }
}