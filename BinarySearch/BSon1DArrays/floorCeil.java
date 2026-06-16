package BinarySearch.BSon1DArrays;

import java.util.Scanner;

public class floorCeil {
  static int findFloor(int nums[], int target) {
    int low=0, mid, high=nums.length-1, floor=-1;

    while(low <= high) {
      mid=low+(high-low)/2;

      if(nums[mid] <= target) {
        floor=nums[mid];
        low=mid+1;
      }

      else high=mid-1;
    }
    return floor;
  }
  static int findCeil(int nums[], int target) {
    int low=0, mid, high=nums.length-1, ceil=-1;
    
    while(low <= high) {
      mid=low+(high-low)/2;

      if(nums[mid] >= target) {
        ceil=nums[mid];
        high=mid-1;
      }
      else low=mid+1;
    }
    return ceil;
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

    if(findFloor(nums, target) >= 0 && findCeil(nums, target) >= 0)
      System.out.println("The floor of "+target+" element is found at "+findFloor(nums, target)+"\n The Ceil of "+target+" is found at "+findCeil(nums, target));

    else 
      System.out.println("The floor of "+target+" element is found at "+findFloor(nums, target)+"\n The Ceil of "+target+" is found at "+findCeil(nums, target));

    s.close();
  }
}