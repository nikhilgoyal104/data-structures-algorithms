package misc;

public class NumberIsPalindrome1 {
  
  public static void main(String[] args) {
    int num = 12321;
    // convert the number to string
    String s = String.valueOf(num);
    int n = s.length();
    boolean isPalindrome = true;
    for (int i = 0; i < n / 2; i++) {
      // if the corresponding characters at the left and right ends become unequal the given number
      // is not a palindrome
      if (s.charAt(i) != s.charAt((n - 1) - i)) {
        isPalindrome = false;
        break;
      }
    }
    System.out.println(isPalindrome);
  }
}
