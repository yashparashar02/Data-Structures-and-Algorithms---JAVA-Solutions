package Hashing.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class characterHashing {
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the String");
    String str=s.next();

    HashMap<Character,Integer> map=new HashMap<>();

    for(char ch:str.toCharArray())
      map.put(ch, map.getOrDefault(ch, 0)+1);

    System.out.println(map);
    s.close();
  }
}