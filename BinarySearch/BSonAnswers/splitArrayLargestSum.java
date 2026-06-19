package BinarySearch.BSonAnswers;

import java.util.Scanner;

public class splitArrayLargestSum {
  static int countSubarrays(int nums[], int limit) {
    int subArrays=1, sum=0;

    for(int num: nums) {
      if(sum+num <= limit)
        sum+=num;

      else {
        subArrays++;
        sum=num;
      }
    }
    return subArrays;
  }
  static int maxMinSum(int nums[], int k) {
    if(k > nums.length)
      return -1;

    int low=Integer.MIN_VALUE, mid, high=0;

    for(int num: nums) {
      low=Math.max(low, num);
      high+=num;
    }

    while(low <= high) {
      mid=low+(high-low)/2;
      
      int subArrays=countSubarrays(nums, mid);

      if(subArrays <= k)
        high=mid-1;

      else low=mid+1;
    }
    return low;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of elements");
    int n=s.nextInt(), nums[]=new int[n], i;

    System.out.println("Enter "+n+" element values");
    for(i=0; i<n; i++)
      nums[i]=s.nextInt();

    System.out.println("Enter the number of Sub Arrays");
    int k=s.nextInt();

    System.out.println("The minimized largest sum is: "+maxMinSum(nums, k));
    s.close();
  }
}