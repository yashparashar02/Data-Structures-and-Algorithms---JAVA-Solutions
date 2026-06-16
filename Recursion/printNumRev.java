package Recursion;

import java.util.Scanner;

public class printNumRev {
  void numRevN(int i, int n) {
    if(i<1)
      return;
    System.out.print(i+" ");
    numRevN(i-1,n);
  }
  public static void main(String[] args) {
    printNumRev obj=new printNumRev();
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the range to print numbers: ");
    int n=s.nextInt();
    obj.numRevN(n,n);
    s.close();
  }
}