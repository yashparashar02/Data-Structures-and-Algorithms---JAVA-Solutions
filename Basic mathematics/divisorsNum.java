import java.util.*;

public class divisorsNum {
  public static List<Integer> printDivisors(int n) {
    List<Integer> divisors=new ArrayList<>();
    for(int i=1;i<=Math.sqrt(n);i++) {
      if(n%i==0) {
        divisors.add(i);
        if((n/i)!=i)
          divisors.add(n/i);
        }
    }
    Collections.sort(divisors);
    return divisors;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the number: ");
    int num=s.nextInt();
    System.out.println(printDivisors(num));
    s.close();
  }
}