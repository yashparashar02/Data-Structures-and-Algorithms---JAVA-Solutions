package Arrays.Easy;

import java.util.Scanner;

public class findMissingNum {
  static int findMissing(int nums[], int n) {
    int xor1=0, xor2=0;

    for(int i=1;i<=n;i++)
      xor1^=i;

    for(int each:nums)
      xor2^=each;

    return xor1 ^ xor2;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array:");
    int n=s.nextInt(), nums[]=new int[n-1];

    System.out.println("Enter "+(n-1)+" array elements:");
    for(int i=0;i<n-1;i++)
      nums[i]=s.nextInt();

    System.out.print("Missing number: "+findMissing(nums,n));
    s.close();
  }
}