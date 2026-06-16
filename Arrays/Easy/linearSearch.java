package Arrays.Easy;

import java.util.Scanner;

public class linearSearch {
  static int linearSearchNum(int nums[], int num) {
    for(int i=0; i<nums.length; i++) {
      if(nums[i] == num)
        return i;
    }
    return -1;
  }
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Enter size of array");
    int n=s.nextInt(), nums[]=new int[n];

    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++) 
      nums[i]=s.nextInt();

    System.out.println("Enter the number to be found");
    int num=s.nextInt();

    System.out.println(linearSearchNum(nums, num));
    s.close();
  }
}