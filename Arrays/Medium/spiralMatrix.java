package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class spiralMatrix {
  static List<Integer> spiral(int matrix[][]) {
    int top=0, bottom=matrix.length-1, left=0, right=matrix[0].length-1, i;
    List<Integer> result=new ArrayList<>();

    while(top <= bottom && left <= right) {
      for(i=left; i<=right; i++) 
        result.add(matrix[top][i]);
      top++;
      
      for(i=top; i<=bottom; i++)
        result.add(matrix[i][right]);
      right--;

      if(top <= bottom) {
        for(i=right; i>=left; i--) 
          result.add(matrix[bottom][i]);
        bottom--;
      }

      if(left <= right) {
        for(i=bottom; i>=top; i--)
          result.add(matrix[i][left]);
        left++;
      }
    }
    return result;
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

    System.out.println("The new matrix is: "+spiral(matrix));
    s.close();
  }
}