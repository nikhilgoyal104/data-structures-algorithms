package arrays;

import java.util.Arrays;

public class ReverseCharacterArray {
  
  // Do or Die.
  private static char[] s = {'D', 'o', ' ', 'o', 'r', ' ', 'D', 'i', 'e', '.'};
  
  public static void main(String[] args) {
    int n = s.length;
    int p1 = 0, p2;
    for (int i = 0; i < n; i++) {
      if (s[i] == ' ') {
        // end index of current word
        p2 = i - 1;
        // reverse the current word
        reverse(p1, p2);
        // beginning index of next word
        p1 = i + 1;
      }
    }
    // reverse the last word
    reverse(p1, n - 1);
    // reverse the complete string
    reverse(0, n - 1);
    System.out.println(Arrays.toString(s));
  }
  
  private static void reverse(int p1, int p2) {
    while (p1 < p2) {
      swap(p1, p2);
      p1++;
      p2--;
    }
  }
  
  private static void swap(int p1, int p2) {
    char temp = s[p1];
    s[p1] = s[p2];
    s[p2] = temp;
  }
}
