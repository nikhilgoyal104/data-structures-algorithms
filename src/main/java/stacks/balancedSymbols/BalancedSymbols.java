package stacks.balancedSymbols;

import java.util.Stack;

public class BalancedSymbols {
  
  private static boolean isBalanced1(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char incomingCharacter = s.charAt(i);
      if (stack.isEmpty()) {
        stack.push(incomingCharacter);
      } else {
        if (isMatchingPair(stack.peek(), incomingCharacter)) {
          stack.pop();
        } else {
          stack.push(incomingCharacter);
        }
      }
    }
    return stack.isEmpty();
  }
  
  
  private static boolean isBalanced2(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char incomingCharacter = s.charAt(i);
      // if stack is empty or the pair does not match
      if (stack.isEmpty() || !isMatchingPair(stack.peek(), incomingCharacter)) {
        stack.push(incomingCharacter);
      } else {
        stack.pop();
      }
    }
    return stack.isEmpty();
  }
  
  private static boolean isMatchingPair(char top, char incomingCharacter) {
    return (top == '[' && incomingCharacter == ']') || (top == '{' && incomingCharacter == '}')
        || (top == '(' && incomingCharacter == ')');
  }
  
  public static void main(String[] args) {
    String[] input =
        {"", "[]", "[[][]]", "[()]{}{[()()]()}", "{{([][])}()}", ")(", "[(])", "([)]", "[{()]"};
    for (String s : input) {
      System.out.println(s + " -> " + isBalanced1(s));
    }
    System.out.println();
    for (String s : input) {
      System.out.println(s + " -> " + isBalanced2(s));
    }
  }
}
