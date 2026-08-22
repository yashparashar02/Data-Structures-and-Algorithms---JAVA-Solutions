package DailyProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class distributeElemArrrays {
  static int[] resultArray(int[] nums) {
    List<Integer> arr1=new ArrayList<>(), arr2=new ArrayList<>();

    arr1.add(nums[0]);
    arr2.add(nums[1]);

    for(int i=2; i<nums.length; i++) {
      int last1=arr1.get(arr1.size()-1), last2=arr2.get(arr2.size()-1);

      if(last1 > last2) 
        arr1.add(nums[i]);
      else
        arr2.add(nums[i]);
    }
    int result[]=new int[nums.length], idx=0;

    for(int num : arr1)
      result[idx++]=num;

    for(int num : arr2)
      result[idx++]=num;

    return result;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of the array");
    int n=s.nextInt();

    int nums[]=new int[n], i;
    System.out.println("Enter "+n+" valus of array");
    for(i=0; i<n; i++)
      nums[i]=s.nextInt();

    int result[]=resultArray(nums);
    System.out.print("Result array: ");
    for(int num : result)
      System.out.print(num+" ");
    System.out.println();
    s.close();
  }
}