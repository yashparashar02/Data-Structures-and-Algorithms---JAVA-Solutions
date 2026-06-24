package BinarySearch.BSon2DArrays;

import java.util.Scanner;

public class search2DMatrixII {
  static boolean matrixIISearch(int matrix[][], int m, int n, int target) {
    int row=0, col=n-1;

    while(row < m && col >= 0) {
      if(matrix[row][col] == target)
        return true;

      else if(matrix[row][col] < target)
        row++;

      else col--;
    }
    return false;
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

    System.out.println("Enter the target you want to find");
    int target=s.nextInt();

    if(matrixIISearch(matrix, m, n, target))
      System.out.println("Found the target element");

    else System.out.println("Target not found");
    s.close();
  }
}