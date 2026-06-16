package BinarySearch.BSon1DArrays;

import java.util.Scanner;

public class countOccurences {
  static int lowerBound(int nums[], int n, int x) {
    int low=0, mid, high=n-1, lb=n;

    while(low <= high) {
      mid=low+(high-low)/2;

      if(nums[mid] >= x) {
        lb=mid;
        high=mid-1;
      }
      else low=mid+1;
    }
    return lb;
  }
  static int upperBound(int nums[], int n, int x) {
    int low=0, mid, high=n-1, ub=n;

    while(low <= high) {
      mid=low+(high-low)/2;

      if(nums[mid] > x) {
        ub=mid;
        high=mid-1;
      }
      else low=mid+1;
    }
    return ub;
  }
  static int findOccurence(int nums[], int n, int x) {
    int lb=lowerBound(nums, n, x);
    
    if(lb == n && nums[lb] != x) 
      return 0;

    int ub=upperBound(nums, n, x);

    return ub-lb;
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

    System.out.println("The total occurences of "+x+" in the array are: "+findOccurence(nums, n, x));
    s.close();
  }
}