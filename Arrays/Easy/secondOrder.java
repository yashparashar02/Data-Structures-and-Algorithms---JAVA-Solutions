package Arrays.Easy;

import java.util.Scanner;

public class secondOrder {
  static int secondLarge(int arr[], int n) {
    int largest=Integer.MIN_VALUE, secLarge=Integer.MIN_VALUE, i;

    for(i=0;i<n;i++) {
      if(arr[i] > largest) {
        secLarge = largest;
        largest = arr[i];
      }
      else if(arr[i] < largest && arr[i] > secLarge)
        secLarge = arr[i];
    }

    return secLarge;
  }
  static int secondSmall(int arr[], int n) {
    int smallest=Integer.MAX_VALUE, secSmall=Integer.MAX_VALUE, i;

    for(i=0;i<n;i++) {
      if(arr[i] < smallest) {
        secSmall = smallest;
        smallest = arr[i];
      }
      else if(arr[i] > smallest && arr[i] < secSmall)
        secSmall=arr[i];
    }

    return secSmall;
  }

  static int[] getSecondOrder(int arr[], int n) {
    int secLarge=secondLarge(arr, n);
    int secSmall=secondSmall(arr, n);

    return new int[]{secLarge, secSmall};
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter size of array");
    int n=s.nextInt(), arr[]=new int[n];

    System.out.println("Enter "+n+" array elements");
    for(int i=0;i<n;i++) 
      arr[i]=s.nextInt();

    int result[]=getSecondOrder(arr, n);
    System.out.println("The second largest element is: "+result[0]);
    System.out.println("The second smallest element is: "+result[1]);
    s.close();
  }
}