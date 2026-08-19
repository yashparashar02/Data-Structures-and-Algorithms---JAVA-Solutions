package DailyProblems;

import java.util.Scanner;

public class longestValidParanthesis {
  static int longestParanthesis(String s) {
    int maxLength=0, left=0, right=0, i;

    for(i=0; i<s.length(); i++) {
      if(s.charAt(i) == '(') 
        left++;
      else 
        right++;

      if(left == right)
        maxLength=Math.max(maxLength, 2*right);
      else if(right > left)
        left=right=0;
    }
    left=right=0;

    for(i=s.length()-1; i>=0; i--) {
      if(s.charAt(i) == '(')
        left++;
      else 
        right++;

      if(left == right)
        maxLength=Math.max(maxLength, 2*left);
      else if(left > right)
        left=right=0;
    }
    return maxLength;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the paranthesises");
    String s=sc.nextLine();

    System.out.println("The Longest Valid Parantehsis is: "+longestParanthesis(s));
    sc.close();
  }
}