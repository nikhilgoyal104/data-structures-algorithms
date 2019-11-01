package bits;

public class Atoi1 {
    
  // private static String s = "-25";
  // private static String s = "25 456";
  private static String s = "25";
  
  public static void main(String[] args) {
    System.out.println(atoi(s));
  }
  
  private static int atoi(String s) {
    int result = 0, startIndex = 0, sign = 1;
    int n = s.length();
    // handle negative number
    if (isNegativeNumber(s.charAt(0))) {
      startIndex++;
      sign = -1;
    }
    for (int i = startIndex; i < n; i++) {
      char ch = s.charAt(i);
      // if any of the character is not numeric then throw Exception
      if (!isNumericCharacter(ch)) {
        throw new NumberFormatException(
            "String is not purely numeric. Hence conversion to integer is not possible.");
      }
      // integer digit = (ch - '0')
      // we can also do result = result * 10 + (ch - '0');
      result += (ch - '0') * Math.pow(10, (n - 1) - i);
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
}
