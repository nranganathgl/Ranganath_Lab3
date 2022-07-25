package com.gl.brackets;

import java.util.Stack;

/**
 * 
 * @author Ranganath
 *
 *         This program is created to print whether the string entered is a
 *         Balanced Brackets or Unbalanced String
 * 
 */
public class BalancingBrackets {

	Stack<Character> stack = new Stack<>();

	/*
	 * This method takes String as input parameter and returns boolean value. It
	 * pushes all open brackets and braces into the stack of type Character. if
	 * stack is empty then it returns false otherwise it compares each closing
	 * bracket or braces in the String with the value retrieved using the pop
	 * operation of the stack then returns false if the stack value is not matching
	 * with closing bracket or parenthesis. If all open and closing brackets and
	 * parenthesis are matching then it returns true.
	 * 
	 */
	boolean isStringBalanced(String input) {
		char charInStack;
		for (int i = 0; i < input.length(); i++) {
			char character = input.charAt(i);
			if (character == '{' || character == '[' || character == '(') {
				// System.out.println("character at position: "+i+" "+character);
				stack.push(character);
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			}

			switch (character) {

			case '}':

				charInStack = stack.pop();
				if (charInStack == '(' || charInStack == '[') {
					return false;
				}

				break;

			case ']':

				charInStack = stack.pop();
				if (charInStack == '(' || charInStack == '{') {
					return false;
				}

				break;

			case ')':

				charInStack = stack.pop();
				if (charInStack == '{' || charInStack == '[') {
					return false;
				}

				break;

			}
		}
		/*
		 * for(Character val : stack) { System.out.print(val+", "); }
		 */
		return stack.isEmpty();
	}

	/*
	 * This is main method of the program. It calls the method isStringBalanced by
	 * passing a String expression as input parameter to find whether the String is
	 * balanced.
	 */
	public static void main(String[] args) {

		String bracketExpression = "([[{}]])";
		// String bracketExpression = "([[{}]]))";
		// String bracketExpression = "({)}";

		BalancingBrackets object = new BalancingBrackets();

		if (object.isStringBalanced(bracketExpression)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}

	}

}
