package Infosys_SP_DSE;

import java.util.*;

public class getMaximumGenerated {
  public static int getMaxGenerated(int n) {
    if(n==0)
      return 0;

    int num[]=new int[n+1];
    num[0]=0;
    num[1]=1;

    int max=1,i;
    for(i=2;i<=n;i++) {
      if(i%2==0)
        num[i]=num[i/2];
      else
        num[i]=num[i/2]+num[i/2+1];

      max=Math.max(max,num[i]);
    }

    return max;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the range:");
    int n=s.nextInt();
    System.out.println("The maximum no. genersated from array is: "+getMaxGenerated(n));
    s.close();
  }
}