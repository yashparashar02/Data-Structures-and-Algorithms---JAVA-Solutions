package Hashing.HashMap;

import java.util.Hashtable;

public class hashtableDemo {
  public static void main(String[] args) {
    Hashtable<Integer,String> table = new Hashtable<>();
    table.put(1, "Java");
    table.put(2, "C++");
    table.put(1, "Python");
    System.out.println(table);
  }
}
