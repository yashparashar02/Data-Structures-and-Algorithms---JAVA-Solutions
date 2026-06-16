package Arrays.Hard;

import java.util.Scanner;

public class countInversions {
  static long inversionsCount(long arr[], int n) {
    return mergeSort(arr, 0, n-1);
  }
  static long mergeSort(long arr[], int low, int high) {
    if(low >= high)
      return 0;

    int mid=(low+high)/2;
    long count=0;

    count+=mergeSort(arr, low, mid);
    count+=mergeSort(arr, mid+1, high);
    count+=merge(arr, low, mid, high);

    return count;
  }
  static long merge(long arr[], int low, int mid, int high) {
    int left=low, right=mid+1, k=0,i;
    long count=0, temp[]=new long[high-low+1];

    while(left <= mid && right <= high) {
      if(arr[left] <= arr[right]) 
        temp[k++] = arr[left++];

      else {
        count+=(mid - left + 1);
        temp[k++] = arr[right++];
      }
    }
    while(left <= mid) 
      temp[k++] = arr[left++];

    while(right <= high) 
      temp[k++] = arr[right++];

    for(i=low; i<=high; i++) 
      arr[i] = temp[i-low];

    return count;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), i;
    long nums[]=new long[n];

    System.out.println("Enter "+n+" array elements");
    for(i=0; i<n; i++) 
      nums[i]=s.nextLong();

    System.out.print("The count of inversions are: "+inversionsCount(nums, n));
    s.close();
  }
}