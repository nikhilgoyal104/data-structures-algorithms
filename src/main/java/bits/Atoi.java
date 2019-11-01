package bits;

public class Atoi {
  
  // private static String s = "987 362";
  // private static String s = "+3269";
  // private static String s = "3724A96";
  private static String s = "-736 4";
  
  public static void main(String[] args) {
    System.out.println(atoi(s));
  }
  
  private static int atoi(String s) {
    int result = 0, startIndex = 0, sign = 1;
    char firstCharacter = s.charAt(0);
    // handle negative number
    if (isNegativeNumber(firstCharacter)) {
      startIndex++;
      sign = -1;
    }
    if (startsWithPlusSign(firstCharacter)) {
      startIndex++;
    }
    for (int i = startIndex; i < s.length(); i++) {
      char ch = s.charAt(i);
      // if any of the character is not numeric then stop the iteration
      if (!isNumericCharacter(ch)) {
        break;
      }
      // integer digit = (ch - '0')
      result = result * 10 + (ch - '0');
    }
    return sign * result;
  }
  
  private static boolean isNumericCharacter(char ch) {
    // we can also do return (int)ch>=48 && (int)ch<=57;
    return ch >= '0' && ch <= '9';
  }
  
  private static boolean isNegativeNumber(char ch) {
    return ch == '-';
  }
  
  private static boolean startsWithPlusSign(char ch) {
    return ch == '+';
  }
}
