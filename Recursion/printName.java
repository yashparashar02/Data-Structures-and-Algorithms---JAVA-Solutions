package Recursion;

import java.util.Scanner;

public class printName {
  void nameN(int i, int n) {
    if(i>n)
      return;
    System.out.println("Yash Parashar");
    nameN(i+1,n);
  }
  public static void main(String[] args) {
    printName obj=new printName();
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the number of time you want to print the name: ");
    int n=s.nextInt();
    obj.nameN(1,n);
    s.close();
  }
}
