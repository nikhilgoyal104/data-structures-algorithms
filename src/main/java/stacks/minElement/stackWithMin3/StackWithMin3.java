package stacks.minElement.stackWithMin3;

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
  private java.util.Stack<Integer> minStack = new java.util.Stack<>();
  
  // equivalent to insertAtBeginning in a linkedList
  @Override
  public void push(int data) {
    Node node = new Node(data);
    if (isEmpty()) {
      minStack.push(data);
    } else if (data < minStack.peek()) {
      minStack.push(data);
    }
    node.next = top;
    top = node;
    size++;
  }
  
  // equivalent to deleteFirst in a linkedList
  @Override
  public int pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    int data = top.data;
    // if element to be popped is equal to the top element of minStack
    if (data == minStack.peek()) {
      minStack.pop();
    }
    top = top.next;
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
    return minStack.peek();
  }
}


// push = O(1) pop = O(1) getMin = O(1) space complexity = S(n)
public class StackWithMin3 {
  
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(5);
    stack.push(6);
    stack.push(4);
    stack.push(-3);
    stack.push(9);
    stack.push(10);
    System.out.println("Min = " + stack.getMin());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println("Min = " + stack.getMin());
  }
}


