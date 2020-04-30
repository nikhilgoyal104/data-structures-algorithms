package stacks.stackUsingLinkedList;

import java.util.NoSuchElementException;

interface IStack {
  
  void push(int data);
  
  int pop();
  
  int peek();
  
  boolean isEmpty();
  
  void print();
  
  int size();
}


class Node {
  
  int data;
  Node next;
  
  Node(int data) {
    this.data = data;
  }
}

// time complexities => push = O(1), pop = O(1)
class Stack implements IStack {
  
  private Node top;
  private int size;
  
  // equivalent to insertAtBeginning in a linkedList
  @Override
  public void push(int data) {
    Node node = new Node(data);
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
}


public class StackUsingLinkedList {
  
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.print();
    System.out.println(stack.pop());
    stack.print();
  }
}
