package Recursion;

import java.util.Scanner;

public class factorial { // using Prametrized method and Return Function method 
  /*static int fact(int n) { // Function return
    if(n<=1)
      return n;
    return (n*fact(n-1));
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the range to print factorial: ");
    int n=s.nextInt();
    System.out.print("Factorial of " + n + " is: "+fact(n));
    s.close();
  }*/

  void fact(int n, int f) { //Parametrized method
    if(n<=1) {
      System.out.print(f);
      return;
    }
    fact(n-1,f*n);
  }
  public static void main(String[] args) {
    factorial obj=new factorial();
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the range to print factorial: ");
    int n=s.nextInt();
    System.out.print("Factorial of " + n + " is: ");
    obj.fact(n, 1);
    s.close();
  }
}