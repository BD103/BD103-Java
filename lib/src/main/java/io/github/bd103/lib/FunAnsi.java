package io.github.bd103.lib;

import java.util.Random;

public class FunAnsi {
  private static final Random rand = new Random();


  public static enum Colors {
    BASIC(new int[]{31, 33, 32, 36, 34, 35}),
    BG(new int[]{41, 43, 42, 46, 44, 45}),
    EX(new int[]{91, 93, 92, 96, 94, 95}),
    BGEX(new int[]{101, 103, 102, 106, 104, 105});

    public final int[] codes;

    private Colors(int[] codes) {
      this.codes = codes;
    }
  }

  public static String makeRainbow(String text, Colors colorEnum) {
    StringBuilder res = new StringBuilder();
    char[] ch = text.toCharArray();
    int index = 0;

    for (char c : ch) {
      if (index == colorEnum.codes.length) {
        index = 0;
      }

      res.append("\u001b[" + colorEnum.codes[index] + "m" + c);

      index++;
    }

    res.append("\u001b[0m");

    return res.toString();
  }

  public static String makeRainbow(String text) {
    return makeRainbow(text, Colors.BASIC);
  }

  public static String makeColorful(String text, Colors colorEnum) {
    return "\u001b[" + colorEnum.codes[rand.nextInt(colorEnum.codes.length)] + "m" + text + "\u001b[0m";
  }

  public static String makeColorful(String text) {
    return makeColorful(text, Colors.BASIC);
  }

  public static void main(String[] args) {
    System.out.println(makeRainbow("This is some colorful text :)"));
    System.out.println(makeColorful("And this colored text changes every time you run the program!"));
  }
}
