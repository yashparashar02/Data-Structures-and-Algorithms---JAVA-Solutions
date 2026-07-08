package Strings.medium;

import java.util.Scanner;

public class stringToInteger {
  static int myAtoi(String s) {
    int i=0, n=s.length(), sign=1;

    while(i < n && s.charAt(i) == ' ')
      i++;

    if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
      if(s.charAt(i) == '-') 
        sign=-1;

      i++;
    }

    int ans=0;
    
    while (i < n && Character.isDigit(s.charAt(i))) {
      int digit=s.charAt(i) - '0';

      if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && digit > 7))
        return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;

      ans=ans*10+digit;
      i++;
    }
    return ans*sign;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the String Value");
    String s=sc.nextLine();

    System.out.println("The Integer Value for "+s+" is: "+myAtoi(s));
    sc.close();
  }
}