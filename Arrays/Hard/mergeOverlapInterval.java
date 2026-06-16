package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class mergeOverlapInterval {
  static int[][] mergeInterval(int intervals[][]) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    List<int[]> result=new ArrayList<>();
    result.add(intervals[0]);

    for(int i=1; i<intervals.length; i++) {
      int last[] = result.get(result.size() - 1);

      if(intervals[i][0] <= last[1])
        last[1] = Math.max(last[1], intervals[i][1]);

      else
        result.add(intervals[i]);
    }
    return result.toArray(new int[result.size()][]);
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), intervals[][]=new int[n][2], i;

    System.out.println("Enter "+n+" intervals (start, end)");
    for(i=0; i<n; i++) {
      System.out.print("Interval "+(i+1)+": ");
      intervals[i][0]=s.nextInt();
      intervals[i][1]=s.nextInt();
    }

    System.out.println("Original Intervals:");
    for(int[] interval:intervals) 
      System.out.println(interval[0]+" "+interval[1]);

    int result[][]=mergeInterval(intervals);
    System.out.println("Merged Intervals");
    for(int[] interval:result)
      System.out.println(interval[0]+", "+interval[1]);

    s.close();
  }
}