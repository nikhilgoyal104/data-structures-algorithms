package stacks.minElement.stackWithMin1;

import java.util.NoSuchElementException;

interface IStack {
  
  void push(int data);
  
  int pop();
  
  int peek();
  
  boolean isEmpty();
  
  void print();
  
  int size();
  
  int getMin();
}


class Node {
  
  int data;
  Node next;
  
  Node(int data) {
    this.data = data;
  }
}


class Stack implements IStack {
  
  private Node top;
  private int size;
  // this variable keeps track of the minimum value in the stack
  private int min = Integer.MAX_VALUE;
  
  // equivalent to insertAtBeginning in a linkedList
  @Override
  public void push(int data) {
    Node node = new Node(data);
    node.next = top;
    top = node;
    if (data < min) {
      // update min
      min = data;
    }
    size++;
  }
  
  // equivalent to deleteFirst in a linkedList
  @Override
  public int pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    int data = top.data;
    top = top.next;
    // if element to be popped is equal to the minimum element
    if (data == min) {
      // update min
      min = calculateNewMin();
    }
    size--;
    return data;
  }
  
  // equivalent to getFirst in a linkedList
  @Override
  public int peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    return top.data;
  }
  
  @Override
  public int size() {
    return size;
  }
  
  @Override
  public boolean isEmpty() {
    return top == null;
  }
  
  @Override
  public void print() {
    Node temp = top;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }
  
  @Override
  public int getMin() {
    return min;
  }
  
  private int calculateNewMin() {
    Node temp = top;
    min = temp.data;
    while (temp != null) {
      if (temp.data < min) {
        // update min
        min = temp.data;
      }
      temp = temp.next;
    }
    return min;
  }
}


// push = O(1) pop = O(n) ( when minimum element is popped ) getMin = O(1) space complexity = S(1)
public class StackWithMin1 {
  
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(5);
    stack.push(6);
    stack.push(4);
    stack.push(3);
    stack.push(7);
    stack.push(8);
    System.out.println("Min = " + stack.getMin());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println("Min = " + stack.getMin());
  }
}


