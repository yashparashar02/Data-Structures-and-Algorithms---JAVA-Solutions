package BinarySearch.BSon1DArrays;

import java.util.Scanner;

public class rotatedArray1 {
  static int searchRotated(int nums[], int x) {
    int low=0, mid, high=nums.length-1;

    while(low <= high) {
      mid=low+(high-low)/2;

      if(nums[mid] == x)
        return mid;

      if(nums[low] <= nums[mid]) {
        if(nums[low] <= x && x <= nums[mid])
          high=mid-1;
        
        else low=mid+1;
      }
      else {
        if(nums[mid] <= x && x <= nums[high])
          low=mid+1;
        
        else high=mid-1;
      }
    }
    return -1;
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

    System.out.println("The index of "+x+" is: "+searchRotated(nums, x));
    s.close();
  }
}