package DailyProblems.Others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class generateParenthesis {
  static List<String> Parenthesis(int n) {
    List<String> result=new ArrayList<>();

    backtrack(result, new StringBuilder(), 0, 0, n);

    return result;
  }
  static void backtrack(List<String> result, StringBuilder current, int open, int close, int n) {
    if(open == n && close == n) {
      result.add(current.toString());
      return;
    }

    if(open < n) {
      current.append('(');
      backtrack(result, current, open+1, close, n);
      current.deleteCharAt(current.length()-1);
    }

    if(close < open) {
      current.append(')');
      backtrack(result, current, open, close+1, n);
      current.deleteCharAt(current.length()-1);
    }
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of Parenthesis");
    int n=s.nextInt();

    System.out.println("The nos of Generated Valid Parenthesis are: "+Parenthesis(n));
    s.close();
  }
}