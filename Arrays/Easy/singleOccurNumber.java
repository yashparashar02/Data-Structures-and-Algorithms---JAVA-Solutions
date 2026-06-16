package Arrays.Easy;

import java.util.Scanner;

public class singleOccurNumber {
  static int singleNum(int nums[]) {
    int xor=0;

    for(int each:nums) 
      xor^=each;

    return xor;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array:");
    int n=s.nextInt(), nums[]=new int[n];

    System.out.println("Enter "+n+" array elements:");
    for(int i=0;i<n;i++)
      nums[i]=s.nextInt();

    System.out.print("The Number with single occurence in the array is: "+singleNum(nums));
    s.close();
  }
}