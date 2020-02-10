package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueUsingStack {
  
  private Queue<Integer> reverse(Queue<Integer> queue) {
    Stack<Integer> stack = new Stack<>();
    // empty queue into stack
    while (!queue.isEmpty()) {
      stack.push(queue.poll());
    }
    // empty stack back into queue
    while (!stack.isEmpty()) {
      queue.add(stack.pop());
    }
    return queue;
  }
  
  public static void main(String[] args) {
    ReverseQueueUsingStack reverseQueueUsingStack = new ReverseQueueUsingStack();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(10);
    queue.add(20);
    queue.add(15);
    queue.add(42);
    System.out.println(queue);
    System.out.println(reverseQueueUsingStack.reverse(queue));
  }
}
