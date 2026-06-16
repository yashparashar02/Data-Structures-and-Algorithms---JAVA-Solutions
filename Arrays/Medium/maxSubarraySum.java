package Arrays.Medium;

import java.util.Scanner;

public class maxSubarraySum {
  static int maxSubarrSum(int nums[]) {
    int sum=0, maxSum=Integer.MIN_VALUE;

    for(int i: nums) {
      sum+=i;

      maxSum=Math.max(maxSum, sum);
      
      if(sum < 0) 
        sum=0;
    }
    return maxSum;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), nums[]=new int[n], i;

    System.out.println("Enter "+n+" array integer elements");
    for(i=0; i<n; i++) 
      nums[i]=s.nextInt();

    System.out.println("The Maximum Subarray Sum is: "+maxSubarrSum(nums));
    s.close();
  }
}