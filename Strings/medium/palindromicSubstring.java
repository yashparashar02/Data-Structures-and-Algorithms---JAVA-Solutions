package Strings.medium;

import java.util.Scanner;

public class palindromicSubstring {
  static int substringCount(String s) {
    int count=0, i;

    for(i=0; i<s.length(); i++) {
      count+=expandPalindrome(s, i, i);

      count+=expandPalindrome(s, i, i+1);
    }
    return count;
  }
  static int expandPalindrome(String s, int left, int right) {
    int count=0;

    while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      count++;

      left--;

      right++;
    }
    return count;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the String");
    String s=sc.nextLine();

    System.out.println("The number of Palindromic Strings are "+substringCount(s));
    sc.close();
  }
}