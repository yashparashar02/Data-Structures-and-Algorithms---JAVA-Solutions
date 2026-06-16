package Arrays.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class unionArray {
  static List<Integer> unionArr(int arr1[], int arr2[]) {
    int i=0, j=0, m=arr1.length, n=arr2.length;
    List<Integer> union = new ArrayList<>();

    while(i < m && j < n) {
      if(arr1[i] <= arr2[j]) {
        if(union.size() == 0 || union.get(union.size() - 1) != arr1[i])
          union.add(arr1[i]);
        i++;
      }
      else {
        if(union.size() == 0 || union.get(union.size() - 1) != arr2[j])
          union.add(arr2[j]);
        j++;
      }
    }
    while(i < arr1.length) {
      if(union.get(union.size() - 1) != arr1[i])
        union.add(arr1[i]);
      i++;
    }
    while (j < arr2.length) {
      if(union.get(union.size() - 1) != arr2[j])
        union.add(arr2[j]);
      j++;
    }
    return union;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter size of array 1");
    int m=s.nextInt(), arr1[]=new int[m];

    System.out.println("Enter size of array 2");
    int n=s.nextInt(), arr2[]=new int[n];

    System.out.println("Enter "+m+" array 1 elements");
    for(int i=0;i<m;i++) 
      arr1[i]=s.nextInt();

    System.out.println("Enter "+n+" array 2 elements");
    for(int i=0;i<m;i++) 
      arr2[i]=s.nextInt();

    System.out.println(unionArr(arr1, arr2));
    s.close();
  }
}