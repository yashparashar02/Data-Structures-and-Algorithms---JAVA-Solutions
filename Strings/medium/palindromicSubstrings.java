package Strings.medium;

import java.util.Scanner;

public class palindromicSubstrings {
  static String longestPalindromicSubstring(String s) {
    if(s == null || s.length() < 2) 
			return s;

		String transformed=transform(s);
		int n=transformed.length();
		int p[]=new int[n], center=0, right=0, maxLength=0, centerIndex=0, i;

		for(i=1; i<n; i++) {
			int mirror=2*center-i;

			if(i < right)
				p[i]=Math.min(right-i, p[mirror]);

			while(i+p[i]+1 < n && i-p[i]-1 >= 0 && transformed.charAt(i + p[i] + 1) == transformed.charAt(i - p[i] - 1))
				p[i]++;

			if(i + p[i] > right) {
				center=i;
				right=i+p[i];
			}

			if(p[i] > maxLength) {
				maxLength=p[i];
				centerIndex=i;
			}
		}
		int start=(centerIndex - maxLength)/2;
		
		return s.substring(start, start+maxLength);
	}
	static String transform(String s) {
		StringBuilder sb=new StringBuilder();

		sb.append('^');

		for(char ch: s.toCharArray()) {
			sb.append('#');
			sb.append(ch);
		}
		sb.append("#$");

		return sb.toString();
	}
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the String");
    String s=sc.nextLine();

    System.out.println("The Longest Palindromic Substring is "+longestPalindromicSubstring(s));
    sc.close();
  }
}