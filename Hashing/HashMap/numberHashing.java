package Hashing.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class numberHashing {
  public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
    System.out.println("Enter array size");
    int n=s.nextInt();
    int arr[]=new int[n];
    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++)
       arr[i]=s.nextInt();
    HashMap<Integer, Integer> map=new HashMap<>();
    for(int num:arr)
      map.put(num,map.getOrDefault(num, 0)+1);
    System.out.println(map);
    /*for(int key:map.keySet())
      System.out.println(key+"->"+map.get(key));*/
    s.close();
  }
}
