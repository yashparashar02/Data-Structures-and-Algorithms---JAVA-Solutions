package BinarySearch.BSonAnswers;

import java.util.Scanner;

public class minDayMBouquet {
  static int countBouquet(int bloomDay[], int day, int k) {
    int bouquet=0, flower=0;

    for(int bloom: bloomDay) {
      if(bloom <= day)
        flower++;

      else {
        bouquet+=flower/k;
        flower=0;
      }
    }
    bouquet+=flower/k;

    return bouquet;
  }
  static int minDays(int bloomDay[], int m, int k) {
    long requiredFlower=(long) m*k;

    if(requiredFlower > bloomDay.length)
      return -1;

    int low=Integer.MAX_VALUE, mid, high=Integer.MIN_VALUE;

    for(int day:bloomDay) {
      low=Math.min(low, day);
      high=Math.max(high, day);
    }

    while(low <= high) {
      mid=low+(high-low)/2;

      int bouquet=countBouquet(bloomDay, mid, k);

      if(bouquet >= m)
        high=mid-1;

      else low=mid+1;
    }
    return low;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of flowers that are blooming");
    int n=s.nextInt(), bloomDay[]=new int[n], i;

    System.out.println("Emter number of days for "+n+" flowers to bloom");
    for(i=0; i<n; i++)
      bloomDay[i] = s.nextInt();

    System.out.println("Enter the no. of bouquets");
    int m=s.nextInt();

    System.out.println("Enter the number of flowers required in the bouquet");
    int k=s.nextInt();

    System.out.println("The minimum days required to create "+m+" boquets of "+k+" flowers are: "+minDays(bloomDay, m, k));
    s.close();
  }
}