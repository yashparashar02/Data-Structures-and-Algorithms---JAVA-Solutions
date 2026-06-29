package Strings.basicAndEasy;

import java.util.Scanner;

public class longestCommonPrefix {
  static String longestPrefix(String strs[]) {
    if(strs == null || strs.length == 0)
      return "";

    for(int i=0 ; i<strs[0].length(); i++) {
      char ch=strs[0].charAt(i);

      for(int j=1; j<strs.length; j++) {
        if(i == strs[j].length() || strs[j].charAt(i) != ch)
          return strs[0].substring(0, i);
      }
    }
    return strs[0];
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of String values you want to enter");
    int n=s.nextInt(), i; String strs[]=new String[n];
    s.nextLine();

    System.out.println("Enter "+n+" string values");
    for(i=0; i<n; i++) 
      strs[i]=s.nextLine();

    System.out.println("The longest common prefix is "+longestPrefix(strs));
    s.close();
  }
}