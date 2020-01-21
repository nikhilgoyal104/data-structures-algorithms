package stacks;

import java.util.Stack;

// Class to convert infix to postfix
public class InfixToPostfix {
  
  // The main method that converts the given infix expression
  // to postfix expression
  private StringBuilder infixToPostfix(String expression) {
    // initializing empty StringBuilder for result
    StringBuilder result = new StringBuilder();
    // initializing empty stack
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        result.append(ch);
      } else if (ch == '(') {
        stack.push(ch);
      } else if (ch == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          result.append(stack.pop());
        }
        // pop the opening bracket '(' since we have evaluated the enclosed expression
        stack.pop();
      }
      // if the scanned character is an ')', pop and output from the stack
      // until an '(' is encountered.
      else {
        // stack will always have operators in increasing order of precedence therefore when an
        // operator of lower precedence comes we take out all the operators of higher precedence
        // from the stack and then push it
        while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
          result.append(stack.pop());
        }
        
        stack.push(ch);
      }
    }
    // pop the leftovers and add them to the result
    while (!stack.isEmpty()) {
      result.append(stack.pop());
    }
    return result;
  }
  
  // A utility function to return the precedence of a given operator
  // Higher returned value means higher precedence
  private static int precedence(char ch) {
    switch (ch) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
    }
    return -1;
  }
  
  // Driver method
  public static void main(String[] args) {
    String[] expressions =
        {"A+B*C-D*E", "((A+B)*C-D)*E", "a+b*(c^d-e)^(f+g*h)-i", "A*(B+C)", "(A+B)+(C-D)"};
    for (String expression : expressions) {
      System.out.println("Postfix for expression " + expression + " = "
          + new InfixToPostfix().infixToPostfix(expression));
    }
  }
}
