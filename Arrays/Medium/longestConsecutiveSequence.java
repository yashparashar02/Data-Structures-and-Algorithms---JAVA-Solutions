package Arrays.Medium;

import java.util.HashSet;
import java.util.Scanner;

public class longestConsecutiveSequence {
  static int longestSequence(int nums[]) {
    HashSet<Integer> set=new HashSet<>();
    for(int i:nums)
      set.add(i);

    int longest=0;
    for(int num:set) {
      if(!set.contains(num-1)) {
        int current=num, count=1;
        while(set.contains(current+1)){
          current++; count++;
        }
        longest=Math.max(longest, count);
      }
    }
    return longest;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), nums[]=new int[n], i;

    System.out.println("Enter "+n+" array elements");
    for(i=0; i<n; i++) 
      nums[i]=s.nextInt();

    System.out.println("The longest consecutive sequence is: "+longestSequence(nums));
    s.close();
  }
}