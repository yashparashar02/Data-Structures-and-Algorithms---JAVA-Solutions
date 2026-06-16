import java.util.Scanner;

public class gcd {
  public static int findGcd(int x, int y) {
    while(x>0 && y>0) {
      if(x>y)
        x%=y;
      else y%=x;
    }
    if(x==0)
      return y;
    else
      return x;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the numbers: ");
    int x=s.nextInt(), y=s.nextInt();
    System.out.println("The GCD of "+x+" & "+y+" is: "+findGcd(x,y));
    s.close();
  }
}