package Strings.basicAndEasy;

import java.util.HashMap;
import java.util.Scanner;

public class isomorphicStrings {
  static boolean isomorphic(String s, String t) {
    if(s.length() != t.length())
      return false;

    HashMap<Character, Character> mapS=new HashMap<>();
    HashMap<Character, Character> mapT=new HashMap<>();

    for(int i=0; i<s.length(); i++) {
      char ch1=s.charAt(i), ch2=t.charAt(i);

      if(mapS.containsKey(ch1)) {
        if(mapS.get(ch1) != ch2)
          return false;
      }
      else mapS.put(ch1, ch2);

      if(mapT.containsKey(ch2)) {
        if(mapT.get(ch2) != ch1)
          return false;
      }
      else mapT.put(ch2, ch1);
    }
    return true;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the 1st String");
    String s=sc.nextLine();
    System.out.println("Enter the 2nd String");
    String t=sc.nextLine();

    System.out.println(isomorphic(s, t));
    sc.close();
  }
}