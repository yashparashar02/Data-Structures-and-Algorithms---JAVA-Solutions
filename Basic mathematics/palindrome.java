import java.util.*;

public class palindrome {
  public boolean isPalindrome(int x) {
    int temp=x, reverseNumber=0, lastDigit;
    do{
        lastDigit=x%10;
        x/=10;
        reverseNumber=(reverseNumber*10)+lastDigit;
    }while(x!=0);
    //System.out.println(reverseNumber);
    if(reverseNumber==temp && reverseNumber>=0)
        return true;

    else
        return false;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    palindrome obj=new palindrome();
    System.out.println("Enter the number: ");
    int x=s.nextInt();
    System.out.println(obj.isPalindrome(x));
    s.close();
  }  
}