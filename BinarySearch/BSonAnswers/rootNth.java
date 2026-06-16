package BinarySearch.BSonAnswers;

import java.util.Scanner;

public class rootNth {
  static int nthRoot(int n, int m) {
    int low=1, mid, high=m;

    while(low <= high) {
      mid=low+(high-low)/2;

      int result = power(mid, n, m);

      if(result == 1)
        return mid;

      else if(result == 0)
        low=mid+1;

      else high=mid-1;
    }
    return -1;
  }
  static int power(int mid, int n, int m) {
    long val=1;
    for(int i=1; i<=n; i++) {
      val*=mid;

      if(val > m)
        return 2;
    }
    if(val == m)
      return 1;

    return 0;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the value of N");
    int n=s.nextInt();

    System.out.println("Enter the value of M");
    int m=s.nextInt();

    System.out.println("The nth root is: "+nthRoot(n, m));
    s.close();
  }
}