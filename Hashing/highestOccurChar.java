package Hashing;

import java.util.Scanner;

public class highestOccurChar {
  public static char highestOccuringChar(String str) {
    int hash[]=new int[26];

    for(char ch:str.toCharArray())
      hash[ch-'a']++;

    int maxFreq=0;
    char result=str.charAt(0);

    for(char ch:str.toCharArray()) {
      if(hash[ch-'a']>maxFreq) {
        maxFreq=hash[ch-'a'];
        result=ch;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the String");
    String str=s.next();
    System.out.println("The character with highest frequency is "+highestOccuringChar(str));
    s.close();
  }
}