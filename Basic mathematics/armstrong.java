import java.util.*;

public class armstrong {
  public static boolean isArmstrong(int num) {
    int temp=num, sum=0, lastDigit;
    int n=String.valueOf(num).length();
    do {
      lastDigit=num%10;
      sum+=Math.pow(lastDigit, n);
      num/=10;
    }while(num!=0);
    if(sum==temp)
      return true;
    else 
      return false;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    //armstrong obj=new armstrong();
    System.out.println("Enter the number: ");
    int num=s.nextInt();
    System.out.println(isArmstrong(num));
    s.close();
  }  
}