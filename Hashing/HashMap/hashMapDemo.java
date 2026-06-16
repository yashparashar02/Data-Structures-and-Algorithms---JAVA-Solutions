package Hashing.HashMap;

import java.util.HashMap;

public class hashMapDemo {
  public static void main(String[] args) {
    HashMap<Integer, String> map=new HashMap<>();
    map.put(1,"Java");
    map.put(2, "C++");
    map.put(3, "Python");
    System.out.println(map.get(2));
  }
}