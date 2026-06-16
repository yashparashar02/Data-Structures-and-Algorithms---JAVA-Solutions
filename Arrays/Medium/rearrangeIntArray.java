package Arrays.Medium;

import java.util.Scanner;
import java.util.Arrays;

public class rearrangeIntArray {
  static int[] rearrangeArr(int nums[]) {
    int ansArr[]=new int[nums.length], posIndex=0, negIndex=1;

    for(int each: nums) {
      if(each > 0) {
        ansArr[posIndex] = each;
        posIndex+=2;
      }
      else {
        ansArr[negIndex] = each;
        negIndex+=2;
      }
    }
    return ansArr;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), nums[]=new int[n], i;

    System.out.println("Enter "+n+" array integer elements");
    for(i=0; i<n; i++) 
      nums[i]=s.nextInt();

    rearrangeArr(nums);
    System.out.println("The rearranged array is: "+Arrays.toString(nums));
    /*for(i=0; i<ansArr.length; i++) 
      System.out.print(ansArr[i]+" ");*/
    s.close();
  }
}