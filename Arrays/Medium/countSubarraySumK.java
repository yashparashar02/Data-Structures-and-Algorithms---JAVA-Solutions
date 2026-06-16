package Arrays.Medium;

import java.util.HashMap;
import java.util.Scanner;

public class countSubarraySumK {
  static int countSubArrSumK(int nums[], int k) {
    HashMap<Integer, Integer> map=new HashMap<>();
    map.put(0,1);

    int count=0, sum=0;
    for(int each: nums) {
      sum+=each;
      int rem = sum-k;

      if(map.containsKey(rem)) 
        count+=map.get(rem);

      map.put(sum, map.getOrDefault(sum, 0)+1);
    }
    return count;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array:");
    int n=s.nextInt(), nums[]=new int[n];

    System.out.println("Enter "+n+" array elements:");
    for(int i=0;i<n;i++)
      nums[i]=s.nextInt();

    System.out.println("Enter the Sum:");
    int k=s.nextInt();

    System.out.println("The Longest Subarray is: "+countSubArrSumK(nums, k));
    s.close();
  }
}