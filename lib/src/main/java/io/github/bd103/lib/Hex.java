package io.github.bd103.lib;

import java.util.HashMap;

public class Hex {
  public static HashMap<Character, Integer> keys = new HashMap<Character, Integer>();
  public String og;

  static {
    keys.put('0', 0);
    keys.put('1', 1);
    keys.put('2', 2);
    keys.put('3', 3);
    keys.put('4', 4);
    keys.put('5', 5);
    keys.put('6', 6);
    keys.put('7', 7);
    keys.put('8', 8);
    keys.put('9', 9);
    keys.put('a', 10);
    keys.put('b', 11);
    keys.put('c', 12);
    keys.put('d', 13);
    keys.put('e', 14);
    keys.put('f', 15);
  }

  public Hex(String str) {
    try {
      this.og = makeSafe(str);
    } catch (Exception err) {
      err.printStackTrace();
    }
  }

  public static String makeSafe(String str) throws Exception {
    String res;

    if (str.startsWith("#")) {
      res = str.substring(1);
    } else {
      res = str;
    }

    char[] charArray = res.toCharArray();

    for (char ch : charArray) {
      if (!keys.containsKey(ch)) {
        throw new Exception("Invalid hex string");
      }
    }

    return res.toLowerCase();
  }

  public static int convertChar(char letter) {
    return keys.get(letter);
  }

  public int toDecimal() {
    int sum = convertChar(this.og.charAt(0));

    if (this.og.length() == 1) {
      return sum;
    }

    char[] charArray = this.og.substring(1).toCharArray();

    for (char i : charArray) {
      sum *= 16;
      sum += convertChar(i);
    }

    return sum;
  }

  public static void main(String[] args) {
    Hex x = new Hex("0e");

    System.out.println(x.toDecimal());
  }
}