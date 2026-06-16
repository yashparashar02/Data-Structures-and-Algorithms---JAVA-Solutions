package Arrays.Easy;

import java.util.Scanner;;

public class secondLargest {
  static int secondLarge(int arr[], int n) {
    int largest=Integer.MIN_VALUE, secLarge=Integer.MIN_VALUE,i;

    for(i=1;i<n;i++) {
      if(arr[i] > largest) {
        secLarge = largest;
        largest = arr[i];
      }
      else if(arr[i] < largest && arr[i] > secLarge)
        secLarge = arr[i];
    }

    return secLarge;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter size of array");
    int n=s.nextInt(), arr[]=new int[n];

    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++) 
      arr[i]=s.nextInt();

    System.out.println("The second largest element is: "+secondLarge(arr, n));
    s.close();
  }
}