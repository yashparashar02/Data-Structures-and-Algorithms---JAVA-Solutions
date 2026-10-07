package Graphs.Traversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
  int first, second;

  public Pair(int first, int second) {
    this.first=first;
    this.second=second;
  }
}

public class numberOfEnclaves {
  static int numEnclaves(int grid[][]) {
    Queue<Pair> q=new LinkedList<Pair>();
    int m=grid.length, n=grid[0].length;
    int vis[][]=new int[m][n], i, j;
    for(i=0; i<m; i++) {
      for(j=0; j<n; j++) {
        if(i==0 || j==0 || i==m-1 || j==n-1) {
          if(grid[i][j] == 1) {
            q.add(new Pair(i, j));
            vis[i][j]=1;
          }
        }
      }
    }
    int delRow[]={-1, 0, 1, 0}, delCol[]={0, 1, 0, -1};

    while(!q.isEmpty()) {
      int row=q.peek().first, col=q.peek().second;
      q.remove();

      for(i=0; i<4; i++) {
        int nRow=row+delRow[i], nCol=col+delCol[i];
        if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
          q.add(new Pair(nRow, nCol));
          vis[nRow][nCol]=1;
        }
      }
    }
    int cnt=0;
    for(i=0; i<m; i++) {
      for(j=0; j<n; j++) {
        if(grid[i][j] == 1 & vis[i][j] == 0)
          cnt++;
      }
    }
    return cnt;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the rows of the Grid");
    int row=s.nextInt();
    System.out.println("Enter the columns of the Grid");
    int col=s.nextInt();

    int grid[][]=new int[row][col], r, c;
    System.out.println("Enter "+row+"x"+col+" number of grid elements");
    for(r=0; r<row; r++) {
      for(c=0; c<col; c++)
        grid[r][c]=s.nextInt();
    }

    System.out.println("The Number of Enclaves are "+numEnclaves(grid));
    s.close();
  }
}