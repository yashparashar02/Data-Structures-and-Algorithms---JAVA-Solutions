package Recursion;

import java.util.*;

public class printNumRevBacktrack {
void numRevN(int i, int n) {
    if(i>n)
      return;
    numRevN(i+1,n);
    System.out.print(i+" ");
  }
  public static void main(String[] args) {
    printNumRevBacktrack obj=new printNumRevBacktrack();
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the range to print numbers: ");
    int n=s.nextInt();
    obj.numRevN(1,n);
    s.close();
  }
}