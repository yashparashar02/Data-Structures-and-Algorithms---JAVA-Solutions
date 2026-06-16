package Sorting;

import java.util.Scanner;

public class bubbleSorting {
  public static void bubbleSort(int arr[],int n) {
    for(int i=n-1;i>=1;i--) {// for(int i=0;i<=n-1;i++)  {
      for(int j=0;j<=i-1;j++) {// for(int j=0;j<=n-i-2;j++) {
        if(arr[j]>arr[j+1]) {
          int temp=arr[j];
          arr[j]=arr[j+1];
          arr[j+1]=temp;
        }
      }
    }
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the size of array");
    int n=s.nextInt();
    int arr[]=new int[n];

    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++) 
      arr[i]=s.nextInt();

   bubbleSort(arr, n);
    
   for(int i:arr)
      System.out.print(i+" ");

    s.close();
  }
}