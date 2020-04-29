package stacks;

import java.util.Stack;

import lombok.Data;

@Data
public class InsertInSortedOrder {
  
  // O(n) S(n)
  private static Stack<Integer> insertInSortedOrderIteratively(Stack<Integer> s1, int element) {
    Stack<Integer> s2 = new Stack<>();
    // while s1 is not empty and top of s1 is greater than incoming element pop from s1 and store it
    // in s2
    while (!s1.isEmpty() && s1.peek() > element) {
      s2.push(s1.pop());
    }
    // insert the incoming element into s1
    s1.push(element); // s1.isEmpty() || element > s1.peek()
    // empty s2 into s1
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
    return s1;
  }
  
  // O(n) S(n)
  private static Stack<Integer> insertInSortedOrderRecursively(Stack<Integer> s1, int element) {
    if (s1.isEmpty() || element > s1.peek()) {
      s1.push(element);
      return s1;
    }
    int top = s1.pop();
    insertInSortedOrderRecursively(s1, element);
    s1.push(top);
    return s1;
  }
  
  public static void main(String[] args) {
    Stack<Integer> s1 = new Stack<>();
    s1.push(4);
    s1.push(7);
    s1.push(12);
    s1.push(42);
    // System.out.println(insertInSortedOrderIteratively(s1, 9));
    // System.out.println(insertInSortedOrderIteratively(s1, 1));
    // System.out.println(insertInSortedOrderIteratively(s1, 65));
    System.out.println(insertInSortedOrderRecursively(s1, 9));
    System.out.println(insertInSortedOrderRecursively(s1, 1));
    System.out.println(insertInSortedOrderRecursively(s1, 65));
  }
}
