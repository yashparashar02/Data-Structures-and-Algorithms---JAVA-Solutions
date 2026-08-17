package DailyProblems;

import java.util.Scanner;

public class maxLengthSubstring {
  static int maxLength2Occur(String s) {
    int freq[]=new int[26], maxLength=0, left=0, right;

    for(right=0; right<s.length(); right++) {
      char rightChar=s.charAt(right);
      freq[rightChar - 'a']++;

      while(freq[rightChar - 'a'] > 2) {
        char leftChar=s.charAt(left);
        freq[leftChar - 'a']--;
        left++;
      }
      maxLength=Math.max(maxLength, right-left+1);
    }
    return maxLength;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the required String value");
    String s=sc.nextLine();

    System.out.println("The Maximum Length of the Substring with 2 Occurrences is: "+maxLength2Occur(s));
    sc.close();
  }
}