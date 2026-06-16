package Arrays.Hard;

import java.util.ArrayList;
import java.util.Scanner;

public class generatePascalTriangle {
  static ArrayList<ArrayList<Long>> generatePascal(int n) {
    ArrayList<ArrayList<Long>> triangle=new ArrayList<>();

    for(int row=0; row<n; row++) {
      ArrayList<Long> currentRow=generateRow(row);
      triangle.add(currentRow);
    }
    return triangle;
  }

  static ArrayList<Long> generateRow(int row) {
    ArrayList<Long> currentRow=new ArrayList<>();
    long ans=1;
    currentRow.add(ans);

    for(int col=1; col<=row; col++) {
      ans=ans*(row-col+1)/col;
      currentRow.add(ans);
    }
    return currentRow;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of rows: ");
    int n=s.nextInt();

    ArrayList<ArrayList<Long>> triangle=generatePascal(n);
    for(ArrayList<Long> row: triangle) {
      for(Long num: row)
        System.out.print(num+" ");
      System.out.println();
    }
    s.close();
  }
}