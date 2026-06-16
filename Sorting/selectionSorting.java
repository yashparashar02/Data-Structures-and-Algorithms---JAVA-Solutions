package Sorting;

import java.util.Scanner;

public class selectionSorting {
  public static void selectionSort(int arr[], int n) {
    for(int i=0;i<=n-1;i++) {
      int min=i;
      for(int j=i;j<=n-1;j++) {
        if(arr[j]<arr[min])
          min=j;
      }
      int temp=arr[min];
      arr[min]=arr[i];
      arr[i]=temp;
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

    selectionSort(arr, n);
    
    for(int i:arr)
      System.out.print(i+" ");

    s.close();
  }
}