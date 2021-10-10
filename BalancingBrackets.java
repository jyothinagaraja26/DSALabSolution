package com.greatlearning.mentored.labsession4.quesion1;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {

	// Driver code
	public static void main(String[] args) {

		// Take the input from the user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the  Bracket Expression");
		String exp = sc.next();

		// Function call
		if (isbalanced(exp)) {
			System.out.println("Bracket Expression is Balanced");
		} else {
			System.out.println("Bracket Expression is Not Balanced");
		}

	}

	// Function to check if brackets are balanced
	static boolean isbalanced(String bracketExpression) {

		Stack<Character> stack = new Stack<Character>();

		if (bracketExpression.length() % 2 == 1) {
			return false;
		} else {
			// {([])} Traversing the expression
			for (int i = 0; i < bracketExpression.length(); i++) {
				char ch = bracketExpression.charAt(i);

				if (ch == '{' || ch == '(' || ch == '[') {
					// push the element in the stack
					stack.push(ch);
				} else {
					// If current character is not opening bracket,
					//then it must be closing, so stack cannot be empty
					if (stack.isEmpty())
						return false;
					char c = stack.pop();
					switch (ch) {
					case '}':
						if (c == '(' || c == '[') {
							return false;

						}
						break;

					case ')':
						if (c == '{' || c == '[') {
							return false;

						}
						break;

					case ']':
						if (c == '(' || c == '{') {
							return false;

						}
						break;
					}
				}
			}
		}
		// check empty stack
		return (stack.isEmpty());

	}

}
