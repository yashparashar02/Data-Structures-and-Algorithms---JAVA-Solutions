package DailyProblems;

import java.util.Arrays;
import java.util.Scanner;

public class longestSubstringLength {
  static int lengthLongestSubstring(String s) {
    int maxLength=0;

    int lastIndex[]=new int[128];
    Arrays.fill(lastIndex, -1);

    int left=0, right;
    for(right=0; right<s.length(); right++) {
      char current=s.charAt(right);

      if(lastIndex[current] >= left)
        left=lastIndex[current]+1;

      lastIndex[current] = right;

      maxLength=Math.max(maxLength, right-left+1);
    }
    return maxLength;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the String");
    String s=sc.nextLine();

    System.out.println("The Length of Longest Substring is: "+lengthLongestSubstring(s));
    sc.close();
  }
}