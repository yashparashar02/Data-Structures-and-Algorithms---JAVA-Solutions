package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class fourSumTarget {
  static List<List<Integer>> fourSum(int nums[], int target) {
    Arrays.sort(nums);
    List<List<Integer>> result=new ArrayList<>();
    int n=nums.length, i, j, k, l;
    for(i=0; i<n; i++) {
      if(i > 0 && nums[i] == nums[i-1])
        continue;

      for(j=i+1; j<n; j++) {
        if(j > i+1 && nums[j] == nums[j-1])
          continue;
        
        k=j+1; l=n-1;
        while(k < l) {
          long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

          if(sum < target) 
            k++;

          else if(sum > target)
            l--;

          else {
            result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
            k++;
            l--;

            while(k < l && nums[k] == nums[k-1])
              k++;

            while(k < l && nums[l] == nums[l+1])
              l--;
          }
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

    System.out.println("Enter the target value");
    int target = s.nextInt();

    System.out.println("The quadruplets are: "+fourSum(nums, target));
    s.close();
  }
}