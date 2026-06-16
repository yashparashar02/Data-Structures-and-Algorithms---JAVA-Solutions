package Hashing;

import java.util.Arrays;
import java.util.Scanner;

public class maxFreq {
  public static int maxFrequency(int nums[], int k) {
    Arrays.sort(nums);

    int left=0, sum=0, maxFreq=0;

    for(int right=0;right<nums.length;right++) {
      sum+=nums[right];

      while((long)nums[right]*(right-left+1)>sum+k) {
        sum-=nums[left];
        left++;
      }
      maxFreq=Math.max(maxFreq, right-left+1);
    }
    return maxFreq;
  }

  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the array size");
    int n=s.nextInt();
    int nums[]=new int[n];
    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++)
      nums[i]=s.nextInt();

    System.out.println("Enter the value of K");
    int k=s.nextInt();

    System.out.println("The maximum frequency is: "+maxFrequency(nums,k));
    s.close();
  }
}