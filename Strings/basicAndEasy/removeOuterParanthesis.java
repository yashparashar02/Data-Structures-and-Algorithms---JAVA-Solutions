package Strings.basicAndEasy;

import java.util.Scanner;

public class removeOuterParanthesis {
  static String removeParanthesis(String s) {
    StringBuilder ans=new StringBuilder();
    int depth=0;

    for(char ch:s.toCharArray()) {
      if(ch == '(') {
        if(depth > 0) 
          ans.append(ch);

        depth++;
      }

      else  {
        depth--;
        if(depth > 0) 
          ans.append(ch);
      }
    }
    return ans.toString();
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the paranthesis");
    String str=s.next();

    System.out.println("The output after the outermost paranthesis removal is \n"+removeParanthesis(str));
    s.close();
  }
}