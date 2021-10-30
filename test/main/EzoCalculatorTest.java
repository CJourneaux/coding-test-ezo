package main;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.EzoCalculator;

class EzoCalculatorTest {

	@Test
	@DisplayName("Can compute simple addition")
	void testAddition() {
		String input = "1+1";
		String expected = "2";
		String actual = EzoCalculator.calculate(input);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Can compute simple addition with spaces")
	void testAdditionWithSpaces() {
		String input = "1 + 2";
		String expected = "3";
		String actual = EzoCalculator.calculate(input);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Can compute simple addition with negative numbers")
	void testAdditionWithNegativeNumbers() {
		String input = "1 + -1";
		String expected = "0";
		String actual = EzoCalculator.calculate(input);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Can compute simple substraction with negative numbers")
	void testSubstractionWithNegativeNumbers() {
		String input = "-1 - -1";
		String expected = "0";
		String actual = EzoCalculator.calculate(input);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Can compute simple substraction")
	void testSubstraction() {
		String input = "5-4";
		String expected = "1";
		String actual = EzoCalculator.calculate(input);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Can compute simple multiplication")
	void testMultiplication() {
		String input = "5*2";
		String expected = "10";
		String actual = EzoCalculator.calculate(input);
		Assert.assertEquals(expected, actual);
	}
	
//	@Test
//	@DisplayName("Can compute complex expressions while prioritising parentheses")
//	void testPrioritisingParenthesis() {
//		String input = "(2+5)*3";
//		String expected = "21";
//		String actual = EzoCalculator.calculate(input);
//		Assert.assertEquals(expected, actual);
//	}
	
	@Test
	@DisplayName("Can compute simple division")
	void testDivision() {
		String input = "10/2";
		String expected = "5";
		String actual = EzoCalculator.calculate(input);
		Assert.assertEquals(expected, actual);
	}
	
//	@Test
//	@DisplayName("Can compute complex expressions while prioritising multiplications")
//	void testPrioritisingMultiplications() {
//		String input = "2+2*5+5";
//		String expected = "17";
//		String actual = EzoCalculator.calculate(input);
//		Assert.assertEquals(expected, actual);
//	}
//	
//	@Test
//	@DisplayName("Can compute complex expressions with decimal numbers")
//	void testDecimalNumbers() {
//		String input = "2.8*3-1";
//		String expected = "7.4";
//		String actual = EzoCalculator.calculate(input);
//		Assert.assertEquals(expected, actual);
//	}
//	
//	@Test
//	@DisplayName("Can compute exponent operations")
//	void testExponent() {
//		String input = "2^8";
//		String expected = "256";
//		String actual = EzoCalculator.calculate(input);
//		Assert.assertEquals(expected, actual);
//	}
//	
//	@Test
//	@DisplayName("Can compute complex operations while prioritising exponents")
//	void testPrioritisingExponents() {
//		String input = "2^8*5-1";
//		String expected = "1279";
//		String actual = EzoCalculator.calculate(input);
//		Assert.assertEquals(expected, actual);
//	}
	
	@Test
	@DisplayName("Can compute function calls")
	void testFunctionCalls() {
		String input = "sqrt(4)";
		String expected = "2";
		String actual = EzoCalculator.calculate(input);
		Assert.assertEquals(expected, actual);
	}
	
//	@Test
//	@DisplayName("Returns an error when attempting invalid mathematical operations")
//	void testAddition() {
//		String input = "1/0";
//		String expected = "1";
//		String actual = EzoCalculator.calculate(input);
//		Assert.assertEquals(expected, actual);
//	}
//	"1/0" 	Erreur*

	
	
}
