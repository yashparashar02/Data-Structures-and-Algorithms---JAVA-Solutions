package BinarySearch.BSon2DArrays;

import java.util.Scanner;

public class peakElementII {
  static int maxRow(int matrix[][], int col) {
    int row=0, i;

    for(i=0; i<matrix.length; i++) {
      if(matrix[i][col] > matrix[row][col])
        row=i;
    }
    return row;
  }
  static int[] findPeak(int matrix[][], int m, int n) {
    int low=0, mid, high=n-1;

    while(low <= high) {
      mid=low+(high-low)/2;

      int row=maxRow(matrix, mid);

      int left=(mid-1 >= 0) ? matrix[row][mid-1] : -1;
      int right=(mid+1 < n) ? matrix[row][mid+1] : -1;

      if(matrix[row][mid] > left && matrix[row][mid] > right)
        return new int[] {row, mid};

      else if(left > matrix[row][mid])
        high=mid-1;

      else low=mid+1;
    }
    return new int[] {-1, -1};
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

    int ans[]=findPeak(matrix, m, n);
    System.out.println("The Peak element is found at ["+ans[0]+", "+ans[1]+"]");
    s.close();
  }
}