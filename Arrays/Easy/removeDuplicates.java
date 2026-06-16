package Arrays.Easy;

import java.util.Scanner;

public class removeDuplicates {
  static int remvDupli(int nums[]) {
    int i=0, n=nums.length, j;

    if(n==0)
      return 0;

    for(j=1;j<n;j++) {
      if(nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i+1;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    
    System.out.println("Enter size of array");
    int n=s.nextInt(), nums[]=new int[n];

    System.out.println("Enter "+n+" array elements in sorted order");
    for(int i=0;i<n;i++) 
      nums[i]=s.nextInt();

    System.out.println(remvDupli(nums));
    s.close();
  }
}