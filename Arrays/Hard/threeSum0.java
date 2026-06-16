package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class threeSum0 {
  static List<List<Integer>> threeSum(int nums[]) {
    List<List<Integer>> result=new ArrayList<>();
    Arrays.sort(nums);
    for(int i=0; i<nums.length; i++) {
      if(i > 0 && nums[i] == nums[i-1]) 
        continue;

      int j=i+1, k=nums.length-1;
      while(j < k) {
        int sum = nums[i] + nums[j] + nums[k];

        if(sum < 0) 
          j++;

        else if(sum > 0)
          k--;

        else {
          result.add(Arrays.asList(nums[i], nums[j], nums[k]));
          j++;
          k--;

          while(j < k && nums[j] == nums[j-1])
            j++;

          while(j < k && nums[k] == nums[k+1])
            k--;
        }
      }
    }
    return result;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), nums[]=new int[n], i;

    System.out.println("Enter "+n+" array elements");
    for(i=0; i<n; i++) 
      nums[i]=s.nextInt();

    System.out.println("The triplets are: "+threeSum(nums));
    s.close();
  }
}