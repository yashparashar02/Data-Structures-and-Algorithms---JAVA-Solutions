package Arrays.Easy;

import java.util.Scanner;
import java.util.Arrays;

public class leftRotateOne {
  static int[] leftRotOne(int arr[], int n) {
    if(arr == null || n <= 1)
      return arr;

    int first = arr[0], i;

    for(i=1;i<n;i++) 
      arr[i-1] = arr[i];

    arr[n-1] = first;

    return arr;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    
    System.out.println("Enter size of array");
    int n=s.nextInt(), arr[]=new int[n];

    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++) 
      arr[i]=s.nextInt();

    int rotated[] = leftRotOne(arr, n);
    System.out.println(Arrays.toString(rotated));
    s.close();
  }
}