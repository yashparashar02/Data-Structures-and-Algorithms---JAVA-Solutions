package Arrays.Medium;

import java.util.Arrays;
import java.util.Scanner;

public class nextPermutationArr {
  static void nextPermutation(int nums[]) {
    int n=nums.length, index=-1, i;

    for(i=n-2; i>=0; i--) {
      if(nums[i] < nums[i+1]) {
        index=i;
        break;
      }
    }

    if(index == -1) {
      reverse(nums, 0, n-1);
      return;
    }

    for(i=n-1; i>index; i--) {
      if(nums[i] > nums[index]) {

        int temp=nums[i];
        nums[i]=nums[index];
        nums[index]=temp;

        break;
      }
    }

    reverse(nums, index+1, n-1);
  }

  static void reverse(int nums[], int start, int end) {
    while(start < end) {

      int temp=nums[start];
      nums[start]=nums[end];
      nums[end]=temp;

      start++;
      end--;
    }
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), nums[]=new int[n], i;

    System.out.println("Enter "+n+" array elements");
    for(i=0; i<n; i++) 
      nums[i]=s.nextInt();

    nextPermutation(nums);
    System.out.println("The next permutation is:"+Arrays.toString(nums));
    s.close();
  }
}
