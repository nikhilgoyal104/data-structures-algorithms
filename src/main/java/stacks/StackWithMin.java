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


class Node1 {
  
  int data;
  Node1 next;
  
  Node1(int data) {
    this.data = data;
  }
}


// push = O(1) pop = O(n) ( when minimum element is popped ) getMin = O(1) space complexity = S(1)
class Stack1 implements IStack {
  
  private Node1 top;
  private int size;
  // this variable keeps track of the minimum value in the stack
  private int min = Integer.MAX_VALUE;
  
  // equivalent to insertAtBeginning in a linkedList
  @Override
  public void push(int data) {
    Node1 node = new Node1(data);
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
    Node1 temp = top;
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
    Node1 temp = top;
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


class Node2 {
  
  int data;
  // this variable keeps track of the minimum value at each node
  int min;
  Node2 next;
  
  Node2(int data) {
    this.data = data;
  }
}


// push = O(1) pop = O(1) getMin = O(1) space complexity = S(n)
class Stack2 implements IStack {
  
  private Node2 top;
  private int size;
  
  // equivalent to insertAtBeginning in a linkedList
  @Override
  public void push(int data) {
    Node2 node = new Node2(data);
    if (isEmpty()) {
      node.min = data;
    } else {
      node.min = Math.min(data, top.min);
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
    Node2 temp = top;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }
  
  @Override
  public int getMin() {
    return top.min;
  }
}


// push = O(1) pop = O(1) getMin = O(1) space complexity = S(n)
class Stack3 implements IStack {
  
  private Node1 top;
  private int size;
  private java.util.Stack<Integer> minStack = new java.util.Stack<>();
  
  // equivalent to insertAtBeginning in a linkedList
  @Override
  public void push(int data) {
    Node1 node = new Node1(data);
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
    Node1 temp = top;
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


// here we use Stack class for Stack implementation
class Stack4 extends java.util.Stack<Integer> {
  
  private java.util.Stack<Integer> minStack = new java.util.Stack<>();
  
  void push(int data) {
    if (isEmpty()) {
      minStack.push(data);
    } else if (data < minStack.peek()) {
      minStack.push(data);
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
  
  Integer getMin() {
    return minStack.peek();
  }
}


class Object {
  int data;
  int min;
  
  Object(int data) {
    this.data = data;
  }
}


// here we use Stack class for Stack implementation
class Stack5 extends java.util.Stack<Object> {
  
  void push(int data) {
    Object object = new Object(data);
    if (isEmpty()) {
      object.min = data;
    } else {
      object.min = Math.min(data, peek().min);
    }
    super.push(object);
  }
  
  public Object pop() {
    return super.pop();
  }
  
  Integer getMin() {
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


