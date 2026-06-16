package BinarySearch.BSonAnswers;

import java.util.Scanner;

public class findSqrt {
  static int sqrt(long n) {
    long low=0, mid, high=n;

    while(low <= high) {
      mid=low+(high-low)/2;

      if(mid*mid <= n)
        low=mid+1;

      else high=mid-1;
    }
    return (int) high;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number");
    int n=s.nextInt();

    System.out.println("The Floor Square Root of "+n+" is "+sqrt(n));
    s.close();
  }
}