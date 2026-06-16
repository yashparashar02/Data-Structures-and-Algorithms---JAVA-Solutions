package Arrays.Hard;

import java.util.HashMap;
import java.util.Scanner;

public class subarrayXORSum {
  static int subarrCountXOR(int nums[], int k) {
    HashMap<Integer, Integer> map=new HashMap<>();
    map.put(0, 1);
    int xr=0, count=0;
    for(int each: nums) {
      xr^=each;

      int x = xr ^ k;

      if(map.containsKey(x))
        count+=map.get(x);

      map.put(xr, map.getOrDefault(xr, 0)+1);
    }
    return count;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), nums[]=new int[n], i;

    System.out.println("Enter "+n+" array elements");
    for(i=0; i<n; i++) 
      nums[i]=s.nextInt();

    System.out.println("Enter the XOR value");
    int k=s.nextInt();

    System.out.println("The number of subarrays whose XOR value is "+k+" are: "+subarrCountXOR(nums, k));
    s.close();
  }
}