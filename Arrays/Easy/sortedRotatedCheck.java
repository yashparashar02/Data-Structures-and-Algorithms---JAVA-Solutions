package Arrays.Easy;

import java.util.Scanner;

public class sortedRotatedCheck {
  static boolean check(int nums[]) {
    int n=nums.length,count=0,i;
    for(i=0;i<n;i++){
      if(nums[i] > nums[(i+1) % n])
        count++;
    }
    return count<=1;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    
    System.out.println("Enter size of array");
    int n=s.nextInt(), nums[]=new int[n];

    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++) 
      nums[i]=s.nextInt();

    System.out.println(check(nums));
    s.close();
  }
}