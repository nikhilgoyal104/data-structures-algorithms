package stacks;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
  
  private static void calculateSpanUsingBruteForce(int[] price) {
    int n = price.length;
    int[] span = new int[n];
    span[0] = 1;
    for (int current = 1; current < n; current++) {
      int left = current - 1;
      int currentSpan = 1;
      // iterate until we find the first greater element on left of current
      // => price[left] <= price[current]
      while (left >= 0 && price[left] <= price[current]) {
        currentSpan++;
        left--;
      }
      span[current] = currentSpan;
    }
    System.out.println(Arrays.toString(span));
  }
  
  private static void calculateSpanUsingStack(int[] price) {
    int[] span = new int[price.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < price.length; i++) {
      // keep on popping until the stack is empty or there is a greater element on left
      while (!stack.empty() && price[stack.peek()] <= price[i]) {
        stack.pop();
      }
      span[i] = !stack.isEmpty() ? i - stack.peek() : i + 1;
      stack.push(i);
    }
    System.out.println(Arrays.toString(span));
  }
  
  public static void main(String[] args) {
    int[][] prices =
        {{100, 80, 60, 70, 60, 75, 85}, {10, 4, 5, 90, 120, 80}, {100, 60, 70, 65, 80, 85},
            {31, 27, 14, 21, 30, 22}, {22, 20, 17, 15, 10}, {10, 15, 17, 20, 22}};
    for (int[] price : prices) {
      calculateSpanUsingBruteForce(price);
      calculateSpanUsingStack(price);
    }
  }
}
