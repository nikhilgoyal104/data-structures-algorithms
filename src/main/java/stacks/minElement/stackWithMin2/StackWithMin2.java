package stacks.minElement.stackWithMin2;

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
  // this variable keeps track of the minimum value at each node
  int min;
  Node next;
  
  Node(int data) {
    this.data = data;
  }
}


class Stack implements IStack {
  
  private Node top;
  private int size;
  
  // equivalent to insertAtBeginning in a linkedList
  @Override
  public void push(int data) {
    Node node = new Node(data);
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
    Node temp = top;
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
public class StackWithMin2 {
  
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(5);
    stack.push(6);
    stack.push(4);
    stack.push(-3);
    stack.push(8);
    stack.push(9);
    System.out.println("Min = " + stack.getMin());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println("Min = " + stack.getMin());
    
  }
}


