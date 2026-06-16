package Arrays.Medium;

import java.util.*;

public class longestSubarray {
  static int longestSubarr(int nums[], int K) {
    HashMap<Integer, Integer> map=new HashMap<>();
    int sum=0, maxLen=0, i;

    for(i=0; i<nums.length; i++) {
      sum+=nums[i];

      if(sum == K)
        maxLen=i+1;

      int rem=sum-K;
      if(map.containsKey(rem)) {
        int len=i-map.get(rem);
        maxLen=Math.max(maxLen, len);
      }

      if(!map.containsKey(sum))
        map.put(sum,i);
    }
    return maxLen;
  }
  public static void main(String arr[]) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array:");
    int n=s.nextInt(), nums[]=new int[n];

    System.out.println("Enter "+n+" array elements:");
    for(int i=0;i<n;i++)
      nums[i]=s.nextInt();

    System.out.println("Enter the Sum:");
    int K=s.nextInt();

    System.out.println("The Longest Subarray is: "+longestSubarr(nums, K));
    s.close();
  }
}