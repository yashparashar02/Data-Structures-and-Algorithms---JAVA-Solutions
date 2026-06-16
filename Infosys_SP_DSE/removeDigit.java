package Infosys_SP_DSE;

import java.util.*;

public class removeDigit {
  public static String removeDigStr(String number, char digit) {
    int n=number.length(),i;

    for(i=0;i<n-1;i++) {
      if(number.charAt(i)==digit && number.charAt(i+1)>digit)
        return number.substring(0,i) + number.substring(i+1);
    }

    int lastIndex=number.lastIndexOf(digit);
    return number.substring(0,lastIndex) + number.substring(lastIndex+1);
  }

  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the number:");
    String number=s.next();
    System.out.println("Enter the digit:");
    char digit=s.next().charAt(0);
    System.out.println("The highest no. after removin digits is: "+removeDigStr(number, digit));
    s.close();
  }
}
