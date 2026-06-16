package BinarySearch.BSonAnswers;

import java.util.Scanner;

public class kokoBananas {
  static long calcHrs(int piles[], int speed) {
    long totalHrs=0;
    for(int pile:piles)
      totalHrs+=(pile + speed - 1)/speed;

    return totalHrs;
  }
  static int minSpeed(int piles[], int h) {
    int maxPile=0;
    
    for(int pile: piles)
      maxPile=Math.max(maxPile, pile);

    int low=1, mid, high=maxPile;

    while(low <= high) {
      mid=low+(high-low)/2;
      long hrs=calcHrs(piles, mid);

      if(hrs <= h)
        high=mid-1;

      else low=mid+1;
    }
    return low;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the piles range");
    int n=s.nextInt(), piles[]=new int[n], i;

    System.out.println("Enter "+n+" no. of piles");
    for(i=0; i<n; i++)
      piles[i] = s.nextInt();

    System.out.println("Enter the maximum time limit");
    int h=s.nextInt();

    System.out.println("The minimum speed required to complete the eating of bananas in "+h+" is "+minSpeed(piles, h));
    s.close();
  }
}