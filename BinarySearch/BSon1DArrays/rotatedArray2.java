package BinarySearch.BSon1DArrays;

import java.util.Scanner;

public class rotatedArray2 {
  static boolean searchRotated(int nums[], int x) {
    int low=0, mid, high=nums.length-1;

    while(low <= high) {
      mid=low+(high-low)/2;

      if(nums[mid] == x)
        return true;

      if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
        low++;
        high--;
        continue;
      }

      if(nums[low] <= nums[mid]) {
        if(nums[low] <= x && x <= nums[mid])
          high=mid-1;

        else
          low=mid+1;
      }

      else {
        if(nums[mid] <= x && x <= nums[high])
          low=mid+1;

        else
          high=mid-1;
      }
    }
    return false;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array");
    int n=s.nextInt(), i, nums[]=new int[n];

    System.out.println("Enter "+n+" array elemnts");
    for(i=0; i<n; i++)
      nums[i]=s.nextInt();

    System.out.println("Enter the target to be found in array");
    int x=s.nextInt();

    if(searchRotated(nums, x) == true)
      System.out.println(searchRotated(nums, x)+", "+x+" exists in array");

    else
      System.out.println(searchRotated(nums, x)+", "+x+" does not exist in array");
    s.close();
  }
}