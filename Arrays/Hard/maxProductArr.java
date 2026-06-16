package Arrays.Hard;

import java.util.Scanner;

public class maxProductArr {
  static int maxProduct(int nums[]) {
    int maxProd=Integer.MIN_VALUE, prefix=1, suffix=1, i;

    for(i=0; i<nums.length; i++) {
      if(prefix == 0)
        prefix=1;

      if(suffix == 0)
        suffix=1;

      prefix*=nums[i];

      suffix*=nums[nums.length-i-1];

      maxProd=Math.max(maxProd, Math.max(prefix, suffix));
    }
    return maxProd;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner((System.in));

    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), nums[]=new int[n], i;

    System.out.println("Enter "+n+" array elements");
    for(i=0; i<n; i++) 
      nums[i]=s.nextInt();

    System.out.println("The Maximum Product is: "+maxProduct(nums));
    s.close();
  }
}