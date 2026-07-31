package DailyProblems;

import java.util.Scanner;

public class sumAndMultiply {
  static long sumMultiply(int n) {
    if(n == 0)
      return 0L;

    long x=0, sum=0;

    String s=String.valueOf(n);

    for(int i=0; i<s.length(); i++) {
      int digit=s.charAt(i) - '0';

      if(digit != 0) {
        x=x*10+digit;
        sum+=digit;
      }
    }
    return x*sum;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number");
    int n=s.nextInt();

    System.out.println("The product is: "+sumMultiply(n));
    s.close();
  }
}