package DailyProblems;

import java.util.HashSet;
import java.util.Scanner;

public class smallestMissingMultipleK {
  static int missingMultiple(int nums[], int k) {
    HashSet<Integer> set=new HashSet<>();

    for(int num:nums) 
      set.add(num);

    int multiple=k;

    while(set.contains(multiple))
      multiple+=k;

    return multiple;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range for array");
    int n=s.nextInt();

    System.out.println("Enter "+n+" values for the array");
    int nums[]=new int[n], i;
    for(i=0; i<n; i++)
      nums[i]=s.nextInt();

    System.out.println("Enter the value of K");
    int k=s.nextInt();

    System.out.println("The Smallest Missing MUltiple of "+k+" from the array is: "+missingMultiple(nums, k));
    s.close();
  }
}