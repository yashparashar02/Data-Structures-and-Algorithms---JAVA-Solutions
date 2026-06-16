package Recursion;

import java.util.Scanner;

public class summessionNFunc {
  static int sumN(int n) {
    if(n==0)
      return 0;
    return (n+sumN(n-1));
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the range to print summession: ");
    int n=s.nextInt();
    System.out.print("Summession of " + n + " is: "+sumN(n));
    s.close();
  }
}