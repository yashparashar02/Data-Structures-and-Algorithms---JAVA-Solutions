package Recursion;

import java.util.Scanner;

public class palindrome {
  static boolean isPalin(String s, int i) {
    if(i>=s.length()/2)
      return true;

    if(s.charAt(i)!=s.charAt(s.length()-i-1))
      return false;

    return isPalin(s, i+1);
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the String");    
    String s=sc.next();
    
    if(isPalin(s, 0))
      System.out.println("Palindrome");
    else System.out.println("Not Palindrome");
    sc.close();
  }
}