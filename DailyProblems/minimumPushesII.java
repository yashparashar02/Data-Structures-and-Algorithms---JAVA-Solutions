package DailyProblems;

import java.util.Arrays;
import java.util.Scanner;

public class minimumPushesII {
  static int minPush(String word) {
    int freq[]=new int[26];

    for (char ch : word.toCharArray()) 
      freq[ch - 'a']++;

    Arrays.sort(freq);

    int pushes=0, position=0, i;

    for(i=25; i>=0; i--) {
      if(freq[i] == 0)
        break;

      pushes+=freq[i]*((position/8)+1);
      position++;
    }
    return pushes;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the word");
    String word=s.nextLine();

    System.out.println("The Minimum Number of Pushes are: "+minPush(word));
    s.close();
  }
}