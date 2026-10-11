package Graphs.Traversals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Duo {
  int first, second;
  public Duo(int first, int second) {
    this.first=first;
    this.second=second;
  }
}
public class distinctIslands {
  static int numdistinctIsland(int arr[][]) {
    int m=arr.length, n=arr[0].length;
		int vis[][]=new int[m][n], i, j;
		HashSet<ArrayList<String>> set=new HashSet<>();
		for(i=0; i<m; i++) {
			for(j=0; j<n; j++) {
				if(vis[i][j] == 0 && arr[i][j] == 1) {
					ArrayList<String> vec=new ArrayList<>();
					dfs(i, j, vis, arr, vec, i, j);
					set.add(vec);
				}
			}
		}
		return set.size();
	}
	static void dfs(int row, int col, int vis[][], int arr[][], ArrayList<String> vec, int row0, int col0) {
    int m=arr.length, n=arr[0].length;
		vis[row][col]=1;
		vec.add(toString(row - row0, col - col0));
		int delRow[]={-1, 0, 1, 0}, delCol[]={0, -1, 0, 1};
		for(int i=0; i<4; i++) {
			int nRow=row+delRow[i], nCol=col+delCol[i];
			if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && arr[nRow][nCol] == 1)
				dfs(nRow, nCol, vis, arr, vec, row0, col0);
		}
	}
	static String toString(int r, int c) {
		return Integer.toString(r)+" "+Integer.toString(c);
	}
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of rows");
    int row=s.nextInt();
    System.out.println("Enter the number of columns");
    int col=s.nextInt();

    int arr[][]=new int[row][col], r, c;
    System.out.println("Enter "+row+"x"+col+" number of nodes");
    for(r=0; r<row; r++) {
      for(c=0; c<col; c++)
        arr[r][c]=s.nextInt();
    }

    System.out.println("\nThere are "+numdistinctIsland(arr)+" Distinct Islands");
    s.close();
  }
}