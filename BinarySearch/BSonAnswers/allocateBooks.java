package BinarySearch.BSonAnswers;

import java.util.Scanner;

public class allocateBooks {
  static int countStudents(int books[], int limit) {
    int students=1, pages=0;
    
    for(int book: books) {
      if(book+pages <= limit)
        pages+=book;

      else {
        students++;
        pages=book;
      }
    }
    return students;
  }
  static int maxMinPages(int books[], int m) {
    if(m > books.length)
      return -1;

    int low=Integer.MIN_VALUE, mid, high=0;

    for(int book: books) {
      low=Math.max(low, book);
      high+=book;
    }

    while(low <= high) {
      mid=low+(high-low)/2;

      int students=countStudents(books, mid);

      if(students <= m)
        high=mid-1;

      else low=mid+1;
    }
    return low;
  }
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Enter the number of books");
    int n=s.nextInt(), books[]=new int[n], i;

    System.out.println("Enter the number of pages for each book");
    for(i=0; i<n; i++)
      books[i]=s.nextInt();

    System.out.println("Enter the number of Students:");
    int m=s.nextInt();

    System.out.println("The maximum possible minimum pages are: "+maxMinPages(books, m));
    s.close();
  }
}