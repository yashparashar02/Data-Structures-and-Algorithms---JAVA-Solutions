package BinarySearch.BSon1DArrays;

import java.util.Scanner;

public class findPeak {
  static int peak(int nums[]) {
    int n=nums.length;

    if(n==1) 
      return 0;

    if(nums[0] > nums[1])
      return 0;
    
    if(nums[n-1] > nums[n-2])
      return n-1;

    int low=1, mid, high=n-2;

    while (low <= high) {
      mid=low+(high-low)/2;

      if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
        return mid;

      else if(nums[mid] > nums[mid-1])
        low=mid+1;

      else high=mid-1;
    }
    return -1;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array");
    int n=s.nextInt(), i, nums[]=new int[n];

    System.out.println("Enter "+n+" array elemnts");
    for(i=0; i<n; i++)
      nums[i]=s.nextInt();

    System.out.println("The Peak element is: "+peak(nums));
    s.close();
  }
}