package Strings.basicAndEasy;

import java.util.Scanner;

public class rotateString {
  static int[] buildLPS(String goal) {
    int lps[]=new int[goal.length()], len=0, i=1;

    while(i < goal.length()) {
      if(goal.charAt(i) == goal.charAt(len)){
        len++;
        lps[i]=len;
        i++;
      }
      else {
        if(len != 0)
          len=lps[len-1];

        else {
          lps[i]=0;
          i++;
        }
      }
    }
    return lps;
  }
  static boolean rotate(String s, String goal) {
    if(s.length() != goal.length())
      return false;

    if(s.length() == 0 && goal.length() == 0)
      return true;

    String temp=s+s;
    int lps[]=buildLPS(goal), i=0, j=0;

    while (i < temp.length()) {
      if(temp.charAt(i) == goal.charAt(j)) {
        i++;
        j++;

        if(j == goal.length())
          return true;
      }

      else {
        if(j != 0)
          j=lps[j-1];

        else i++;
      }
    }
    return false;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the String");
    String s=sc.nextLine();
    System.out.println("Enter the Goal string");
    String goal=sc.nextLine();

    System.out.println(rotate(s, goal));
    sc.close();
  }
}