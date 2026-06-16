package Arrays.Hard;

import java.util.Scanner;

public class missingAndRepeating {
  static int[] missingRepeating(int nums[]) {
    long n=nums.length, s=0, s2=0, sN=(long) n*(n+1)/2, sN2=(long) n*(n+1)*(2*n+1)/6;

    for(int num:nums) {
      s+=num;
      s2+=(long) num*num;
    }

    long val1 = sN - s, val2 = sN2 - s2;

    long sumXY = val2 / val1;

    long missing = (sumXY + val1)/2;

    long repeating = missing - val1;

    return new int[] {(int) missing, (int) repeating};
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), nums[]=new int[n], i;

    System.out.println("Enter "+n+" array elements");
    for(i=0; i<n; i++) 
      nums[i]=s.nextInt();

    int ans[]=missingRepeating(nums);
    System.out.println("Repeating = "+ans[1]);
    System.out.println("Missing = "+ans[0]);
    s.close();
  }
}