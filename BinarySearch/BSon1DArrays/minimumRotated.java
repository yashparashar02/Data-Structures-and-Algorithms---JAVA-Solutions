package BinarySearch.BSon1DArrays;

import java.util.Scanner;

public class minimumRotated {
  static int minRotated(int nums[]) {
    int low=0, mid, high=nums.length-1, ans=Integer.MIN_VALUE;

    while(low <= high) {
      if(nums[low] <= nums[high]) {
        ans=Math.min(ans, nums[low]);
        break;
      }

      mid=low+(high-low)/2;

      if(nums[low] <= nums[mid]) {
        ans=Math.min(ans, nums[low]);
        low=mid+1;
      }

      else {
        ans=Math.min(ans, nums[mid]);
        high=mid-1;
      }
    }
    return ans;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array");
    int n=s.nextInt(), i, nums[]=new int[n];

    System.out.println("Enter "+n+" array elemnts");
    for(i=0; i<n; i++)
      nums[i]=s.nextInt();

    System.out.println("The Minimum element is: "+minRotated(nums));
    s.close();
  }
}