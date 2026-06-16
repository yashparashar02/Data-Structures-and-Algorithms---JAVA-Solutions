package Arrays.Easy;

import java.util.Scanner;

public class findLargest {
  static int largestElem(int arr[], int n) {
    int max=arr[0], i;

    for(i=1;i<n;i++) {
      if(arr[i] > max)
        max=arr[i];
    }
    return max;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the range of array");
    int n=s.nextInt(), arr[]=new int[n];

    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++) 
      arr[i]=s.nextInt();

    System.out.println("Largest Element is: "+largestElem(arr, n));
    s.close();
  }
}