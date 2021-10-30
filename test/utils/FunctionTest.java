package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.Function;

class FunctionTest {

	@Test
	@DisplayName("SQUARE_ROOT enum has correct id and can be executed")
	void testSquareRoot() {
		Assert.assertEquals(Function.SQUARE_ROOT.id(), "sqrt");
		double expected = 5;
		double actual = Function.SQUARE_ROOT.execute(25);
		Assert.assertEquals(actual, expected, 0.0);
	}
	
	@Test
	@DisplayName("ABSOLUTE enum has correct id and can be executed")
	void testAbsolute() {
		Assert.assertEquals(Function.ABSOLUTE.id(), "abs");
		double expected = 42;
		double actual = Function.ABSOLUTE.execute(-42);
		Assert.assertEquals(actual, expected, 0.0);
	}
	
//	@Test
//	@DisplayName("COSINUS enum has correct id and can be executed")
//	void testExponent() {
//		Assert.assertEquals(Function.COSINUS.id(), "^");
//		double expected = 25;
//		double actual = Function.COSINUS.execute(5);
//		Assert.assertEquals(actual, expected, 0.0);
//	}
//	
//	@Test
//	@DisplayName("XXXX enum has correct id and can be executed")
//	void testExponent() {
//		Assert.assertEquals(Function.XXXX.id(), "^");
//		double expected = 25;
//		double actual = Function.XXXX.execute(5);
//		Assert.assertEquals(actual, expected, 0.0);
//	}
//	
//	@Test
//	@DisplayName("XXXX enum has correct id and can be executed")
//	void testExponent() {
//		Assert.assertEquals(Function.XXXX.id(), "^");
//		double expected = 25;
//		double actual = Function.XXXX.execute(5);
//		Assert.assertEquals(actual, expected, 0.0);
//	}
//	
//	@Test
//	@DisplayName("XXXX enum has correct id and can be executed")
//	void testExponent() {
//		Assert.assertEquals(Function.XXXX.id(), "^");
//		double expected = 25;
//		double actual = Function.XXXX.execute(5);
//		Assert.assertEquals(actual, expected, 0.0);
//	}
//	
//	@Test
//	@DisplayName("XXXX enum has correct id and can be executed")
//	void testExponent() {
//		Assert.assertEquals(Function.XXXX.id(), "^");
//		double expected = 25;
//		double actual = Function.XXXX.execute(5);
//		Assert.assertEquals(actual, expected, 0.0);
//	}
//	
//	@Test
//	@DisplayName("XXXX enum has correct id and can be executed")
//	void testExponent() {
//		Assert.assertEquals(Function.XXXX.id(), "^");
//		double expected = 25;
//		double actual = Function.XXXX.execute(5);
//		Assert.assertEquals(actual, expected, 0.0);
//	}
//	
//	@Test
//	@DisplayName("XXXX enum has correct id and can be executed")
//	void testExponent() {
//		Assert.assertEquals(Function.XXXX.id(), "^");
//		double expected = 25;
//		double actual = Function.XXXX.execute(5);
//		Assert.assertEquals(actual, expected, 0.0);
//	}
//	
//	@Test
//	@DisplayName("XXXX enum has correct id and can be executed")
//	void testExponent() {
//		Assert.assertEquals(Function.XXXX.id(), "^");
//		double expected = 25;
//		double actual = Function.XXXX.execute(5);
//		Assert.assertEquals(actual, expected, 0.0);
//	}
//	
//	@Test
//	@DisplayName("XXXX enum has correct id and can be executed")
//	void testExponent() {
//		Assert.assertEquals(Function.XXXX.id(), "^");
//		double expected = 25;
//		double actual = Function.XXXX.execute(5);
//		Assert.assertEquals(actual, expected, 0.0);
//	}
	
}
