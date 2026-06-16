import java.util.*;

public class countDigits {
  static int countDigit(long x) {
    int cnt=0;
    do {
      cnt++;
      x/=10;
    }while(x>0);
    return cnt;
  }
  public static void main(String[] args) {
    //countDigits obj=new countDigits();
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the Number: ");
    long x=s.nextLong();
    System.out.println("the digits in the number are: "+countDigit(x));
    s.close();
  }
}