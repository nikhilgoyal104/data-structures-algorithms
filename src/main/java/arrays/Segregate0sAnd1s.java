package arrays;

import java.util.Arrays;

public class Segregate0sAnd1s {
  
  // private static int[] a = {0, 1, 0, 1, 0, 0, 1, 1, 1};
  private static int[] a = {0, 1, 0, 1, 1, 1};
  
  public static void main(String[] args) {
    int n = a.length;
    int p1 = 0, p2 = n - 1;
    while (p1 < p2) {
      // if value at left pointer is 1 and right pointer is 0 then swap them
      if (a[p1] == 1 && a[p2] == 0) {
        swap(p1, p2);
      }
      // until we find a 0 keep decrementing right pointer
      while (a[p2] != 0) {
        p2--;
      }
      // until we find a 1 keep incrementing left pointer
      while (a[p1] != 1) {
        p1++;
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
