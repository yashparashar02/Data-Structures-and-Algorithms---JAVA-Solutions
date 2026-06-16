package Hashing.HashMap;

import java.util.LinkedHashSet;

public class linkedHashSetDemo {
  public static void main(String[] args) {
    LinkedHashSet<Integer> set=new LinkedHashSet<>();
    set.add(15);
    set.add(19);
    set.add(2);
    set.add(24);
    set.add(15);
    System.out.println(set);
  }
}
