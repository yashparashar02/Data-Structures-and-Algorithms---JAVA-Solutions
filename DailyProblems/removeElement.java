package DailyProblems;

import java.util.Scanner;

public class removeElement {
  static int remove(int nums[], int val) {
    int k=0, i;

    for(i=0; i<nums.length; i++) {
      if(nums[i] != val) {
        nums[k]=nums[i];
        k++;
      }
    }
    return k;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of nums array");
    int n=s.nextInt();
    
    System.out.println("Enter "+n+" numbers");
    int nums[]=new int[n], i;
    for(i=0; i<n; i++)
      nums[i]=s.nextInt();

    System.out.println("Enter the value of 'val'");
    int val=s.nextInt();

    System.out.println("The number of 'k' values are: "+remove(nums, val));
    s.close();
  }
}