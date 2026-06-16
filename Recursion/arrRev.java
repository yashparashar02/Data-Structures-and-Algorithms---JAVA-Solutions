package Recursion;

import java.util.Scanner;

public class arrRev {
  /*static void revArr(int l, int r, int arr[]) { //using double index
    if(l>=r)
      return;
    
    int temp=arr[l];
    arr[l]=arr[r];
    arr[r]=temp;

    revArr(l+1,r-1,arr);
  }*/
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the range of the array");
    int n=s.nextInt();
    int arr[]=new int[n];
    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++) 
      arr[i]=s.nextInt();
    
    revArr(0,n,arr);
    System.out.println("The reverse of the array is: ");
    for(int i=0;i<n;i++) 
      System.out.print(arr[i]+" ");
    s.close();
  }

  static void revArr(int i,int n, int arr[]) { //using single index
    if(i>=n/2)
      return;

    int temp=arr[i];
    arr[i]=arr[n-i-1];
    arr[n-i-1]=temp;

    revArr(i+1,n,arr);
  }
}