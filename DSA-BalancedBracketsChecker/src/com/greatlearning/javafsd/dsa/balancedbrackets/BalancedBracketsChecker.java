package com.greatlearning.javafsd.dsa.balancedbrackets;

import java.util.Set;
import java.util.Stack;

public class BalancedBracketsChecker {
	private String expression;

	public BalancedBracketsChecker(String expression) {

		this.expression = expression;
	}

	public boolean check() {

		if (expression.length() % 2 != 0) {

			System.out.println("Quick Check -> Expression is not balanced..");
			return false;
		}

		BalancedBracketsUtils utils = new BalancedBracketsUtils();
		utils.maintainAllValidBalancedBrackets();

		Set<Character> allOpenBrackets = utils.getAllOpenBrackets();
		Set<Character> allClosedBrackets = utils.getAllCloseBrackets();

		boolean validExpression = true;

		Stack<Character> stack = new Stack<>();

		// [{}]
		for (int index = 0; index < expression.length(); index++) {

			char visitedChar = expression.charAt(index);

			if (allOpenBrackets.contains(visitedChar)) {

				// [{(

				stack.push(visitedChar);

			} else if (allClosedBrackets.contains(visitedChar)) {

				// Closed bracket char

				Character poppedItem = stack.pop();

				Character openBracket = utils.getOpenBracket(visitedChar);

				if (poppedItem.equals(openBracket)) {

					// Match scenario
				} else {

					// No Match
					validExpression = false;
					break;
				}
			} else {

				validExpression = false;
				break;
			}
		}

		return validExpression;
	}

}
