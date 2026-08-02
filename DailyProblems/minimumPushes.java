package DailyProblems;

import java.util.Scanner;

public class minimumPushes {
  static int minPush(String word) {
    int n=word.length();

    if(n <= 8) 
        return n*1;

    if(n <= 16)
        return 8*1 + (n-8)*2;

    if(n <= 24)
        return 8*1 + 8*2 + (n-16)*3;

    return 8*1 + 8*2 + 8*3 + (n-24)*4;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the String");
    String word=sc.nextLine();

    System.out.println("The Minimum Number of Pushes are: "+minPush(word));
    sc.close();
  }
}