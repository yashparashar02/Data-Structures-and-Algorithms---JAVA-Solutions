package Arrays.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class leaderInArr {
  static ArrayList<Integer> leader(ArrayList<Integer> elements) {
    ArrayList<Integer> result=new ArrayList<>();
    int maxElem=Integer.MIN_VALUE, i;

    for(i=elements.size()-1; i>=0; i--) {
      if(elements.get(i) > maxElem) {
        result.add(elements.get(i));
        maxElem=elements.get(i);
      }
    }
    Collections.reverse(result);

    return result;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the range of array: ");
    int n=s.nextInt(), i;

    ArrayList<Integer> elements=new ArrayList<>();

    System.out.println("Enter "+n+" array elements");
    for(i=0; i<n; i++) 
      elements.add(s.nextInt());

    ArrayList<Integer> leaders = leader(elements);
    System.out.println("The leaders are: "+leaders);
    s.close();
  }
}