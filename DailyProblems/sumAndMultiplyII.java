package DailyProblems;

import java.util.Arrays;
import java.util.Scanner;

public class sumAndMultiplyII {
  static final int mod=1_000_000_007;

  static int[] sumMultiplyII(String s, int[][] queries) {
    int n=s.length();

    long P[]=new long[n+1], sum[]=new long[n+1], pow10[]=new long[n+1];;
    int nonZeroCount[]=new int[n+1], i;
    
    pow10[0]=1;
    for(i=1; i<=n; i++)
      pow10[i]=(pow10[i-1]*10)%mod;

    for(i=0; i<n; i++) {
      int digit=s.charAt(i) - '0';

      if(digit != 0) {
        P[i+1]=(P[i]*10+digit)%mod;
        sum[i+1]=sum[i]+digit;
        nonZeroCount[i+1]=nonZeroCount[i]+1;
      }
      else {
        P[i+1]=P[i];
        sum[i+1]=sum[i];
        nonZeroCount[i+1]=nonZeroCount[i];
      }
    }
    int q=queries.length;
    int ans[]=new int[q], idx;

    for(idx=0; idx<q; idx++) {
      int l=queries[idx][0], r=queries[idx][1];
      int k=nonZeroCount[r+1]-nonZeroCount[l];

      if(k == 0) {
        ans[idx]=0;
        continue;
      }
      long x=(P[r+1] - (P[l]*pow10[k])%mod+mod)%mod, digitSum=sum[r+1]-sum[l];

      ans[idx]=(int) ((x*(digitSum%mod))%mod);
    }
    return ans;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the String value");
    String s=sc.nextLine();
    
    System.out.println("Enter the number of queries");
    int q=sc.nextInt();
    
    int queries[][]=new int[q][2], i;

    System.out.println("Enter l and r");
    for(i=0; i<q; i++) {
        queries[i][0]=sc.nextInt();
        queries[i][1]=sc.nextInt();
    }

    int ans[]=sumMultiplyII(s, queries);
    System.out.println("The Product is: "+Arrays.toString(ans));
    sc.close();
  }
}