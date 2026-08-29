package DailyProblems.Others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class substringConcatenation {
  static List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result=new ArrayList<>();
    if(s == null || words == null || s.length() == 0 || words.length == 0)
      return result;

    int wordLen=words[0].length(), wordCount=words.length, sLen=s.length();
    int totalLen=wordLen*wordCount;

    if(sLen < totalLen)
      return result;

    Map<String, Integer> targetMap=new HashMap<>();
    for(String word:words)
      targetMap.put(word, targetMap.getOrDefault(word, 0)+1);

    for(int i=0; i<wordLen; i++) {
      int left=i, right=i, count=0;
      Map<String, Integer> currentMap=new HashMap<>();

      while(right+wordLen <= sLen) {
        String sub=s.substring(right, right+wordLen);
        right+=wordLen;

        if(targetMap.containsKey(sub)) {
          currentMap.put(sub, currentMap.getOrDefault(sub, 0)+1);
          count++;

          while(currentMap.get(sub) > targetMap.get(sub)) {
            String leftWord=s.substring(left, left+wordLen);
            currentMap.put(leftWord, currentMap.get(leftWord)-1);
            count--;
            left+=wordLen;
          }
          if(count == wordCount)
            result.add(left);
        }
        else {
          currentMap.clear();
          count=0;
          left=right;
        }
      }
    }
    return result;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the String");
    String s=sc.nextLine();

    System.out.println("Enter the number of words you want to count");
    int n=sc.nextInt(), i;
    sc.nextLine();

    String words[]=new String[n];
    System.out.println("Enter "+n+" words");
    for(i=0; i<n; i++) 
      words[i]=sc.nextLine();

    System.out.println("The Starting Indices of all the Concatenated Substrings in 's' are: ");
    List<Integer> result=findSubstring(s, words);
    for(i=0; i<result.size(); i++) {
      System.out.print(result.get(i));
      if(i < result.size() - 1)
        System.out.print(" ");
    }
    System.out.println();
    sc.close();
  }
}