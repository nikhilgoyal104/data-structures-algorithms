package stacks;

import java.util.Arrays;
import java.util.NoSuchElementException;

interface IDynamicStack {
  
  void push(int data);
  
  int pop();
  
  int peek();
  
  boolean isFull();
  
  boolean isEmpty();
  
  void print();
  
  int size();
}


class DynamicStack implements IDynamicStack {
  
  private int[] nums;
  private int top = -1;
  private int capacity;
  private int size;
  private static final int DEFAULT_CAPACITY = 5;
  
  DynamicStack() {
    this.capacity = DEFAULT_CAPACITY;
    this.nums = new int[DEFAULT_CAPACITY];
  }
  
  DynamicStack(int capacity) {
    this.capacity = capacity;
    this.nums = new int[capacity];
  }
  
  @Override
  public void push(int data) {
    if (isFull()) {
      System.out.println("Doubling capacity since the stack is full");
      increaseCapacity();
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
    int data = nums[top--];
    // check if we can free up extra memory space when popping out
    if (isShrinkable()) {
      System.out.println("Halving capacity to free up extra space");
      shrink();
    }
    return data;
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
  
  private void increaseCapacity() {
    capacity *= 2;
    nums = Arrays.copyOf(nums, capacity);
  }
  
  private void shrink() {
    capacity /= 2;
    nums = Arrays.copyOf(nums, capacity);
  }
  
  private boolean isShrinkable() {
    return size <= capacity / 2;
  }
}


public class StackUsingDynamicArray {
  
  public static void main(String[] args) {
    DynamicStack stack = new DynamicStack(5);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.print();
    stack.push(6);
    stack.print();
    System.out.println(stack.pop());
    stack.print();
  }
}
