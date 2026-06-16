package Arrays.Hard;

import java.util.Scanner;

public class reversePairsCount {
  static int reversePairs(int nums[]) {
    return mergeSort(nums, 0, nums.length-1);
  }
  static int mergeSort(int nums[], int low, int high) {
    if(low >= high)
      return 0;

    int mid=(low+high)/2, count=0;

    count+=mergeSort(nums, low, mid);
    count+=mergeSort(nums, mid+1, high);
    count+=countPairs(nums, low, mid, high);
    merge(nums, low, mid, high);

    return count;
  }
  static int countPairs(int nums[], int low, int mid, int high) {
    int right=mid+1, count=0, i;

    for(i=low; i<=mid; i++) {
      while (right <= high && nums[i] > 2L*nums[right])
        right++;

      count+=right-(mid+1);
    }
    return count;
  }
  static void merge(int nums[], int low, int mid, int high) {
    int left=low, right=mid+1, k=0, i, temp[]=new int[high-low+1];

    while(left <= mid && right <= high) {
      if(nums[left] <= nums[right]) 
        temp[k++] = nums[left++];

      else 
        temp[k++] = nums[right++];
    }
    while(left <= mid) 
      temp[k++] = nums[left++];

    while(right <= high) 
      temp[k++] = nums[right++];

    for(i=low; i<=high; i++) 
      nums[i] = temp[i-low];
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), nums[]=new int[n], i;

    System.out.println("Enter "+n+" array elements");
    for(i=0; i<n; i++) 
      nums[i]=s.nextInt();

    System.out.println("The number of Reverse Pairs are: "+reversePairs(nums));
    s.close();
  }
}