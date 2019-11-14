package stacks.minElement.stackWithMin5;


class Object {
  int data;
  int min;
  
  Object(int data) {
    this.data = data;
  }
}


// here we use Stack class for Stack implementation
class Stack extends java.util.Stack<Object> {
  
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


public class StackWithMin5 {
  
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(5);
    stack.push(6);
    stack.push(4);
    stack.push(1);
    stack.push(10);
    stack.push(11);
    System.out.println("Min = " + stack.getMin());
    stack.pop();
    stack.pop();
    stack.pop();
    System.out.println("Min = " + stack.getMin());
  }
  
}
