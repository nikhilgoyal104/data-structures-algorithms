package stacks;

import java.util.Arrays;
import java.util.Stack;

public class LargestAreaInHistogram {
  
  private static void calculateMaxAreaUsingBruteForce(int[] histogram) {
    int n = histogram.length;
    int maxArea = Integer.MIN_VALUE;
    for (int current = 0; current < n; current++) {
      int area = histogram[current];
      int left = current - 1;
      int right = current + 1;
      // iterate until we find the first smaller element on left of current
      // => iterate until histogram[left] >= histogram[current]
      while (left >= 0 && histogram[left] >= histogram[current]) {
        area += histogram[current];
        left--;
      }
      // iterate until we find the first smaller element on right of current
      // => iterate until histogram[right] >= histogram[current]
      while (right < n && histogram[right] >= histogram[current]) {
        area += histogram[current];
        right++;
      }
      maxArea = Math.max(area, maxArea);
    }
    System.out.println("Maximum area for " + Arrays.toString(histogram) + " = " + maxArea);
  }
  
  private static void calculateMaxAreaUsingStack(int[] histogram) {
    int n = histogram.length;
    Stack<Integer> stack = new Stack<>();
    int[] width = new int[n];
    Arrays.fill(width, 1);
    for (int current = 0; current < n; current++) {
      // iterate until we find the first smaller element on left of current
      while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[current]) {
        stack.pop();
      }
      width[current] += !stack.isEmpty() ? current - stack.peek() - 1 : current;
      stack.push(current);
    }
    stack.empty();
    for (int current = n - 1; current >= 0; current--) {
      // iterate until we find the first smaller element on right of current
      while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[current]) {
        stack.pop();
      }
      width[current] += !stack.isEmpty() ? stack.peek() - current - 1 : n - 1 - current;
      stack.push(current);
    }
    int maxArea = 0;
    for (int i = 0; i < n; i++) {
      // find the maximum value of all rectangle areas
      maxArea = Math.max(maxArea, width[i] * histogram[i]);
    }
    System.out.println("Maximum area for " + Arrays.toString(histogram) + " = " + maxArea);
  }
  
  public static void main(String[] args) {
    int[][] histograms = {{6, 2, 5, 4, 5, 1, 6}, {2, 1, 5, 6, 2, 3}, {5, 0}, {0, 5}, {7, 9},
        {7, 0, 4}, {7, 9, 4}, {1, 2, 3, 4, 5}, {5, 4, 3, 2, 1}, {10}, {0}};
    for (int[] histogram : histograms) {
      calculateMaxAreaUsingBruteForce(histogram);
      calculateMaxAreaUsingStack(histogram);
    }
  }
}
