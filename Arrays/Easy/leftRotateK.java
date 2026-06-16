package Arrays.Easy;

import java.util.Scanner;

public class leftRotateK {
  /*static void leftRotK(int nums[], int k) {
    int n=nums.length,i;
    k%=n;
    int temp[]=new int[k];

    for(i=0;i<k;i++) 
      temp[i]=nums[i];

    for(i=k;i<n;i++) 
      nums[i-k]=nums[i];

    for(i=n-k;i<n;i++)
      nums[i] = temp[i-(n-k)];
  }*/

  static void leftRotK(int nums[], int k) {
    int n=nums.length;
    k%=n;

    reverse(nums,0,k-1);
    reverse(nums,k,n-1);
    reverse(nums,0,n-1);
  }

  static void reverse(int nums[], int start, int end) {
    while(start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++; end--;
    }
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter size of array");
    int n=s.nextInt(), nums[]=new int[n];

    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++) 
      nums[i]=s.nextInt();
    
    System.out.println("Enter the number of rotations");
    int k=s.nextInt();

    leftRotK(nums, k);
    for(int i:nums)
      System.out.print(i+" ");
    s.close();
  }
}