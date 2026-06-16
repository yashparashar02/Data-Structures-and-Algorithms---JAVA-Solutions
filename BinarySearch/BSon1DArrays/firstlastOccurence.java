package BinarySearch.BSon1DArrays;

import java.util.Scanner;

public class firstlastOccurence {
  static int firstOccurence(int nums[], int x) {
    int low=0, mid, high=nums.length-1, first=-1;

    while(low <= high) {
      mid=low+(high-low)/2;

      if(nums[mid] == x) {
        first=mid;
        high=mid-1;
      }

      else if(nums[mid] < x)
        low=mid+1;

      else high=mid-1;
    }
    return first;
  }
  static int lastOccurence(int nums[], int x) {
    int low=0, mid, high=nums.length, last=-1;

    while(low <= high) {
      mid=low+(high-low)/2;

      if(nums[mid] == x) {
        last=mid;
        low=mid+1;
      }

      else if(nums[mid] < x)
        low=mid+1;

      else high=mid-1;
    }
    return last;
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

    System.out.println("The first and last occurence are: {"+firstOccurence(nums, x)+", "+lastOccurence(nums, x)+"}");
    s.close();
  }
}