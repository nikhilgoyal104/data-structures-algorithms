package stacks;

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


// time complexities => push = O(1), pop = O(n) (when minimum element is popped), getMin = O(1).
// space complexity = S(1).
class Stack1 implements IStack {
  
  private Node top;
  private int size;
  private int min = Integer.MAX_VALUE; // this variable keeps track of the minimum value
  
  // equivalent to insertAtBeginning in a linked list
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
  
  // equivalent to deleteFirst in a linked list
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
  
  // equivalent to getFirst in a linked list
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


// time complexities => push = O(1), pop = O(1), getMin = O(1). space complexity = S(n).
class Stack2 implements IStack {
  
  private Node top;
  private int size;
  final private java.util.Stack<Integer> minStack = new java.util.Stack<>();
  
  // equivalent to insertAtBeginning in a linked list
  @Override
  public void push(int data) {
    Node node = new Node(data);
    if (data < getMin()) {
      minStack.push(Math.min(data, getMin()));
    }
    node.next = top;
    top = node;
    size++;
  }
  
  // equivalent to deleteFirst in a linked list
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
    if (isEmpty()) {
      return Integer.MAX_VALUE;
    }
    return minStack.peek();
  }
}


class NodeWithMin {
  int data;
  int min; // this variable keeps track of the minimum value at each node
  NodeWithMin next;
  
  NodeWithMin(int data, int min) {
    this.data = data;
    this.min = min;
  }
}


// time complexities => push = O(1), pop = O(1), getMin = O(1). space complexity = S(1).
class Stack3 implements IStack {
  
  private NodeWithMin top;
  private int size;
  
  // equivalent to insertAtBeginning in a linked list
  @Override
  public void push(int data) {
    int newMin = Math.min(data, getMin());
    NodeWithMin node = new NodeWithMin(data, newMin);
    node.next = top;
    top = node;
    size++;
  }
  
  // equivalent to deleteFirst in a linked list
  @Override
  public int pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    int data = top.data;
    top = top.next;
    size--;
    return data;
  }
  
  // equivalent to getFirst in a linked list
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
    NodeWithMin temp = top;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }
  
  @Override
  public int getMin() {
    if (isEmpty()) {
      return Integer.MAX_VALUE;
    }
    return top.min;
  }
}


// time complexities => push = O(1), pop = O(1), getMin = O(1). space complexity = S(1).
class Stack4 extends java.util.Stack<Integer> {
  
  private final java.util.Stack<Integer> minStack = new java.util.Stack<>();
  
  public void push(int data) {
    if (data < getMin()) {
      minStack.push(Math.min(data, getMin()));
    }
    super.push(data);
  }
  
  public Integer pop() {
    int data = super.pop();
    if (data == minStack.peek()) {
      minStack.pop();
    }
    return data;
  }
  
  public Integer getMin() {
    if (minStack.isEmpty()) {
      return Integer.MAX_VALUE;
    }
    return minStack.peek();
  }
}


class StackItem {
  int data, min;
  
  StackItem(int data, int min) {
    this.data = data;
    this.min = min;
  }
}


// time complexities => push = O(1), pop = O(1), getMin = O(1). space complexity = S(1).
class Stack5 extends java.util.Stack<StackItem> {
  
  public void push(int data) {
    int newMin = Math.min(data, getMin());
    super.push(new StackItem(data, newMin));
  }
  
  public StackItem pop() {
    return super.pop();
  }
  
  public Integer getMin() {
    if (this.isEmpty()) {
      return Integer.MAX_VALUE;
    }
    return super.peek().min;
  }
}


public class StackWithMin {
  
  public static void main(String[] args) {
    Stack1 stack = new Stack1();
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


