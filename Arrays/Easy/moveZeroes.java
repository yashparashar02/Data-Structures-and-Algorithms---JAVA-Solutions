package Arrays.Easy;

import java.util.Scanner;

public class moveZeroes {
  /*static void move0s(int nums[]) {
    int j=0, i, n=nums.length;
    for(i=0;i<n;i++) {
      if(nums[i] != 0) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        j++;
      }
    }
  }

public static void main(String[] args) {
  Scanner s = new Scanner(System.in);

  System.out.println("Enter size of array");
    int n=s.nextInt(), nums[]=new int[n];

    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++) 
      nums[i]=s.nextInt();

  move0s(nums);
  for(int num: nums)
    System.out.print(num+" ");
  s.close();
  }*/

  static int [] move0s(int nums[]) {
    int j=-1, i, n=nums.length, temp;

    for(i=0;i<n;i++) {
      if(nums[i] == 0) {
        j=i;
        break;
      }
    }

    if(j == -1)
      return nums;

    for(i=j+1;i<n;i++) {
      if(nums[i] != 0) {
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        j++;
      }
    }
    return nums;
  }
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Enter size of array");
      int n=s.nextInt(), nums[]=new int[n];

      System.out.println("Enter "+n+" array elements");
      for(int i=0;i<n;i++) 
        nums[i]=s.nextInt();

    move0s(nums);
    for(int num: nums)
      System.out.print(num+" ");
    s.close();
  }
}