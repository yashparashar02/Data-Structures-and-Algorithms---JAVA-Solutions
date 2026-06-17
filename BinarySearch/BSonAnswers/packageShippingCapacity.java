package BinarySearch.BSonAnswers;

import java.util.Scanner;

public class packageShippingCapacity {
  static int countDays(int weights[], int capacity) {
    int days=1, load=0;

    for(int wt: weights) {
      if(load+wt <= capacity)
        load+=wt;

      else {
        days++;
        load=wt;
      }
    }
    return days;
  }
  static int minCapacity(int weights[], int days) {
    int low=Integer.MIN_VALUE, mid, high=0;

    for(int wt: weights) {
      low=Math.max(low, wt);
      high+=wt;
    }

    while(low <= high) {
      mid=low+(high-low)/2;

      int minDays=countDays(weights, mid);

      if(minDays <= days) 
        high=mid-1;

      else low=mid+1;
    }
    return low;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of Weights need to be carried");
    int n=s.nextInt(), weights[]=new int[n], wt;

    System.out.println("Enter "+n+" number of weight capacities");
    for(wt=0; wt<n; wt++)
      weights[wt]=s.nextInt();

    System.out.println("Enter the maximum days available");
    int days=s.nextInt();

    System.out.println("The minimium capacity that needs to be carried out is: "+minCapacity(weights, days));
    s.close();
  }
}