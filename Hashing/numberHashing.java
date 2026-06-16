package Hashing;

import java.util.Scanner;

public class numberHashing {
  
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter array size");
    int n=s.nextInt();
    int arr[]=new int[n];
    System.out.println("Enter "+n+" array elements:");
    for(int i=0;i<n;i++)
      arr[i]=s.nextInt();

    int max=0;
    for(int num:arr) {
      if(num>max)
        max=num;
    }

    int hash[]=new int[max+1];
    for(int num:arr) {
      if(num>=0)
      hash[num]++;
    }
      
    for(int i=0;i<hash.length;i++){
      if(hash[i]>0)
        System.out.println(i+" -> "+hash[i]);
    }
    s.close();
  }
}