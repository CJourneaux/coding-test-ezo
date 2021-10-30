package utils;

import java.util.regex.Pattern;

public class RegexBuilder {
	
	public static final String DIGIT = "\\-?\\d+((\\.|\\,)\\d+)?"; 
	public static final String OPTIONAL_SPACE = "\\s*";
	public static final String PARENTHESIS_GROUP = "\\(([^\\(\\)\\d\\.\\,]+)\\)";
		
	public static Pattern isDigitOnly () {
		String DIGIT_ONLY = "^" + DIGIT + "$";
		return Pattern.compile(DIGIT_ONLY);
	}
	
	public static Pattern isDigit () {
		return Pattern.compile(DIGIT);
	}
	
	public static Pattern isOptionalSpace () {
		return Pattern.compile(OPTIONAL_SPACE);
	}
	
	public static Pattern isParenthesis () {
		return Pattern.compile(PARENTHESIS_GROUP);
	}
	
	public static Pattern isFunction () {
		String FUNCTION_GROUP = "([a-z_]+)?\\(("+ DIGIT + ")\\)";
		return Pattern.compile(FUNCTION_GROUP);
	}
	
	
	public static Pattern isPrimaryOperation () {
		String PRIMARY_OPERATOR = "\\" + Operator.EXPONENT.id();
		return isOperation(PRIMARY_OPERATOR);
	}
	public static Pattern isSecondaryOperation () {
		String SECONDARY_OPERATOR = "[" + Operator.MULTIPLICATION.id() + Operator.DIVISION.id() + "]";
		return isOperation(SECONDARY_OPERATOR);
	}
	public static Pattern isTertiaryOperation () {
		String TERTIARY_OPERATOR = "\\" + Operator.ADDITION.id() + "|" + Operator.SUBSTRACTION.id();
		return isOperation(TERTIARY_OPERATOR);
	}
	private static Pattern isOperation (String operatorGroup) {
		String OPERATION_GROUP = "(" + DIGIT + ")(" + operatorGroup + ")(" + DIGIT + ")";
		return Pattern.compile(OPERATION_GROUP);
	}
}
