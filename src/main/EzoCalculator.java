package main;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import types.CallbackEnum;
import utils.Function;
import utils.Operator;
import utils.RegexBuilder;

public class EzoCalculator {
	
	
	public static void main(String[] args) {
		System.out.println("Enter your calcul here, type H for help, type Q to exit");
		Scanner sc = new Scanner(System.in);
		boolean stay = true;
	    while(stay){
	        String input = sc.nextLine().replaceAll("\\s*", "").toLowerCase();
	        switch (input) {
	        	case "q":
	        		stay = false;
	        		break;
	        	case "h" :
	        		System.out.println("Mayday mayday");
	        		break;
        		default :
        			System.out.println("INPUT : " + input);
        			String result = EzoCalculator.calculate(input);
        			System.out.println("Result : " + result);
	        }
	    }
	}
	
	public static String calculate (String input) {
		
		StringBuffer result = identify(RegexBuilder.isParenthesis(), input, CallbackEnum.GO_INSIDE);
		result = identify(RegexBuilder.isFunction(), result.toString(), CallbackEnum.COMPUTE_FUNCTION);
		result = identify(RegexBuilder.isPrimaryOperation(), result.toString(), CallbackEnum.COMPUTE_OPERATION);
		result = identify(RegexBuilder.isSecondaryOperation(), result.toString(), CallbackEnum.COMPUTE_OPERATION);
		result = identify(RegexBuilder.isTertiaryOperation(), result.toString(), CallbackEnum.COMPUTE_OPERATION);
		
		String output = result.toString();
		if (RegexBuilder.isDigitOnly().matcher(output).find()) {
			BigDecimal cleanOutput = new BigDecimal(output);
			return cleanOutput.stripTrailingZeros().toPlainString();
		} else {
			return calculate(output);
		}
		
	}
	
	public static StringBuffer identify (Pattern pattern, String input, CallbackEnum callbackType) {
		Matcher matcher = pattern.matcher(input);
		StringBuffer result = new StringBuffer();
	    
		while (matcher.find()) {
			switch (callbackType) {
				case GO_INSIDE:
					matcher.appendReplacement(
							result, 
							EzoCalculator.calculate(matcher.group(1))
					);
					break;
				case COMPUTE_FUNCTION:
					compute(result, matcher, 1, 2);
					break;
				case COMPUTE_OPERATION:
					compute(result, matcher, 3, 1, 4);
					break;
				default:
					System.err.println("There was an issue analysing : " + input);
			}
        }
		matcher.appendTail(result);
		
		return result;
	}
	
	public static StringBuffer compute (StringBuffer result, Matcher matcher, int indexFuncName, int indexA) {
		Function func = Function.value(matcher.group(indexFuncName));
		double a = Double.parseDouble(matcher.group(indexA));
		
		double replacement = func == null ? a : func.execute(a);
		matcher.appendReplacement(
				result, 
				String.valueOf(replacement)
		);
		
		return result;
		
	}
	
	public static StringBuffer compute (StringBuffer result, Matcher matcher, int indexOperator, int indexA, int indexB) {
		Operator operator = Operator.value(matcher.group(indexOperator));
		double a = Double.parseDouble(matcher.group(indexA));
		double b = Double.parseDouble(matcher.group(indexB));
		
		matcher.appendReplacement(
				result, 
				String.valueOf(operator.execute(a, b))
		);
		
		return result;
		
	}
	
	
	
}
