package DailyProblems;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class missingIntSequentialSum {
  static int missInt(int nums[]) {
    int sum=nums[0], i;

    for(i=1; i<nums.length; i++) {
      if(nums[i] == nums[i-1]+1)
        sum+=nums[i];

      else break;
    }

    Set<Integer> set=new HashSet<>();
    for(int num:nums)
      set.add(num);

    int current=sum;
    while(set.contains(current))
      current++;

    return current;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of nums array");
    int n=s.nextInt();

    System.out.println("Enter "+n+" valus of nums");
    int nums[]=new int[n], i;
    for(i=0; i<n; i++)
      nums[i]=s.nextInt();

    System.out.println("The Smallest Missing Integer Greater than Sequential Prefix Sum is: "+missInt(nums));
    s.close();
  }
}