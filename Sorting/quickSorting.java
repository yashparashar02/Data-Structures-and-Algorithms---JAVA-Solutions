package Sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class quickSorting {
  
  /*public static void quickSort(int arr[], int low, int high) {
    if(low < high) {
      int pIndex=partition(arr, low, high);
      quickSort(arr, low, pIndex-1);
      quickSort(arr, pIndex+1, high);
    }
  }

  private static int partition(int arr[], int low, int high) {
    int pivot=arr[low], i=low, j=high;
    while(i<j) {
      while(i <= high-1 && arr[i] <= pivot) 
        i++;
      while(j >= low+1 && arr[j] > pivot) 
        j--;
      if(i < j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
      }
    }
    int temp=arr[low];
    arr[low]=arr[j];
    arr[j]=temp;

    return j;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the size of array");
    int n=s.nextInt();
    int arr[]=new int[n];

    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++) 
      arr[i]=s.nextInt();

    quickSort(arr, 0, n-1);
    
    for(int i:arr)
      System.out.print(i+" ");

    s.close();
  }*/

  public static List<Integer> quickSort(List<Integer> arr) {
    int n= arr.size();

    int a[]=new int[n];
    for(int i=0;i<n;i++)
      a[i]=arr.get(i);

    sort(a,0,n-1);

    List<Integer> result=new ArrayList<>();
    for(int num:a)
        result.add(num);

    return result;
  }

  private static void sort(int arr[], int low, int high) {
    if(low < high) {
      int pIndex=partition(arr, low, high);

      sort(arr, low, pIndex-1);
      sort(arr, pIndex+1, high);
    }
  }

  private static int partition(int arr[], int low, int high) {
    int pivot=arr[high], i=low-1, j;
    
    for(j=low;j<high;j++) {
      if(arr[j] < pivot) {
        i++;
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
      }
    }
    int temp=arr[i+1];
    arr[i+1]=arr[high];
    arr[high]=temp;

    return i+1;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the size of array");
    int n=s.nextInt();

    List<Integer> arr=new ArrayList<>();

    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++)
      arr.add(s.nextInt());

    List<Integer> sorted=quickSort(arr);

    System.out.println("Sorted Array:");
    for(int i:sorted)
      System.out.print(i+" ");

    s.close();
  }
}