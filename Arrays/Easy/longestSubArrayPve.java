package Arrays.Easy;

import java.util.Scanner;

public class longestSubArrayPve {
  static int longestSubArr(int arr[], long K) {
    int left=0, right, maxLen=0;
    long sum=0;

    for(right=0; right<arr.length; right++) {
      sum+=arr[right];

      while(sum > K) {
        sum-=arr[left];
        left++;
      }

      if(sum == K) 
        maxLen=Math.max(maxLen, right-left+1);
    }
    return maxLen;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array:");
    int n=s.nextInt(), arr[]=new int[n];

    System.out.println("Enter "+n+" array elements:");
    for(int i=0;i<n;i++)
      arr[i]=s.nextInt();

    System.out.println("Enter the Sum:");
    long K=s.nextLong();

    System.out.println("The Longest Subarray is: "+longestSubArr(arr, K));
    s.close();
  }
}