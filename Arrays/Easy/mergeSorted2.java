package Arrays.Easy;

import java.util.Scanner;

public class mergeSorted2 {
  static void merge2Sort(int nums1[], int nums2[], int m, int n) {
    int i=m-1, j=n-1, k=m+n-1;

    while(i >= 0 && j >= 0) {
      if(nums1[i] > nums2[j])
        nums1[k--] = nums1[i--];
      else
        nums1[k--] = nums2[j--];
    }

    while(j >= 0) 
      nums1[k--] = nums2[j--];
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter size of array 1");
    int m=s.nextInt();

    System.out.println("Enter size of array 2");
    int n=s.nextInt();

    int arr1[]=new int[m+n], arr2[]=new int[n];

    System.out.println("Enter "+m+" array 1 elements");
    for(int i=0;i<m;i++) 
      arr1[i]=s.nextInt();

    System.out.println("Enter "+n+" array 2 elements");
    for(int i=0;i<n;i++) 
      arr2[i]=s.nextInt();

    merge2Sort(arr1, arr2, m, n);
    System.out.println("The merge result of both arrrays are:");
    for(int i=0;i<m+n;i++)
      System.out.print(arr1[i]+" ");
    s.close();
  }
}