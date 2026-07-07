package Strings.medium;

import java.util.HashMap;
import java.util.Scanner;

public class romanToInteger {
  static int romanInt(String s) {
    HashMap<Character, Integer> map=new HashMap<>();
    map.put('I', 1); map.put('V', 5);
    map.put('X', 10); map.put('L', 50);
    map.put('C', 100); map.put('D', 500);
    map.put('M', 1000);

    int ans=0, i, current;

    for(i=0; i< s.length(); i++) {
      current=map.get(s.charAt(i));

      if(i < s.length()-1 && current < map.get(s.charAt(i+1)))
        ans-=current;

      else ans+=current;
    }
    return ans;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the Roman Value");
    String s=sc.nextLine();

    System.out.println("The Integer value of "+s+" is: "+romanInt(s));
    sc.close();
  }
}