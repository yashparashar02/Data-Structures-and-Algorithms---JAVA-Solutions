package Recursion;

import java.util.Scanner;

public class printNumBacktrack {
  void numN(int i, int n) {
    if(i<1)
      return;
    numN(i-1,n);
    System.out.print(i+" ");
  }
  public static void main(String[] args) {
    printNumBacktrack obj=new printNumBacktrack();
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the range to print numbers: ");
    int n=s.nextInt();
    obj.numN(n,n);
    s.close();
  }
}