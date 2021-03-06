package stacks;

import java.util.Stack;

/**
 * Program to evaluate postfix expression
 */
public class PostfixEvaluation {
  
  /**
   * Evaluate postfix expression and print it
   * 
   * @param expression postfix string
   */
  private static void evaluatePostfix(String expression) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);
      if (ch == ' ') {
        continue;
      }
      // if the scanned character is an operand (number here), extract the number and push it to the
      // stack
      else if (Character.isDigit(ch)) {
        int num = 0;
        // extract the characters and store it in num
        while (Character.isDigit(ch)) {
          num = num * 10 + (ch - '0');
          i++;
          // update character
          ch = expression.charAt(i);
        }
        stack.push(num);
      }
      // if the scanned character is an operator, pop two elements from the stack and apply the
      // operator
      else {
        int operand2 = stack.pop();
        int operand1 = stack.pop();
        stack.push(performOperation(ch, operand1, operand2));
      }
    }
    System.out.println("Result for expression " + expression + " = " + stack.pop());
  }
  
  /**
   * Performs the operation on two given operands
   * 
   * @param ch operator
   * @param operand1
   * @param operand2
   * @return
   */
  private static int performOperation(char ch, int operand1, int operand2) {
    switch (ch) {
      case '*':
        return operand1 * operand2;
      case '/':
        return operand1 / operand2;
      case '+':
        return operand1 + operand2;
      case '-':
        return operand1 - operand2;
    }
    return -1;
  }
  
  public static void main(String[] args) {
    String[] expressions =
        {"2 3 1 * + 9 -", " 5 3 + 6 2 / * 3 5 * +", "5 10 2 * + 3 -", "100 200 + 2 / 5 * 7 +"};
    for (String expression : expressions) {
      evaluatePostfix(expression);
    }
  }
}
