package Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class highestOcuurNum {
  public static int highestOccuringNum(int arr[]) {
    HashMap<Integer, Integer> map=new HashMap<>();

    for(int num:arr) 
      map.put(num, map.getOrDefault(num, 0)+1);

    int maxFreq=0;
    int result=arr[0];

    for(int num:arr) {
      if(map.get(num)>maxFreq) {
        maxFreq=map.get(num);
        result=num;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the range of array");
    int n=s.nextInt();
    int arr[]=new int[n];
    
    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++)
      arr[i]=s.nextInt();
    
    System.out.println("The highest occuring number from the array is: "+highestOccuringNum(arr));
    s.close();
  }
}