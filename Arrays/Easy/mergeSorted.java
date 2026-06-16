package Arrays.Easy;

import java.util.Scanner;

public class mergeSorted {
  static int[] merge2Sort(int arr1[], int arr2[], int m, int n) {
    int i=0, j=0, k=0, merge[] = new int[m+n];

    while(i < m && j < n) {
      
      if(arr1[i] <= arr2[j]) 
        merge[k++] = arr1[i++];

      else
        merge[k++] = arr2[j++];
    }

    while(i < m) 
      merge[k++] = arr1[i++];

    while(j < n)
      merge[k++] = arr2[j++];

    return merge;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter size of array 1");
    int m=s.nextInt(), arr1[]=new int[m];

    System.out.println("Enter size of array 2");
    int n=s.nextInt(), arr2[]=new int[n];

    System.out.println("Enter "+m+" array 1 elements");
    for(int i=0;i<m;i++) 
      arr1[i]=s.nextInt();

    System.out.println("Enter "+n+" array 2 elements");
    for(int i=0;i<n;i++) 
      arr2[i]=s.nextInt();

    int merge[] = merge2Sort(arr1, arr2, m, n);
    System.out.println("The merge result of both arrrays are:");
    for(int i:merge)
      System.out.print(i+" ");
    s.close();
  }
}