package DailyProblems;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class kMostFrequent {
  static int[] KmostFrequent(int nums[], int k) {
    HashMap<Integer, Integer> map=new HashMap<>();

    for(int num: nums)
      map.put(num, map.getOrDefault(num, 0)+1);

    PriorityQueue<Integer> pQueue=new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

    for(int num:map.keySet()) {
      pQueue.offer(num);

      if(pQueue.size() > k)
        pQueue.poll();
    }

    int result[]=new int[k], i;
    for(i=k-1; i>=0; i--)
      result[i]=pQueue.poll();

    return result;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the size of nums array");
    int n=s.nextInt();

    int nums[]=new int[n], i;
    System.out.println("Enter "+n+" number of elements");
    for(i=0; i<n; i++)
      nums[i]=s.nextInt();

    System.out.println("Enter the value of 'K'");
    int k=s.nextInt();

    int result[]=KmostFrequent(nums, k);
    System.out.print("The K Most Frequent Elements from nums array are: ");
    for(int num:result)
      System.out.print(num+" ");
    s.close();
  }
}