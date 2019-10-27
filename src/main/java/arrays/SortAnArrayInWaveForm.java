package arrays;

import java.util.Arrays;

public class SortAnArrayInWaveForm {
  
  // private static int[] a = {1, 2, 3};
  // private static int[] a = {3, 6, 5, 10, 7, 20};
  private static int[] a = {10, 90, 49, 2, 1, 5, 23};
  // private static int[] a = {10, 5, 6, 3, 2, 20, 100, 80};
  // private static int[] a = {20, 10, 8, 6, 4, 2};
  // private static int[] a = {2, 4, 6, 8, 10, 20};
  
  public static void main(String[] args) {
    int n = a.length;
    for (int i = 1; i < n - 1; i++) {
      int current = a[i];
      int previous = a[i - 1];
      int next = a[i + 1];
      // we take three elements at a time and check for the two conditions when the three elements
      // will not form a wave
      if ((current > previous && next > current) || (current < previous && next < current)) {
        swap(i, i + 1);
      }
    }
    System.out.println(Arrays.toString(a));
  }
  
  private static void swap(int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
