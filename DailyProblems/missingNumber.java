package DailyProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class missingNumber {
  static List<Integer> missingNum(int nums[]) {
    if(nums == null || nums.length == 0)
      return new ArrayList<>();

    int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;

    Set<Integer> present=new HashSet<>();

    for(int num:nums) {
      min=Math.min(min, num);
      max=Math.max(max, num);

      present.add(num);
    }

    List<Integer> ans=new ArrayList<>();

    for(int i=min+1; i<max; i++) {
      if(!present.contains(i))
        ans.add(i);
    }
    return ans;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the length of the array: ");
    int n=s.nextInt();
    int nums[]=new int[n], i;

    System.out.println("Enter "+n+" numbers");
    for(i=0; i<n; i++)
      nums[i]=s.nextInt();

    System.out.println("THe Missing Numbers from the array are: "+missingNum(nums));
    s.close();
  }
}