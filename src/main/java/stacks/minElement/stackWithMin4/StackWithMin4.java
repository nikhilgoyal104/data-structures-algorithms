package stacks.minElement.stackWithMin4;


// here we use Stack class for Stack implementation
class Stack extends java.util.Stack<Integer> {
  
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


public class StackWithMin4 {
  
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(5);
    stack.push(6);
    stack.push(4);
    stack.push(2);
    stack.push(8);
    stack.push(10);
    System.out.println("Min = " + stack.getMin());
    stack.pop();
    stack.pop();
    stack.pop();
    System.out.println("Min = " + stack.getMin());
  }
}
