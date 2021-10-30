package utils;

import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Matcher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.RegexBuilder;

class RegexBuilderTest {

	@Test
	@DisplayName("Can recognise a digit on its own")
	void testIsDigitOnly() {
		Assert.assertFalse(RegexBuilder.isDigitOnly().matcher("a12b").find());
		Assert.assertFalse(RegexBuilder.isDigitOnly().matcher("-").find());
		Assert.assertFalse(RegexBuilder.isDigitOnly().matcher("1+2").find());
		Assert.assertTrue(RegexBuilder.isDigitOnly().matcher("-1.2").find());
		Assert.assertTrue(RegexBuilder.isDigitOnly().matcher("1,2").find());
		Assert.assertTrue(RegexBuilder.isDigitOnly().matcher("12").find());
		Assert.assertTrue(RegexBuilder.isDigitOnly().matcher("-12").find());
	}
	
	@Test
	@DisplayName("Can recognise a digit pattern")
	void testIsDigit() {
		Assert.assertFalse(RegexBuilder.isDigit().matcher("abcde").find());
		Assert.assertFalse(RegexBuilder.isDigit().matcher("-").find());
		Assert.assertTrue(RegexBuilder.isDigit().matcher("abcde 1.2").find());
		Assert.assertTrue(RegexBuilder.isDigit().matcher("1,2 abcde").find());
		Assert.assertTrue(RegexBuilder.isDigit().matcher("12").find());
		Assert.assertTrue(RegexBuilder.isDigit().matcher("-12").find());
	}

	@Test
	@DisplayName("Can recognise an optional space pattern")
	void testIsOptionalSpace() {
		Assert.assertTrue(RegexBuilder.isOptionalSpace().matcher("abc de").find());
		Assert.assertTrue(RegexBuilder.isOptionalSpace().matcher(" abcde").find());
		Assert.assertTrue(RegexBuilder.isOptionalSpace().matcher("abcde ").find());
		Assert.assertTrue(RegexBuilder.isOptionalSpace().matcher("ab	cde").find());
	}

	@Test
	@DisplayName("Can recognise a parenthesis expression pattern")
	void testIsParenthesis() {
		Assert.assertFalse(RegexBuilder.isParenthesis().matcher("1+2").find());
		Assert.assertFalse(RegexBuilder.isParenthesis().matcher("(12)").find());
		Assert.assertFalse(RegexBuilder.isParenthesis().matcher("(1+2)").find());
//		Assert.assertTrue(RegexBuilder.isParenthesis().matcher("1+(2+3)+4").find());
//		Assert.assertTrue(RegexBuilder.isParenthesis().matcher("(1.2^3)").find());
//		Assert.assertEquals(RegexBuilder.isParenthesis().matcher("((1+2)+3)").group(), "(1+2)");
	}

	@Test
	@DisplayName("Can recognise a function pattern")
	void testIsFunction() {
		Assert.assertTrue(RegexBuilder.isFunction().matcher("(25)").find());
		Assert.assertTrue(RegexBuilder.isFunction().matcher("cos(25)").find());
		Assert.assertFalse(RegexBuilder.isFunction().matcher("unknown(25+12)").find());
	}

	@Test
	@DisplayName("Can recognise a primary operation pattern")
	void testIsPrimaryOperation() {
		Assert.assertTrue(RegexBuilder.isPrimaryOperation().matcher("2^4").find());
		Assert.assertFalse(RegexBuilder.isPrimaryOperation().matcher("2*4").find());
		Assert.assertFalse(RegexBuilder.isPrimaryOperation().matcher("2/4").find());
		Assert.assertFalse(RegexBuilder.isPrimaryOperation().matcher("2+4").find());
		Assert.assertFalse(RegexBuilder.isPrimaryOperation().matcher("2-4").find());
	}

	@Test
	@DisplayName("Can recognise a secondary operation pattern")
	void testIsSecondaryOperation() {
		Assert.assertFalse(RegexBuilder.isSecondaryOperation().matcher("2^4").find());
		Assert.assertTrue(RegexBuilder.isSecondaryOperation().matcher("2*4").find());
		Assert.assertTrue(RegexBuilder.isSecondaryOperation().matcher("2/4").find());
		Assert.assertFalse(RegexBuilder.isSecondaryOperation().matcher("2+4").find());
		Assert.assertFalse(RegexBuilder.isSecondaryOperation().matcher("2-4").find());
	}

	@Test
	@DisplayName("Can recognise a tertiary operation pattern")
	void testIsTertiaryOperation() {
		Assert.assertFalse(RegexBuilder.isTertiaryOperation().matcher("2^4").find());
		Assert.assertFalse(RegexBuilder.isTertiaryOperation().matcher("2*4").find());
		Assert.assertFalse(RegexBuilder.isTertiaryOperation().matcher("2/4").find());
		Assert.assertTrue(RegexBuilder.isTertiaryOperation().matcher("2+4").find());
		Assert.assertTrue(RegexBuilder.isTertiaryOperation().matcher("2-4").find());
	}

}
