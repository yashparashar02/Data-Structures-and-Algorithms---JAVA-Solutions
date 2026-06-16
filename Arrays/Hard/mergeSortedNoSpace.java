package Arrays.Hard;

import java.util.Scanner;

public class mergeSortedNoSpace {
  static int nextGap(int gap) {
    if(gap <= 1)
      return 0;

    return (gap/2) + (gap%2);
  }

  static void mergeSorted(long a[], long b[]) {
    int m=a.length, n=b.length, left, right, gap=nextGap(m+n);

    while(gap > 0) {
      left=0; 
      right=left+gap;
      
      while(right < (m+n)) {
        if(left < m && right < m) {
          if(a[left] > a[right]) {
            long temp = a[left];
            a[left] = a[right];
            a[right] = temp;
          }
        }
        else if(left < m && right >= m) {
          if(a[left] > b[right - m]) {
            long temp = a[left];
            a[left] = b[right - m];
            b[right - m] = temp;
          }
        }
        else {
          if(b[left - m] > b[right - m]) {
            long temp = b[left - m];
            b[left - m] = b[right - m];
            b[right - m] = temp;
          }
        }
        left++;
        right++;
      }
      gap = nextGap(gap);
    }
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of 1st array: ");
    int m=s.nextInt(), i;

    System.out.println("Enter the range of 2nd array: ");
    int n=s.nextInt();

    long a[]=new long[m], b[]=new long[n];

    System.out.println("Enter "+m+" array elements");
    for(i=0; i<m; i++) 
      a[i]=s.nextInt();

    System.out.println("Enter "+n+" array elements");
    for(i=0; i<n; i++) 
      b[i]=s.nextInt();

    mergeSorted(a, b);
    System.out.println("The Merged Arrays with no spaces is: ");
    for(long j:a)
      System.out.print(j+" ");

    System.out.println();

    for(long j:b) 
      System.out.print(j+" ");
    s.close();
  }
}