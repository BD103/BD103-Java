package io.github.bd103.lib.shared;

import java.util.Arrays;

class ColorHex {
  public String og;

  public int red;
  public int green;
  public int blue;

  public ColorHex(String str) {
    try {
      this.og = Hex.makeSafe(str);
    } catch (Exception err) {
      err.printStackTrace();
    }

    this.convert();
  }

  private void convert() {
    if (this.og.length() == 3) {
      this.red = new Hex(Character.toString(this.og.charAt(0))).toDecimal() * 16;
      this.green = new Hex(Character.toString(this.og.charAt(1))).toDecimal() * 16;
      this.blue = new Hex(Character.toString(this.og.charAt(2))).toDecimal() * 16;
    } else if (this.og.length() == 6) {
      this.red = new Hex(this.og.substring(0, 2)).toDecimal();
      this.green = new Hex(this.og.substring(2, 4)).toDecimal();
      this.blue = new Hex(this.og.substring(4, 6)).toDecimal();
    }
  }

  public int[] toRgb() {
    this.convert();

    return new int[] {this.red, this.green, this.blue};
  }

  public static void main(String[] args) {
    ColorHex x = new ColorHex("#feffff");
    System.out.println(Arrays.toString(x.toRgb()));
  }
}