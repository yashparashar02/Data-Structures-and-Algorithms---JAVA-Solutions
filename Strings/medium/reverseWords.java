package Strings.medium;

import java.util.Scanner;

public class reverseWords {
  static String revWords(String s) {
    char arr[]=s.toCharArray();
    int left=0, right;

    for(right=0; right<=arr.length; right++) {
      if(right == arr.length || arr[right] == ' ') {
        reverse(arr, left, right-1);
        left=right+1;
      }
    }
    return new String(arr);
  }
  static void reverse(char arr[], int left, int right) {
    while(left < right) {
      char temp=arr[left];
      arr[left] = arr[right];
      arr[right] = temp;

      left++;
      right--;
    }
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the String Sentence");
    String s=sc.nextLine();

    System.out.println("The Reversed String is \t"+revWords(s));
    sc.close();
  }
}