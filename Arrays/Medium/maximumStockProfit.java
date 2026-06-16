package Arrays.Medium;

import java.util.Scanner;

public class maximumStockProfit {
  static int maxStockProfit(int prices[]) {
    int minPrice=prices[0], maxProfit=0, profit, i;

    for(i=0; i<prices.length; i++) {
      profit=prices[i]-minPrice;

      maxProfit=Math.max(maxProfit, profit);

      minPrice=Math.min(minPrice, prices[i]);
    }
    return maxProfit;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of days: ");
    int n=s.nextInt(), prices[]=new int[n], i;

    System.out.println("Enter "+n+" the stock prices for each day: ");
    for(i=0; i<n; i++) 
      prices[i]=s.nextInt();

    System.out.println("The Maximum profit that can be made is: "+maxStockProfit(prices));
    s.close();
  }
}