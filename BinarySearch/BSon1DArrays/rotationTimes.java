package BinarySearch.BSon1DArrays;

import java.util.Scanner;

public class rotationTimes {
  static int rotation(int nums[]) {
    int low=0, mid, high=nums.length-1;
    while(low < high) {
      mid=low+(high-low)/2;

      if(nums[mid] > nums[high])
        low=mid+1;

      else high=mid;
    }
    return low;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array");
    int n=s.nextInt(), i, nums[]=new int[n];

    System.out.println("Enter "+n+" array elemnts");
    for(i=0; i<n; i++)
      nums[i]=s.nextInt();

    System.out.println("The array rotates at index "+rotation(nums));
    s.close();
  }
}