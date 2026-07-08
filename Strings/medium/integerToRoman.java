package Strings.medium;

import java.util.Scanner;

public class integerToRoman {
  static String intRoman(int num) {
    int numeral[]={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}, i;

    String roman[]={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    StringBuilder ans=new StringBuilder();

    for(i=0; i<numeral.length; i++) {
      while(num >= numeral[i]) {
        ans.append(roman[i]);
        num-=numeral[i];
      }
    }
    return ans.toString();
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the Number to convert to Roman");
    int num=s.nextInt();

    System.out.println("The Roman value of "+num+" is: "+intRoman(num));
    s.close();
  }
}