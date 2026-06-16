package Arrays.Easy;

import java.util.Scanner;

public class majorityElement {
  static int majorityElem1(int nums[]) {
    int count=0, elem=0, i;

    for(i=0; i<nums.length; i++) {
      if(count == 0) {
        count=1;
        elem=nums[i];
      }

      else if(nums[i] == elem)
        count++;

      else count--;
    }

    int freq=0;
    for(i=0; i<nums.length; i++) {
      if(nums[i] == elem) 
        freq++;
    }
    if(freq > nums.length/2)
      return elem;

    return -1;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), nums[]=new int[n], i;

    System.out.println("Enter "+n+" array elements");
    for(i=0; i<n; i++) 
      nums[i]=s.nextInt();

    System.out.println("The majority element from array is: "+majorityElem1(nums));
    s.close();
  }
}