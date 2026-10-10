package Graphs.Traversals;

import java.util.Arrays;
import java.util.Scanner;

public class surroundedRegions {
  static char[][] replaceOwithX(char board[][]) {
    int m=board.length, n=board[0].length, i, j;
    int delRow[]={-1, 0, 1, 0}, delCol[]={0, 1, 0, -1}, vis[][]=new int[m][n];

    for(j=0; j<n; j++) {
      if(vis[0][j] == 0 && board[0][j] == 'O')
        dfs(0, j, vis, board, delRow, delCol);

      if(vis[m-1][j] == 0 && board[m-1][j] == 'O')
        dfs(m-1, j, vis, board, delRow, delCol);
    }
    for(i=0; i<m; i++) {
      if(vis[i][0] == 0 && board[i][0] == 'O')
        dfs(i, 0, vis, board, delRow, delCol);

      if(vis[i][n-1] == 0 && board[i][n-1] == 'O')
        dfs(i, n-1, vis, board, delRow, delCol);
    }
    for(i=0; i<m; i++) {
      for(j=0; j<n; j++) {
        if(vis[i][j] == 0 && board[i][j] == 'O')
          board[i][j]='X';
      }
    }
    return board;
  }
  static void dfs(int row, int col, int vis[][], char board[][], int delRow[], int delCol[]) {
    vis[row][col]=1;
    int m=board.length, n=board[0].length;
    for(int i=0; i<4; i++) {
      int nRow=row+delRow[i], nCol=col+delCol[i];
      if(nRow >= 0 && nRow < m && nCol >=0 && nCol < n && vis[nRow][nCol] == 0 && board[nRow][nCol] == 'O')
        dfs(nRow, nCol, vis, board, delRow, delCol);
    }
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    
    System.out.println("Enter the rows of the Matrix");
    int row=s.nextInt(), r;
    System.out.println("Enter the columns of the Matrix");
    int col=s.nextInt(), c;

    char board[][]=new char[row][col];
    System.out.println("Enter Board Elements");
    for(r=0; r<row; r++) {
      for(c=0; c<col; c++)
        board[r][c]=s.next().charAt(0);
    }

    char result[][]=replaceOwithX(board);
    System.out.println("The new Board is: ");
    for(char imageRow[]:result)
      System.out.println(Arrays.toString(imageRow));

    s.close();
  }
}