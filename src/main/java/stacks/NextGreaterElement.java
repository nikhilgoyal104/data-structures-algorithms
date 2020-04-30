package stacks;

import java.util.Arrays;
import java.util.Stack;

// next greater element for an element x is the first greater element on the right side of x
public class NextGreaterElement {
  
  private static void calculateNgeUsingBruteForce(int[] input) {
    int n = input.length;
    int[] nge = new int[n];
    for (int current = 0; current < n; current++) {
      int next = current + 1;
      while (next < n && input[next] <= input[current]) {
        next++;
      }
      nge[current] = next == n ? -1 : input[next];
    }
    System.out.println("Nge for input " + Arrays.toString(input) + " is = " + Arrays.toString(nge));
  }
  
  private static void calculateNgeUsingStack(int[] input) {
    int n = input.length;
    int[] nge = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int current = n - 1; current >= 0; current--) {
      // keep on popping until the stack is empty or there is a greater element on right
      while (!stack.isEmpty() && stack.peek() <= input[current]) {
        stack.pop();
      }
      nge[current] = !stack.isEmpty() ? input[stack.peek()] : -1;
      stack.push(input[current]);
    }
    System.out.println("Nge for input " + Arrays.toString(input) + " is = " + Arrays.toString(nge));
  }
  
  public static void main(String[] args) {
    int[][] inputs = {{4, 5, 2, 25}, {13, 7, 6, 12}, {11, 13, 21, 3}, {4, 5, 2, 25, 7, 32, 8, 6}};
    for (int[] input : inputs) {
      calculateNgeUsingBruteForce(input);
      calculateNgeUsingStack(input);
    }
  }
}
