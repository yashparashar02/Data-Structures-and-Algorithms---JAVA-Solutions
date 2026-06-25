package BinarySearch.BSon2DArrays;

import java.util.Scanner;

public class medianMatrix {
  static int upperBound(int row[], int target) {
    int low=0, mid, high=row.length-1, ans=row.length;
    while (low <= high) {
      mid=low+(high - low)/2;

      if(row[mid] > target) {
        ans=mid;
        high=mid-1;
      }
      else low=mid+1;
    }
    return ans;
  }
  static int median(int matrix[][], int m, int n) {
    int low=Integer.MAX_VALUE, mid, high=Integer.MIN_VALUE, req=(m*n)/2, i;

    for(i=0; i<m; i++) {
      low=Math.min(low, matrix[i][0]);
      high=Math.max(high, matrix[i][n-1]);
    }

    while(low <= high) {
      mid=low+(high-low)/2;

      int count=0;
      for(i=0; i<m; i++)
        count+=upperBound(matrix[i], mid);

      if(count <= req)
        low=mid+1;

      else high=mid-1;
    }
    return low;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of rows");
    int m=s.nextInt(), i;
    System.out.println("Enter the number of columns");
    int n=s.nextInt(), j, matrix[][]=new int[m][n];
    
    System.out.println("Enter "+m*n+" matrix elements in sorted manner");
    for(i=0; i<m; i++) {
      for(j=0; j<n; j++)
        matrix[i][j]=s.nextInt();
    }

    System.out.println("The median of the matrix is "+median(matrix, m, n));
    s.close();
  }
}