package utils;
import java.util.function.DoubleUnaryOperator;

public enum Function {
	SQUARE_ROOT(
			"sqrt",
			(double a) -> Math.sqrt(a)
	),
	
	ABSOLUTE(
			"abs",
			(double a) -> Math.abs(a)
	),
//	MODULO(
//			"*",
//			(a, b) -> a % b
//	),
	
	COSINUS(
			"cos",
			(double a) -> Math.cos(a)
	),
	ARC_COSINUS(
			"acos",
			(double a) -> Math.acos(a)
	),
	HYPERBOLIC_COSINUS(
			"cosh",
			(double a) -> Math.cosh(a)
	),
	
	SINUS(
			"sin",
			(double a) -> Math.sin(a)
	),
	ARC_SINUS(
			"asin",
			(double a) -> Math.asin(a)
	),
	HYPERBOLIC_SINUS(
			"sinh",
			(double a) -> Math.sinh(a)
	),
	
	TANGENT(
			"tan",
			(double a) -> Math.tan(a)
	),
	ARC_TANGENT(
			"atan",
			(double a) -> Math.atan(a)
	),
	HYPERBOLIC_TANGENT(
			"tanh",
			(double a) -> Math.tanh(a)
	),
	
	EXPONENTIAL(
			"exp",
			(double a) -> Math.exp(a)
	),
	LOGARITHM(
			"log",
			(double a) -> Math.log(a)
	),
	LOGARITHM_BASE_10(
			"log10",
			(double a) -> Math.log10(a)
	);
	
	private String id;
	private DoubleUnaryOperator execute;

    private Function(String id, DoubleUnaryOperator execute) {
        this.id = id;
        this.execute = execute;
    }
    
    public String id () {
    	return this.id;
    }

    public double execute(double a) {
        return this.execute.applyAsDouble(a);
    }

    public static Function value(String name) {
        for (Function function : Function.values()) {
            if (function.id().equals(name)) {
                return function;
            }
        }
        return null; // TODO don't
    }
	
}
