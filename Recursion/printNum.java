package Recursion;

import java.util.Scanner;

public class printNum {
  void numN(int i, int n) {
    if(i>n)
      return;
    System.out.print(i+" ");
    numN(i+1,n);
  }
  public static void main(String[] args) {
    printNum obj=new printNum();
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the range to print numbers: ");
    int n=s.nextInt();
    obj.numN(1,n);
    s.close();
  }
}