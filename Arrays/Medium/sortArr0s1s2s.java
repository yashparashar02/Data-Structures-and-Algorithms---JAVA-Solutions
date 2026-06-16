package Arrays.Medium;

import java.util.Scanner;

public class sortArr0s1s2s {
  static void sortArr(int nums[]) {
    int low=0, mid=0, high=nums.length-1, i;

    while(mid <= high) {
      if(nums[mid] == 0) {
        int temp=nums[low];
        nums[low]=nums[mid];
        nums[mid]=temp;

        low++;
        mid++;
      }

      else if(nums[mid] ==1) 
        mid++;

      else {
        int temp=nums[mid];
        nums[mid]=nums[high];
        nums[high]=temp;

        high--;
      }
    }
    System.out.println("The sorted array is: ");
    for(i=0; i<nums.length; i++) 
      System.out.print(nums[i]+" ");
  }
  public static void main(String arr[]) {
    Scanner s=new Scanner(System.in);
    
    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), nums[]=new int[n], i;

    System.out.println("Enter "+n+" array elements(0s, 1s, 2s)");
    for(i=0; i<n; i++) 
      nums[i]=s.nextInt();

    sortArr(nums);
    s.close();
  }
}