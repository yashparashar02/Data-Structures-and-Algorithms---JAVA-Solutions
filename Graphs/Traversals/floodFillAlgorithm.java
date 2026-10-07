package Graphs.Traversals;

import java.util.Arrays;
import java.util.Scanner;

public class floodFillAlgorithm {
  static int[][] floodFill(int image[][], int sr, int sc, int color) {
    int init=image[sr][sc], ans[][]=image;
    int delRow[]={-1, 0, 1, 0}, delCol[]={0, 1, 0, -1};
    dfs(sr, sc, ans, image, color, delRow, delCol, init);

    return ans;
  }
  static void dfs(int row, int col, int ans[][], int image[][], int color, int delRow[], int delCol[], int init) {
    ans[row][col]=color;
    int m=image.length, n=image[0].length, i;
    for(i=0; i<4; i++) {
      int nRow=row+delRow[i], nCol=col+delCol[i];
      if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && image[nRow][nCol] == init && ans[nRow][nCol] != color)
        dfs(nRow, nCol, ans, image, color, delRow, delCol, init);
    }
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the row for image");
    int row=s.nextInt();
    System.out.println("Enter the column for image");
    int col=s.nextInt();

    int image[][]=new int[row][col], r, c;
    System.out.println("Enter "+row+"x"+col+" number of nodes in the image");
    for(r=0; r<row; r++) {
      for(c=0; c<col; c++)
        image[r][c]=s.nextInt();
    }

    System.out.println("Enter the starting row");
    int sr=s.nextInt();
    System.out.println("Enter the starting column");
    int sc=s.nextInt();
    System.out.println("Enter the color to change to");
    int color=s.nextInt();

    int result[][]=floodFill(image, sr, sc, color);
    System.out.println("The New Image Matrix is ");
    for(int imageRow[]:result)
      System.out.println(Arrays.toString(imageRow));
    
    s.close();
  }
}