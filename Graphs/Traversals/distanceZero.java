package Graphs.Traversals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Triplet {
	int first, second, third;
	public Triplet(int first, int second, int third) {
		this.first=first;
		this.second=second;
		this.third=third;
	}
}

public class distanceZero {
  static int[][] matrix1(int mat[][]) {
    int m=mat.length, n=mat[0].length, i, j;
    int vis[][]=new int[m][n], distance[][]=new int[m][n];
    Queue<Triplet> q=new LinkedList<Triplet>();
		for(i=0; i<m; i++) {
			for(j=0; j<n; j++) {
				if(mat[i][j] == 0) {
					q.add(new Triplet(i, j, 0));
					vis[i][j]=1;
				}
				else vis[i][j]=0;
			}
		}
		int delRow[]={-1, 0, 1, 0}, delCol[]={0, 1, 0, -1};
    while(!q.isEmpty()) {
      int row=q.peek().first, col=q.peek().second, dist=q.peek().third;
      q.remove();
      distance[row][col]=dist;
      for(i=0; i<4; i++) {
        int nRow=row+delRow[i], nCol=col+delCol[i];
        if(nRow >= 0 && nRow < m && nCol >=0 && nCol < n && vis[nRow][nCol] == 0) {
          vis[nRow][nCol]=1;
          q.add(new Triplet(nRow, nCol, dist+1));
        }
      }
    }
    return distance;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    
    System.out.println("Enter the rows of the Matrix");
    int row=s.nextInt();
    System.out.println("Enter the columns of the Matrix");
    int col=s.nextInt();

    int mat[][]=new int[row][col], r, c;
    System.out.println("Enter "+row+"x"+col+" number of matrix elements");
    for(r=0; r<row; r++) {
      for(c=0; c<col; c++)
        mat[r][c]=s.nextInt();
    }

    int result[][]=matrix1(mat);
    System.out.println("The New Distance Matrix is");
    for(int imageRow[]:result)
      System.out.println(Arrays.toString(imageRow));
    
    s.close();
  }
}