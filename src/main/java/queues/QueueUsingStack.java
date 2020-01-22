package queues;

import java.util.Stack;

// two stacks push = O(n), pop = O(1)
class QueueUsingStack1 {
  
  private Stack<Integer> stack1 = new Stack<>();
  private Stack<Integer> stack2 = new Stack<>();
  
  public void add(int data) {
    // the newest element must be pushed to the bottom of stack1
    // empty stack1 into stack2
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
    // push the new element to stack1
    stack1.push(data);
    // now empty stack2 into stack1
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }
  }
  
  public Integer poll() {
    if (stack1.isEmpty()) {
      return null;
    }
    return stack1.pop();
  }
}


// two stacks push = O(1), pop = amortized O(1)
class QueueUsingStack2 {
  
  private Stack<Integer> stack1 = new Stack<>();
  private Stack<Integer> stack2 = new Stack<>();
  
  public void add(int data) {
    stack1.push(data);
  }
  
  public Integer poll() {
    if (stack1.isEmpty() && stack2.isEmpty()) {
      return null;
    }
    if (stack2.isEmpty()) {
      // empty stack1 into stack2
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }
}


class QueueUsingStack {
  // Driver method
  public static void main(String[] args) {
    QueueUsingStack1 queue = new QueueUsingStack1();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    queue.add(4);
    queue.add(5);
    queue.add(6);
    System.out.println(queue.poll());
  }
}
