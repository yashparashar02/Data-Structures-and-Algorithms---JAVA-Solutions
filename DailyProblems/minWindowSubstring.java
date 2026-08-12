package DailyProblems;

import java.util.Scanner;

public class minWindowSubstring {
  static String minWindow(String s, String t) {
    if(s == null || t == null || s.length() < t.length())
      return "";

    int target[]=new int[128], cnt=0;

    for(char c:t.toCharArray()) {
      if(target[c] == 0)
        cnt++;

      target[c]++;
    }

    int window[]=new int[128], matched=0, minLen=Integer.MAX_VALUE, minStart=0, left=0, right;

    for(right=0; right<s.length(); right++) {
      char rightChar=s.charAt(right);
      window[rightChar]++;

      if(target[rightChar] > 0 && window[rightChar] == target[rightChar])
        matched++;

      while(matched == cnt) {
        int currLen=right-left+1;

        if(currLen < minLen) {
          minLen=currLen;
          minStart=left;
        }
        char leftChar=s.charAt(left);
        window[leftChar]--;
        
        if(target[leftChar] > 0 && window[leftChar] < target[leftChar])
          matched--;

        left++;
      }
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the 2 strings seperately");
    String s=sc.nextLine(), t=sc.nextLine();

    System.out.println("The Minimum Window Substring is: "+minWindow(s, t));
    sc.close();
  }
}