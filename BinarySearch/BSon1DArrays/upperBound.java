package BinarySearch.BSon1DArrays;

import java.util.Scanner;

public class upperBound {
  static int upperBnd(int nums[], int x) {
    int low=0, mid, high=nums.length-1, ans=nums.length;

    while(low <= high) {
      mid=low+(high-low)/2;

      if(nums[mid] > x) {
        ans=mid;
        high=mid-1;
      }

      else low=mid+1;
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

    System.out.println("Enter the target to be found");
    int x=s.nextInt();

    System.out.println("The Upper Bound for "+x+" is "+upperBnd(nums, x));
    s.close();
  }
}