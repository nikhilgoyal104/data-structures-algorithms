package misc;

// Check if a given number is palindrome or not with constant space
public class NumberIsPalindrome2 {
  
  public static void main(String[] args) {
    int num = 12321;
    boolean isPalindrome = true;
    while (num > 0) {
      // number of digits in num = Math.log10(num)
      int divisor = (int) Math.pow(10, (int) Math.log10(num));
      // get first digit
      int firstDigit = (num / divisor);
      // get last digit
      int lastDigit = (num % 10);
      if (firstDigit != lastDigit) {
        isPalindrome = false;
        break;
      }
      // remove first digit
      num = (num % divisor);
      // remove last digit
      num = (num / 10);
    }
    System.out.println(isPalindrome);
  }
}
