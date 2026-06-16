package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class majorityElement2 {
  static List<Integer> majorityElem2(int nums[]) {
    int cnt1=0, cnt2=0, el1=Integer.MIN_VALUE, el2=Integer.MIN_VALUE, i, n=nums.length;
    for(i=0; i<n; i++) {
      if(cnt1 == 0 && nums[i] != el2) {
        el1 = nums[i];
        cnt1=1;
      }

      else if(cnt2 == 0 && nums[i] != el1) {
        el2 = nums[i];
        cnt2=1;
      }

      else if(el1 == nums[i]) 
        cnt1++;

      else if(el2 == nums[i]) 
        cnt2++;

      else {
        cnt1--;
        cnt2--;
      }
    }

    cnt1=0; 
    cnt2=0;
    for(i=0; i<n; i++) {
      if(el1 == nums[i])
        cnt1++;

      else if(el2 == nums[i])
        cnt2++;
    }

    List<Integer> result=new ArrayList<>();
    
    if(cnt1 > n/3)
      result.add(el1);
    if(cnt2 > n/3)
      result.add(el2);

    return result;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), nums[]=new int[n], i;

    System.out.println("Enter "+n+" array elements");
    for(i=0; i<n; i++) 
      nums[i]=s.nextInt();

    System.out.println("The majority element from array is: "+majorityElem2(nums));
    s.close();
  }
}