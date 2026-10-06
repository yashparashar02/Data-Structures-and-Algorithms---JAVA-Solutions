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

public class numberIslands {
  static int islands(char grid[][]) {
    int m=grid.length, n=grid[0].length;
    int vis[][]=new int[m][n], cnt=0, row, col;

    for(row=0; row<m; row++) {
      for(col=0; col<n; col++) {
        if(vis[row][col] == 0 && grid[row][col] == '1') {
          cnt++;
          bfs(row, col, vis, grid);
        }
      }
    }
    return cnt;
  }
  static void bfs(int r, int c, int vis[][], char grid[][]) {
    vis[r][c]=1;
    Queue<Pair> q=new LinkedList<Pair>();
    q.add(new Pair(r, c));
    int m=grid.length, n=grid[0].length;

    // int delRow[]={-1, 0, 1, 0}, delCol[]={0, 1, 0, -1};

    while(!q.isEmpty()) {
      int row=q.peek().first, col=q.peek().second;
      q.remove();

      for(int delRow=-1; delRow<=1; delRow++) {
        for(int delCol=-1; delCol<=1; delCol++) {
          if(Math.abs(delRow) + Math.abs(delCol) != 1) 
            continue;

          int nRow=row+delRow, nCol=col+delCol;
          if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == '1' && vis[nRow][nCol] == 0) {
            vis[nRow][nCol]=1;
            q.add(new Pair(nRow, nCol));
          }
        }
      }
    }
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of rows");
    int row=s.nextInt();
    System.out.println("Enter the number of columns");
    int col=s.nextInt();

    char grid[][]=new char[row][col], r, c;
    System.out.println("Enter "+row+"x"+col+" number of nodes");
    for(r=0; r<row; r++) {
      for(c=0; c<col; c++)
        grid[r][c]=s.next().charAt(0);
    }

    System.out.println("There are "+islands(grid)+" islands");
    s.close();
  }
}