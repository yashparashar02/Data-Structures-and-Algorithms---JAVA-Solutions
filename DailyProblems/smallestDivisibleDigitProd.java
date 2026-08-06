package DailyProblems;

import java.util.Scanner;

public class smallestDivisibleDigitProd {
  static int smallestNum(int n, int t) {
    int current=n;

    while(true) {
      if(digitProd(current) % t == 0)
        return current;

      current++;
    }
  }
  static int digitProd(int n) {
    if(n == 0)
      return 0;

    int prod=1;
    while(n > 0) {
      prod*=(n%10);
      n/=10;
    }
    return prod;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the Number N and number T");
    int n=s.nextInt(), t=s.nextInt();

    System.out.println("The Smallest Divisible Digit Product is: "+smallestNum(n, t));
    s.close();
  }
}