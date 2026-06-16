package Hashing;

import java.util.Scanner;

public class characterHashing {
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the String");
    String str=s.next();
    
    int hash[]=new int[256];
    for(char ch:str.toCharArray())
      hash[ch]++;

    for(int i=0;i<256;i++) {
      if(hash[i]>0) {
        char c=(char)(i);
        System.out.println(c+" -> "+hash[i]);
      }
    }
    s.close();
  }
}