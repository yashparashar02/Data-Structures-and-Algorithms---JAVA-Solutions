package BinarySearch.BSon1DArrays;

import java.util.Scanner;

public class binarySearch {
  static int searchBinary(int nums[], int target) {
    int low=0, mid, high=nums.length-1;

    while(low <= high) {
      mid=(low+high)/2;

      if(nums[mid] == target)
        return mid;

      else if(nums[mid] < target)
        low=mid+1;

      else high=mid-1;
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

    System.out.println("Enter the target to be found");
    int target=s.nextInt();

    if(searchBinary(nums, target) >= 0)
      System.out.println("The "+target+" element is found at "+searchBinary(nums, target));

    else 
      System.out.println(target+" Element was not found");

    s.close();
  }
}