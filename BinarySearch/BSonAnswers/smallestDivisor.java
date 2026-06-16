package BinarySearch.BSonAnswers;

import java.util.Scanner;

public class smallestDivisor {
  static int countSum(int nums[], int divisor) {
    int sum=0;

    for(int num: nums) 
      sum+=(num+divisor-1)/divisor;

    return sum;
  }
  static int smallestDiv(int nums[], int limit) {
    int maxNum=Integer.MAX_VALUE;

    for(int num: nums)
      maxNum=Math.max(maxNum, num);

    int low=1, mid, high=maxNum;

    while(low <= high) {
      mid=low+(high-low)/2;

      int sum=countSum(nums, mid);

      if(sum < limit)
        high=mid-1;

      else low=mid+1;
    }
    return low;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number elemnts");
    int n=s.nextInt(), nums[]=new int[n], i;

    System.out.println("Enter "+n+" no. of elements");
    for(i=0; i<n; i++)
      nums[i]=s.nextInt();

    System.out.println("Enter the Threshold value");
    int limit=s.nextInt();

    System.out.println("The smallest divisor is "+smallestDiv(nums, limit));
    s.close();
  }
}