package DailyProblems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class validParenthesis {
  static boolean isValid(String s) {
    if(s.length()%2 != 0)
      return false;

    Deque<Character> stack=new ArrayDeque<>();

    for(char c:s.toCharArray()) {
      if(c == '(')
        stack.push(')');

      else if(c == '{')
        stack.push('}');

      else if(c == '[')
        stack.push(']');

      else {
        if(stack.isEmpty() || stack.pop() != c)
          return false;
      }
    }
    return stack.isEmpty();
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the Parenthesis");
    String s=sc.nextLine();
    
    if(isValid(s))
      System.out.println(isValid(s)+", the Parenthesis are valid");
    else System.out.println(isValid(s)+", the parenthesis is not valid");

    sc.close();
  }
}