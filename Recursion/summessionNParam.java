package Recursion;

import java.util.Scanner;

public class summessionNParam {
  void sumN(int i, int sum) {
    if(i<1) {
      System.out.print(sum);
      return;
    }
    sumN(i-1,sum+i);
  }
  public static void main(String[] args) {
    summessionNParam obj=new summessionNParam();
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the range to print summession: ");
    int n=s.nextInt();
    System.out.print("Summession of " + n + " is: ");
    obj.sumN(n, 0);
    s.close();
  }
}