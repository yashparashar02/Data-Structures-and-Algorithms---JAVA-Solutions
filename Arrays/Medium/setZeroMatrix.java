package Arrays.Medium;

import java.util.Scanner;

public class setZeroMatrix {
  static void set0Matrix(int matrix[][]) {
    int m=matrix.length, n=matrix[0].length, col0=1, i, j;

    for(i=0; i<m; i++) {
      for(j=0; j<n; j++) {
        if(matrix[i][j] == 0) {
          matrix[i][0]=0;

          if(j != 0)
            matrix[0][j]=0;
          else
            col0=0;
        }
      }
    }
    for(i=1; i<m; i++) {
      for(j=1; j<n; j++) {
        if(matrix[i][0] == 0 || matrix[0][j] == 0) 
          matrix[i][j]=0;
      }
    }
    if(matrix[0][0] == 0) {
      for(j=0; j<n; j++) 
        matrix[0][j]=0;
    }
    if(col0 == 0) {
      for(i=0; i<m; i++) 
        matrix[i][0]=0;
    }
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the no. of rows in the matrix: ");
    int m=s.nextInt(),i;
    System.out.println("Enter the no. of columns in the matrix: ");
    int n=s.nextInt(), j, matrix[][]=new int[m][n];

    System.out.println("Enter "+(m*n)+" matrix elements: ");
    for(i=0; i<m; i++) {
      for(j=0; j<n; j++)
        matrix[i][j]=s.nextInt();
    }
    set0Matrix(matrix);
    System.out.println("The new matrix is: ");
    for(i=0; i<m; i++) {
      for(j=0; j<n; j++) 
        System.out.print(matrix[i][j]+" ");
      System.out.println();
    }
    s.close();      
  }
}