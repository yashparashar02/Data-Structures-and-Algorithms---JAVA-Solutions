package Arrays.Easy;

import java.util.Scanner;

public class maximumOnes {
  static int maxOnes(int nums[]) {
    int count=0, maxCount=0;

    for(int each:nums) {
      if(each == 1) {
        count++;
        maxCount = Math.max(maxCount, count);
      }
      else
        count = 0;
    }
    return maxCount;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array:");
    int n=s.nextInt(), nums[]=new int[n];

    System.out.println("Enter "+n+" array elements:");
    for(int i=0;i<n;i++)
      nums[i]=s.nextInt();

    System.out.print("The maximum Ones in the array are: "+maxOnes(nums));
    s.close();
  }
}