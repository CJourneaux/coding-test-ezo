package utils;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.Operator;

class OperatorTest {

	@Test
	@DisplayName("EXPONENT enum has correct id and can be executed")
	void testExponent() {
		Assert.assertEquals(Operator.EXPONENT.id(), "^");
		double expected = 25;
		double actual = Operator.EXPONENT.execute(5, 2);
		Assert.assertEquals(actual, expected, 0.0);
	}

	@Test
	@DisplayName("MULTIPLICATION enum has correct id and can be executed")
	void testMultiplication() {
		Assert.assertEquals(Operator.MULTIPLICATION.id(), "*");
		double expected = 42;
		double actual = Operator.EXPONENT.execute(6, 7);
		Assert.assertEquals(actual, expected, 0.0);
	} 

	@Test
	@DisplayName("DIVISION enum has correct id and can be executed")
	void testDivision() {
		Assert.assertEquals(Operator.DIVISION.id(), "/");
		double expected = 3;
		double actual = Operator.EXPONENT.execute(18, 6);
		Assert.assertEquals(actual, expected, 0.0);
	}
	
	@Test
	@DisplayName("ADDITION enum has correct id and can be executed")
	void testAddition() {
		Assert.assertEquals(Operator.ADDITION.id(), "+");
		double expected = 42;
		double actual = Operator.EXPONENT.execute(25, 17);
		Assert.assertEquals(actual, expected, 0.0);
	}
	
	@Test
	@DisplayName("SUBSTRACTION enum has correct id and can be executed")
	void testSusbstraction() {
		Assert.assertEquals(Operator.SUBSTRACTION.id(), "-");
		double expected = 42;
		double actual = Operator.EXPONENT.execute(64, 22);
		Assert.assertEquals(actual, expected, 0.0);
	}
	
}
