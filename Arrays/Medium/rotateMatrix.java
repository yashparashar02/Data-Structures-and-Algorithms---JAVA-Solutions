package Arrays.Medium;

import java.util.Scanner;

public class rotateMatrix {
  static void rotate(int matrix[][]) {
    int n=matrix.length, i, j;

    for(i=0; i<n; i++) {
      for(j=i+1; j<n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    for(i=0; i<n; i++) {
      int left=0, right=n-1;

      while(left < right) {
        int temp = matrix[i][left];
        matrix[i][left] = matrix[i][right];
        matrix[i][right] = temp;

        left++;
        right--;
      }
    }
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the no. of rows and columns for the matrix: ");
    int n=s.nextInt(),i, j, matrix[][]=new int[n][n];

    System.out.println("Enter "+(n*n)+" matrix elements: ");
    for(i=0; i<n; i++) {
      for(j=0; j<n; j++)
        matrix[i][j]=s.nextInt();
    }
    rotate(matrix);
    System.out.println("The rotated matrix is: ");
    for(i=0; i<n; i++) {
      for(j=0; j<n; j++) 
        System.out.print(matrix[i][j]+" ");
      System.out.println();
    }
    s.close();
  }
}