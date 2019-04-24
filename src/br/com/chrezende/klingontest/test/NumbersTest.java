package br.com.chrezende.klingontest.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.chrezende.klingontest.klingon.Numbers;
import br.com.chrezende.klingontest.test.builder.TextABuilder;

class NumbersTest {

	@Test
	void getNumberOfBeaultifulNumbersTest() {
		// Scene
		Numbers numbers = new Numbers();
		TextABuilder builder = new TextABuilder();
		String[] textA = builder.getTextA();

		// Action
		int result = numbers.getNumberOfBeaultifulNumbers(textA);

		// Assert
		Assert.assertTrue(result == 126);
	}

}
