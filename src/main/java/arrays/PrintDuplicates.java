package arrays;

import java.util.Arrays;

// Given an array of n elements which contains elements from 0 to n-1, with any of these numbers
// appearing any number of times. Find these repeating numbers in O(n) and using only constant
// memory space. For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1,
// 3 and 6.
public class PrintDuplicates {
  
  private static void printDuplicates(int[] input) {
    int n = input.length;
    // if x % y = r then 0 <= r <= y-1, therefore 0 < = index < = n-1
    // if x % y =r then (x+y)%y = r, therefore we can add n to the element
    for (int i = 0; i < n; i++) {
      input[input[i] % n] += n;
    }
    // input array after marking the elements
    System.out.println(Arrays.toString(input));
    for (int i = 0; i < n; i++) {
      if (input[i] / n > 1) {
        System.out.print(i + " ");
      }
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    int[][] inputs = {{0, 4, 3, 2, 7, 8, 2, 3, 1}, {1, 2, 3, 1, 3, 6, 6}, {1, 3, 0, 2}};
    for (int[] input : inputs) {
      printDuplicates(input);
    }
  }
}
