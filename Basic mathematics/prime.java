import java.util.*;

public class prime {
  public static boolean isPrime(int num) {
    int cnt=0,i;
    for(i=1;i<=Math.sqrt(num);i++) {
      if(num%i==0){
        cnt++;
        if((num/i)!=i)
          cnt++;
      }
    }
    if(cnt==2)
      return true;
    else
      return false;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the number: ");
    int num=s.nextInt();
    System.out.println(isPrime(num));
    s.close();
  }
}