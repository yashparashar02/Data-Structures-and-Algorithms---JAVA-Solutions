import java.util.*;

public class reverseNum {
  public static long reverseNumber(long x) {
		long reverseNumber=0,lastDigit;
		do {
			lastDigit=x%10;
			x/=10;
			reverseNumber=(reverseNumber*10)+lastDigit;
		}while(x!=0);
		return reverseNumber;
	}
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    //reverseNum obj=new reverseNum();
    System.out.println("Enter the number: ");
    long x=s.nextInt();
    System.out.println("The reverse of the number is: "+reverseNumber(x));
    s.close();
  }
}