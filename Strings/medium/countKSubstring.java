package Strings.medium;

import java.util.HashMap;
import java.util.Scanner;

public class countKSubstring {
  static int kSubstringCount(String s, int k) {
    return atMostK(s, k) - atMostK(s, k-1);
  }
  static int atMostK(String s, int k) {
    if(k < 0)
      return 0;

    HashMap<Character, Integer> map=new HashMap<>();

    int left=0, count=0, right;

    for(right=0; right<s.length(); right++) {
      char ch=s.charAt(right);

      map.put(ch, map.getOrDefault(ch, 0)+1);

      while(map.size() > k) {
        char leftChar=s.charAt(left);
        
        map.put(leftChar, map.get(leftChar) - 1);

        if(map.get(leftChar) == 0)
          map.remove(leftChar);

        left++;
      }
      count+=(right-left+1);
    }
    return count;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the String Value");
    String s=sc.nextLine();
    System.out.println("Enter the number of Substrings");
    int k=sc.nextInt();

    System.out.println("The no. of substrings are: "+kSubstringCount(s, k));
    sc.close();
  }
}