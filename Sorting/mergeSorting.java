package Sorting;

import java.util.Scanner;

public class mergeSorting {
  static void merge(int arr[], int low, int mid, int high){
    int n1 = mid - low + 1;
    int n2 = high - mid;

    int left[] = new int[n1];
    int right[] = new int[n2];

    for(int i = 0; i < n1; i++) 
      left[i] = arr[low + i];
    for(int j = 0; j < n2; j++) 
      right[j] = arr[mid + 1 + j];

    int i=0, j=0, k=low;

    while(i<n1 && j<n2){
      if(left[i] <= right[j])
        arr[k++] = left[i++];
      else
        arr[k++] = right[j++];
    }

    while(i<n1) 
      arr[k++] = left[i++];
    while(j<n2) 
      arr[k++] = right[j++];
  }

  static void mergeSort(int arr[], int low, int high){
    if(low < high){
      int mid = (low + high) / 2;
      mergeSort(arr, low, mid);
      mergeSort(arr, mid+1, high);
      merge(arr, low, mid, high);
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

    mergeSort(arr, 0, n-1);
    
    for(int i:arr)
      System.out.print(i+" ");

    s.close();
  }
}

/*import java.util.ArrayList;
import java.util.List;

public class mergeSorting {
  public static void merge(int arr[], int low, int mid, int high) {
    List<Integer>temp=new ArrayList<>();
    int left=low, right=mid+1;

    while (left<=mid && right<=high) {
      if(arr[left] <= arr[right])
        temp.add(arr[left++]);
      else 
        temp.add(arr[right++]);
    }

    while (left <= mid) 
      temp.add(arr[left++]);
    
    while (right <= high) 
      temp.add(arr[right++]);
    
    for(int i=low;i<=high;i++)
      arr[i]=temp.get(i-low);
  }  

  public static void mergeSort(int arr[], int low, int high) {
    if(low>=high)
      return;

    int mid=(low + high)/2;
    mergeSort(arr, low, mid);
    mergeSort(arr, mid+1, high);
    merge(arr, low, mid, high);
  }
     */