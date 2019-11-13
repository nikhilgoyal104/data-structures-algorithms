package stacks.stackUsingArray;

import java.util.NoSuchElementException;

interface IStack {
  
  void push(int data);
  
  int pop();
  
  int peek();
  
  boolean isFull();
  
  boolean isEmpty();
  
  void print();
  
  int size();
}


class Stack implements IStack {
  
  private int[] nums;
  private int top = -1;
  private int capacity;
  private int size;
  private static final int DEFAULT_CAPACITY = 5;
  
  Stack() {
    this.capacity = DEFAULT_CAPACITY;
    this.nums = new int[DEFAULT_CAPACITY];
  }
  
  Stack(int capacity) {
    this.capacity = capacity;
    this.nums = new int[capacity];
  }
  
  @Override
  public void push(int data) {
    if (isFull()) {
      throw new IllegalStateException("Stack is already full");
    }
    nums[++top] = data;
    size++;
  }
  
  @Override
  public int pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    size--;
    return nums[top--];
  }
  
  @Override
  public int peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    return nums[top];
  }
  
  @Override
  public boolean isFull() {
    return size == capacity;
  }
  
  @Override
  public boolean isEmpty() {
    return size == 0;
  }
  
  @Override
  public void print() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    for (int i = 0; i < size; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }
  
  @Override
  public int size() {
    return size;
  }
}


public class StackUsingArray {
  
  public static void main(String[] args) {
    Stack stack = new Stack(5);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.print();
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.size());
    stack.print();
  }
}
