package DailyProblems;

public class shortestSmallestBeautiful {
  static String lexicographicallString(String s, int k) {
    int left=0, right, onesCount=0, minLen=Integer.MAX_VALUE;
    String result="";

    for(right=0; right<s.length(); right++) {
      if(s.charAt(right) == '1')
        onesCount++;

      while(onesCount == k) {
        while(s.charAt(left) == '0')
          left++;

        int currentLen=right-left+1;
        String currentSub=s.substring(left, right+1);

        if(currentLen < minLen) {
          minLen=currentLen;
          result=currentSub;
        }

        else if(currentLen == minLen && currentSub.compareTo(result) < 0)
          result=currentSub;

        if(s.charAt(left) == '1')
          onesCount--;

        left++;
      }
    }
    return result;
  }
}