package Strings.medium;

import java.util.Scanner;

public class maxNestingDepthFreq {
  static int maxDepthFreq(String s) {
    int currDepth=0, maxDepth=0;
    
    for(char ch: s.toCharArray()) {
      if(ch == '(') {
        currDepth++;
        maxDepth=Math.max(maxDepth, currDepth);
      }

      else if(ch == ')')
        currDepth--;
    }
    return maxDepth;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the String");
    String s=sc.nextLine();

    System.out.println("The Maximum no. Nested Valid Paranthesis are: "+maxDepthFreq(s));
    sc.close();
  }
}