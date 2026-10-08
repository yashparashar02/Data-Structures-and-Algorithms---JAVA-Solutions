package Graphs.Traversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Trio {
  int row, col, time;

  public Trio(int row, int col, int time) {
    this.row=row;
    this.col=col;
    this.time=time;
  }
}
public class numRottenOranges {
  static int rottenOranges(int grid[][]) {
    int m=grid.length, n=grid[0].length;
    Queue<Trio> q=new LinkedList<>();
    int vis[][]=new int[m][n], cntFresh=0, i, j;
    for(i=0; i<m; i++) {
      for(j=0; j<n; j++) {
        if(grid[i][j] == 2) {
          q.add(new Trio(i, j, 0));
          vis[i][j]=2;
        }
        else 
          vis[i][j]=0;

        if(grid[i][j] == 1)
          cntFresh++;
      }
    }
    int tm=0, delRow[]={-1, 0, 1, 0}, delCol[]={0, 1, 0, -1}, cnt=0;
    while(!q.isEmpty()) {
      int r=q.peek().row, c=q.peek().col, t=q.peek().time;
      tm=Math.max(tm, t);
      q.remove();
      for(i=0; i<4; i++) {
        int nRow=r+delRow[i], nCol=c+delCol[i];
        if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
          q.add(new Trio(nRow, nCol, t+1));
          vis[nRow][nCol]=2;
          cnt++;
        }
      }
    }
    if(cnt != cntFresh)
      return -1;
        
    return tm;
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

    System.out.println("The Time Taken to convert all Fresh Oranges to Rotten is: "+rottenOranges(grid));
    s.close();
  }
}