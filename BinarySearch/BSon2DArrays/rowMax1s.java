package BinarySearch.BSon2DArrays;

import java.util.Scanner;

public class rowMax1s {
  static int lowerbound(int row[]) {
    int low=0, mid, high=row.length-1, ans=row.length;

    while(low <= high) {
      mid=low+(high-low)/2;

      if(row[mid] == 1) {
        ans=mid;
        high=mid-1;
      }
      else low=mid+1;
    }
    return ans;
  }
  static int rowMax1(int matrix[][]) {
    int m=matrix.length, n=matrix[0].length;

    int maxOnes=0, index=-1;

    for(int i=0; i<m; i++) {
      int firstOne=lowerbound(matrix[i]);
      int ones=n-firstOne;

      if(ones > maxOnes) {
        maxOnes=ones;
        index=i;
      }
    }
    return index;
  }
  public static void main(String arr[]) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of rows of the matrix");
    int m=s.nextInt(), i;
    System.out.println("Enter the number of columns of the matrix");
    int n=s.nextInt(), j, matrix[][]=new int[m][n];

    System.out.println("Enter the "+m*n+" number of elemnts for the matrix");
    for(i=0; i<m; i++) {
      for(j=0; j<n; j++) 
        matrix[i][j]=s.nextInt();
    }

    System.out.println("The row with maximum ones are "+rowMax1(matrix));
    s.close();
  }
}