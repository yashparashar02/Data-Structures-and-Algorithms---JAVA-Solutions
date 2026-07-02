package Strings.basicAndEasy;

import java.util.Scanner;

public class validAnagrams {
  static boolean anagrams(String s, String t) {
    if(s.length() != t.length())
      return false;

    int freq[]=new int[26], i;

    for(i=0; i<s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
      freq[t.charAt(i) - 'a']--;
    }
    for(int count:freq) {
      if(count != 0)
        return false;
    }
    return true;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the first String");
    String s=sc.nextLine();
    System.out.println("Enter the second String");
    String t=sc.nextLine();

    System.out.println("\n"+anagrams(s, t));
    sc.close();
  }
}