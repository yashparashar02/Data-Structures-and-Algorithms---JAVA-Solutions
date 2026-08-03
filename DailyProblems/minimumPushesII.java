package DailyProblems;

import java.util.Arrays;

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

      int cost=(position/8)+1;
      pushes+=freq[i]*cost;
      position++;
    }
    return pushes;
  }
}