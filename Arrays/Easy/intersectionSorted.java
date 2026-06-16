package Arrays.Easy;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class intersectionSorted {
  static List<Integer> intersectSort(List<Integer> arr1, int m, List<Integer> arr2, int n) {
    int i=0, j=0;
    List<Integer> intersection = new ArrayList<>();

    while(i < m && j < n) {
      if(arr1.get(i) < arr2.get(j))
        i++;
      else if(arr2.get(j) < arr1.get(i))
        j++;
      else {
        if(intersection.size() == 0 || intersection.get(intersection.size() - 1) != arr1.get(i))
          intersection.add(arr1.get(i));

        i++;
        j++;
      }
    }
    return intersection;
  }
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Enter size of first array:");
    int m=s.nextInt();
    List<Integer> arr1 = new ArrayList<>();
    System.out.println("Enter "+m+" sorted elements:");
    for(int i=0;i<m;i++)
      arr1.add(s.nextInt());
    
    System.out.println("Enter size of second array:");
    int n=s.nextInt();
    List<Integer> arr2 = new ArrayList<>();
    System.out.println("Enter "+n+" sorted elements:");
    for(int i=0;i<n;i++)
      arr2.add(s.nextInt());

    List<Integer> intersection = intersectSort(arr1, m, arr2, n);
    System.out.print("Intersection of the arrays are: "+intersection);
    s.close();
  }
}