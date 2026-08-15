package DailyProblems;

import java.util.Scanner;

public class findIndexString {
  static int findIndex(String haystack, String needle) {
        int hLen = haystack.length(), nLen = needle.length();

        if (nLen > hLen) 
            return -1;

        for (int i=0; i<=hLen-nLen; i++) {
            int j = 0;
            while(j < nLen && haystack.charAt(i + j) == needle.charAt(j))
                j++;
            if (j == nLen)
                return i;
        }

        return -1;
    }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);


  }
}