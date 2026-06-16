package Arrays.Easy;

import java.util.Scanner;

public class sortedCheck {
  static boolean sortCheck(int n, int arr[]) {
    for(int i=0;i<n-1;i++) {
      if(arr[i] > arr[i+1])
        return false;
    }
    return true;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter size of array");
    int n=s.nextInt(), arr[]=new int[n];

    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++) 
      arr[i]=s.nextInt();

    System.out.println(sortCheck(n,arr));
    s.close();
  }
}