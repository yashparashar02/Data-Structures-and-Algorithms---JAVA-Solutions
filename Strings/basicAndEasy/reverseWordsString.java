package Strings.basicAndEasy;

import java.util.Scanner;

public class reverseWordsString {
  static String reverseWords(String s) {
    String word[]=s.trim().split("\\s+");
    int left=0, right=word.length-1;

    while(left < right) {
      String temp = word[left];
      word[left] = word[right];
      word[right] = temp;

      left++;
      right--;
    }
    return String.join(" ", word);
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the String");
    String str=s.nextLine();

    System.out.println("The reversed String is \n"+reverseWords(str));
    s.close();
  }
}