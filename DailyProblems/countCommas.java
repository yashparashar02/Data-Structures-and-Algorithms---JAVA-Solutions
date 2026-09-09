package DailyProblems;

import java.util.Scanner;

public class countCommas {
  static int commasCount(int n) {
    if(n < 1000)
      return 0;

    int comma=0, start=1000;

    while(start <= n) {
      comma+=(n- start + 1);
      start*=1000;
    }
    return comma;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number");
    int n=s.nextInt();

    System.out.println("The number of Commas between 1 and "+n+" is: "+commasCount(n));
    s.close();
  }
}