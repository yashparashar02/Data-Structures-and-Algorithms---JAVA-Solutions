package BinarySearch.BSonAnswers;

import java.util.Scanner;

public class medianSortedArr {
  static double median(int nums1[], int nums2[]) {
    int n1=nums1.length, n2=nums2.length;

    if(n1 > n2)
      return median(nums2, nums1);

    int low=0, mid1, mid2, high=n1;

    while (low <= high) {
      mid1=low+(high-low)/2;
      mid2=(n1+n2+1)/2 - mid1;

      int l1=(mid1 == 0) ? Integer.MIN_VALUE:nums1[mid1-1];
      int l2=(mid2 == 0) ? Integer.MIN_VALUE:nums2[mid2-1];

      int r1=(mid1 == n1) ? Integer.MAX_VALUE:nums1[mid1];
      int r2=(mid2 == n2) ? Integer.MAX_VALUE:nums2[mid2];

      if(l1 <= r2 && l2 <= r1) {
        if((n1+n2)%2 == 0)
          return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
        
        return Math.max(l1, l2);
      }
      else if(l1 > r2)
        high=mid1-1;

      else low=mid1+1;
    }
    return 0;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of elements for Array1");
    int m=s.nextInt(), nums1[]=new int[m], i;
    System.out.println("Enter the number of elements for Array2");
    int n=s.nextInt(), nums2[]=new int[n];

    System.out.println("Enter "+m+" elements for Array1");
    for(i=0; i<m; i++)
      nums1[i]=s.nextInt();

    System.out.println("Enter "+n+" elements for Array2");
    for(i=0; i<m; i++)
      nums2[i]=s.nextInt();

    System.out.println("\nThe median of both the sorted arrays are "+median(nums1, nums2));
    s.close();
  }
}