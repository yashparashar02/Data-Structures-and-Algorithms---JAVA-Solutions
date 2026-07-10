package Strings.medium;

import java.util.Scanner;

public class beautySubstring {
  static int beautySum(String s) {
    int ans=0, start, end;

    for(start=0; start<s.length(); start++) {
      int frequency[]=new int[26];

      for(end=start; end<s.length(); end++) {
        frequency[s.charAt(end) - 'a']++;

        int maxFreq=0, minFreq=Integer.MAX_VALUE;

        for(int freq: frequency) {
          if(freq > 0) {
            maxFreq=Math.max(maxFreq, freq);
            minFreq=Math.min(minFreq, freq);
          }
        }
        ans+=(maxFreq-minFreq);
      }
    }
    return ans;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the String value");
    String s=sc.nextLine();

    System.out.println("The sum of Beauty of All Substrings is "+beautySum(s));
    sc.close();
  }
}