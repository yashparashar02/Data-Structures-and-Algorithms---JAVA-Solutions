package BinarySearch.BSonAnswers;

import java.util.Scanner;

public class kthElemSortedArr {
  static int kthElem(int nums1[], int nums2[], int k) {
    int m=nums1.length, n=nums2.length;
    if(m > n)
      return kthElem(nums2, nums1, k);

    int low=Math.max(0, k-n), mid1, mid2, high=Math.min(k, m);
    while(low <= high) {
      mid1=low+(high-low)/2;
      mid2=k-mid1;

      int l1=(mid1 == 0) ? Integer.MIN_VALUE:nums1[mid1-1];
      int l2=(mid2 == 0) ? Integer.MIN_VALUE:nums2[mid2-1];

      int r1=(mid1 == m) ? Integer.MAX_VALUE:nums1[mid1];
      int r2=(mid2 == n) ? Integer.MAX_VALUE:nums2[mid2];

      if(l1 <= r2 && l2 <= r1)
        return Math.max(l1, l2);

      else if(l1 > r2)
        high=mid1-1;

      else low= mid1+1;
    }
    return -1;
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
    for(i=0; i<n; i++)
      nums2[i]=s.nextInt();

    System.out.println("Enter the value of Kth element you want to find");
    int k=s.nextInt();

    System.out.println("The kth element is "+kthElem(nums1, nums2, k));
    s.close();
  }
}
