package utils;
import java.util.function.DoubleBinaryOperator;

public enum Operator {
	EXPONENT(
			"^",
			(double a, double b) -> Math.pow(a, b)
	),
	MULTIPLICATION(
			"*",
			(double a, double b) -> a * b
	),
	DIVISION(
			"/",
			(double a, double b) -> a / b
	),
	ADDITION(
			"+",
			(double a, double b) -> a + b
	),
	SUBSTRACTION(
			"-",
			(double a, double b) -> a - b
	);
	
	private String id;
	private DoubleBinaryOperator execute;

    private Operator(String id, DoubleBinaryOperator execute) {
        this.id = id;
        this.execute = execute;
    }
    
    public String id () {
    	return this.id;
    }

    public double execute(double a, double b) {
        return this.execute.applyAsDouble(a, b);
    }

    public static Operator value(String value) {
        for (Operator operator : Operator.values()) {
            if (operator.id().equals(value)) {
                return operator;
            }
        }
        return null; // TODO don't
    }
}
