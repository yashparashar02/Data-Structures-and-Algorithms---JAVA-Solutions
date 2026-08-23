package DailyProblems;

import java.util.Scanner;

public class checkDivisiblitySumProd {
  static boolean checkDivisiblity(int n) {
    int temp=n, sum=0, prod=1;

    while(temp > 0) {
      int digit=temp%10;

      sum+=digit;
      prod*=digit;

      temp/=10;
    }
    int result=sum+prod;

    return n%result == 0;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the Number to check Divisiblity");
    int n=s.nextInt();

    if(checkDivisiblity(n))
      System.out.println(checkDivisiblity(n)+", "+n+" is Divisible by the Sum of its Digit's Sum and Product");

    else System.out.println(checkDivisiblity(n)+", "+n+" is not Divisible by the Sum of its Digit's Sum and Product");
    s.close();
  }
}