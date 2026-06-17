package BinarySearch.BSonAnswers;

import java.util.Arrays;
import java.util.Scanner;

public class aggressiveCows {
  static boolean canPlace(int stalls[], int k, int distance) {
    int cows=1, last=stalls[0], i;
    for(i=0; i<stalls.length; i++) {
      if(stalls[i]-last >= distance) {
        cows++;
        last=stalls[i];

        if(cows >= k)
          return true;
      }
    }
    return false;
  }
  static int maxMinDist(int stalls[], int k) {
    Arrays.sort(stalls);
    int low=1, mid, high=stalls[stalls.length - 1] - stalls[0];

    while (low <= high) {
      mid=low+(high-low)/2;

      if(canPlace(stalls, k, mid))
        low=mid+1;

      else high=mid-1;
    }
    return high;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the no. of stalls");
    int n=s.nextInt(), stalls[]=new int[n], i;

    System.out.println("Enter "+n+" stalls positions");
    for(i=0; i<n; i++)
      stalls[i]=s.nextInt();

    System.out.println("Enter the no. of cows");
    int k=s.nextInt();

    System.out.println("The maximum possible minimum distance between stalls are: "+maxMinDist(stalls, k));
    s.close();
  }
}