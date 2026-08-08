package DailyProblems;

import java.util.Arrays;
import java.util.Scanner;

public class smallestValidSequence {
  static int[] validSequence(String word1, String word2) {
    int m = word1.length(), n = word2.length();

    int last[] = new int[n];
    Arrays.fill(last, -1);

    int j = n - 1;
    for (int i = m - 1; i >= 0 && j >= 0; i--) {
      if (word1.charAt(i) == word2.charAt(j)) {
        last[j] = i;
        j--;
      }
    }

    int ans[] = new int[n];
    j = 0;
    boolean changed = false;

    for (int i = 0; i < m && j < n; i++) {
      boolean isMatch = (word1.charAt(i) == word2.charAt(j));

      if (isMatch) {
        ans[j] = i;
        j++;
      } 
      else if (!changed) {
        boolean canChange = (j == n - 1) || (last[j + 1] > i);

        if (canChange) {
          ans[j] = i;
          changed = true;
          j++;
        }
      }
    }

    return j == n ? ans : new int[0];
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    
    System.out.println("Enter the 2 words");
    String word1=s.nextLine(), word2=s.nextLine();

    int result[]=validSequence(word1, word2);
    System.out.println("The lexicographically smallest valid sequence of indices is: "+Arrays.toString(result));
    s.close();
  }
}