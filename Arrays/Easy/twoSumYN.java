package Arrays.Easy;

import java.util.Arrays;
import java.util.Scanner;

public class twoSumYN {
  static String twoSum(int nums[], int target) {
    Arrays.sort(nums);
    int left=0, right=nums.length-1, sum;

    while (left < right) {
      sum = nums[left] + nums[right];

      if(sum == target)
        return "YES";

      else if(sum < target)
        left++;

      else right--;
    }
    return "NO";
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

    if(twoSum(nums, target) == "YES")
      System.out.println("Yes, the array contains the target elements");

    else System.out.println("No, the array does not contains the target elements");
    s.close();
  }
}