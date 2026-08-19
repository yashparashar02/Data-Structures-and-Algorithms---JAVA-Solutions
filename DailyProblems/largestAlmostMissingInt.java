package DailyProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class largestAlmostMissingInt {
  static int largestInteger(int[] nums, int k) {
    int n=nums.length;

    if(k == 1) {
      Map<Integer, Integer> map=new HashMap<>();
      for(int num:nums) 
        map.put(num, map.getOrDefault(num, 0)+1);

      int maxVal=-1;
      for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if(entry.getValue() == 1)
          maxVal=Math.max(maxVal, entry.getKey());
      }
      return maxVal;
    }

    if(k == n) {
      int maxVal=-1;
      for(int num:nums)
        maxVal=Math.max(maxVal, num);

      return maxVal;
    }
    
    int first=nums[0], last=nums[n-1];
    boolean firstValid=true, lastValid=true;

    for(int i=1; i<n; i++) {
      if(nums[i] == first)
        firstValid=false;
    }

    for(int i=0; i<n-1; i++) {
      if(nums[i] == last)
        lastValid=false;
    }
    
    int maxVal=-1;
    if(firstValid)
      maxVal=Math.max(maxVal, first);

    if(lastValid)
      maxVal=Math.max(maxVal, last);

    return maxVal;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of the array");
    int n=s.nextInt();

    int nums[]=new int[n], i;
    System.out.println("Enter "+n+" values for the array ");
    for(i=0; i<n; i++)
      nums[i]=s.nextInt();

    System.out.println("Enter the value of K");
    int k=s.nextInt();

    System.out.println("The Largest Almost Missing Integer is: "+largestInteger(nums, k));
    s.close();
  }
}