package BinarySearch.BSonAnswers;

import java.util.Scanner;

public class gasStation {
  static int requiredStations(int stations[], double distance) {
    int count=0, i;

    for(i=0; i<stations.length-1; i++) {
      double gap=stations[i+1] - stations[i];

      int stationsNeeded=(int) (gap/distance);

      if(Math.abs(gap - stationsNeeded * distance) < 1e-9)
        stationsNeeded--;

      count+=stationsNeeded;
    }
    return count;
  }
  static double minMaxDistance(int stations[], int k) {
    double low=0, mid, high=0;

    for(int i=0; i<stations.length-1; i++) {
      double gap=(double) stations[i+1] - stations[i];
      high=Math.max(high, gap);
    }

    double diff=1e-6;

    while (high-low > diff) {
      mid=low+(high-low)/2;

      int needed=requiredStations(stations, mid);

      if(needed > k)
        low=mid;

      else high=mid;
    }
    return high;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of Gas Stations");
    int n=s.nextInt(), stations[]=new int[n], i;

    System.out.println("Enter position for "+n+" Gas Stations");
    for(i=0; i<n; i++) 
      stations[i]=s.nextInt();

    System.out.println("Enter the number of new Gas Stations you want to add");
    int k=s.nextInt();

    System.out.println("The minimum possible maximum distance is "+minMaxDistance(stations, k));
    s.close();
  }
}