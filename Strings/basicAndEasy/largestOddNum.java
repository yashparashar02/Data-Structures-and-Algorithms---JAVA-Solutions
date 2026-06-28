package Strings.basicAndEasy;

import java.util.Scanner;

public class largestOddNum {
  static String largestOddSubstring(String num) {
    for(int i=num.length()-1; i>=0; i--) {
      char ch=num.charAt(i);

      if((ch - '0')%2 == 1)
        return num.substring(0, i+1);
    }
    return " ";
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the String");
    String num=s.nextLine();

    System.out.println("The largest odd substring is: "+largestOddSubstring(num));
    s.close();
  }
}