package BinarySearch.BSonAnswers;

import java.util.Scanner;

public class kthMissingPositive {
  static int missingKthNo(int arr[], int k) {
    int low=0, mid, high=arr.length-1;

    while(low <= high) {
      mid=low+(high-low)/2;

      int missing=arr[mid] - (mid+1);

      if(missing < k)
        low=mid+1;

      else high=mid-1;
    }
    return low+k;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of Positive Integers you want");
    int n=s.nextInt(), arr[]=new int[n], i;

    System.out.println("Enter "+n+" integers in sorted manner");
    for(i=0; i<n; i++)
      arr[i]=s.nextInt();

    System.out.println("Enter the positive index value you want to find");
    int k=s.nextInt();

    System.out.println("The missing positive integer is: "+missingKthNo(arr, k));
    s.close();
  }
}