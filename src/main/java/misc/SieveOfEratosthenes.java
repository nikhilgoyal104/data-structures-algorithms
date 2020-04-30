package misc;

import java.util.HashMap;
import java.util.Map;

// Find all prime numbers less than or equal to n
public class SieveOfEratosthenes {
  
  public static void main(String[] args) {
    int n = 30;
    Map<Integer, Boolean> result = new HashMap<>();
    for (int i = 2; i <= n; i++) {
      result.put(i, true);
    }
    for (int i = 2; i <= n; i++) {
      // if i is not crossed out then cross out all multiples of i after i
      if (result.get(i)) {
        for (int j = 2 * i; j <= n; j = j + i) { // first multiple of i = 2*i
          result.put(j, false);
        }
      }
    }
    // print the prime numbers
    result.forEach((key, value) -> {
      if (value) {
        System.out.print(key + " ");
      }
    });
    System.out.println();
  }
}
