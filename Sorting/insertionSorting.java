package Sorting;

import java.util.Scanner;

public class insertionSorting {
  public static void insertionSort(int arr[], int n) {
    for(int i=0;i<=n-1;i++) {
      int j=i;
      while(j>0 && arr[j-1]>arr[j]) {
        int temp=arr[j-1];
        arr[j-1]=arr[j];
        arr[j]=temp;

        j--;
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

   insertionSort(arr, n);
    
   for(int i:arr)
      System.out.print(i+" ");

    s.close();
  }
}