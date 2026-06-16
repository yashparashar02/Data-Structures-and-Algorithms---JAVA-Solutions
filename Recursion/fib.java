package Recursion;

import java.util.Scanner;

public class fib {
  static int fibo(int n) {
    if(n<=1)
      return n;
    return fibo(n-1) + fibo(n-2);
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the number: ");
    int num=s.nextInt();
    System.out.println(fibo(num));
    s.close();
  }
}