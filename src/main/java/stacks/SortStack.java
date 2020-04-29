package stacks;

import java.util.Stack;

import lombok.Data;

@Data
public class SortStack {
  
  // O(nxn) S(n)
  private static Stack<Integer> sortIteratively(Stack<Integer> s1) {
    Stack<Integer> s2 = new Stack<>();
    Stack<Integer> s3 = new Stack<>();
    // concept: insert all elements of input stack s1 into s2 in sorted order where s2 is already
    // sorted since it is empty. the elements will be inserted into s2 in sorted order using s3
    // this algorithm uses two stacks to sort a collection of items
    while (!s1.isEmpty()) {
      int element = s1.pop();
      while (!s2.isEmpty() && s2.peek() > element) {
        s3.push(s2.pop());
      }
      s2.push(element); // s2.isEmpty() || element > s2.peek()
      // empty s3 into s2
      while (!s3.isEmpty()) {
        s2.push(s3.pop());
      }
    }
    return s2;
  }
  
  // O(nxn) S(n)
  private static Stack<Integer> sortRecursively(Stack<Integer> s1) {
    // the idea of the solution is to hold all values in function call stack until the stack becomes
    // empty. when the stack becomes empty, insert all held items one by one in sorted order
    if (!s1.isEmpty()) {
      int top = s1.pop();
      sortRecursively(s1);
      insertInSortedOrder(s1, top);
    }
    return s1;
  }
  
  private static void insertInSortedOrder(Stack<Integer> s2, int element) {
    if (s2.isEmpty() || element > s2.peek()) {
      s2.push(element);
      return;
    }
    int top = s2.pop();
    insertInSortedOrder(s2, element);
    s2.push(top);
  }
  
  public static void main(String[] args) {
    Stack<Integer> s1 = new Stack<>();
    s1.push(5);
    s1.push(7);
    s1.push(3);
    s1.push(9);
    s1.push(1);
    System.out.println("Original Stack " + s1);
    // System.out.println("Sorted Stack " + sortIteratively(s1));
    System.out.println("Sorted Stack " + sortRecursively(s1));
    System.out.println();
  }
}
