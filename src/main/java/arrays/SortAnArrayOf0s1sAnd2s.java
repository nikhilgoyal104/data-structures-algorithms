package arrays;

import java.util.Arrays;

public class SortAnArrayOf0s1sAnd2s {
  
  private static int[] a = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
  
  public static void main(String[] args) {
    int n = a.length;
    int p1 = 0, p2 = 0, p3 = n - 1;
    while (p2 <= p3) {
      switch (a[p2]) {
        case 0:
          swap(p1++, p2++);
          break;
        case 1:
          p2++;
          break;
        case 2:
          swap(p2, p3--);
          break;
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
