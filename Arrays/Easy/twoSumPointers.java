package Arrays.Easy;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Scanner;

public class twoSumPointers {
  static int[] twoSum(int nums[], int target) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for(int i=0; i<nums.length; i++) {
      int needed = target-nums[i];

      if(map.containsKey(needed))
        return new int[]{map.get(needed), i};

      map.put(nums[i], i);
    }
    return new int[]{-1, -1};
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array:");
    int n=s.nextInt(), nums[]=new int[n];

    System.out.println("Enter "+n+" array elements:");
    for(int i=0;i<n;i++)
      nums[i]=s.nextInt();

    System.out.println("Enter target");
    int target=s.nextInt();

    System.out.println("The position of target elements are: "+Arrays.toString(twoSum(nums, target)));
    s.close();
  }
}