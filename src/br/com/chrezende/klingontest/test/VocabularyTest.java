package br.com.chrezende.klingontest.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.chrezende.klingontest.klingon.Vocabulary;
import br.com.chrezende.klingontest.test.builder.TextABuilder;

class VocabularyTest {

	@Test
	void getNumberOfBeaultifulNumbersTest() {
		// Scene
		Vocabulary vocabulary = new Vocabulary();

		// Action
		int result = vocabulary.getPositionOnVocabulary('b');

		// Assert
		Assert.assertTrue(result == 1);
	}

	@Test
	void orderListByVocabularyTest() {
		// Scene
		Vocabulary vocabulary = new Vocabulary();
		TextABuilder builder = new TextABuilder();
		String[] textA = builder.getTextA();

		String[] textAOrdered = builder.getTextAOrdered();
		List<String> expectedList = Arrays.asList(textAOrdered);

		// Action
		List<String> listOrdered = new ArrayList<String>();

		List<String> listForOrder = Arrays.asList(textA);

		listOrdered = vocabulary.orderListByVocabulary(listForOrder);
		
		boolean assertion = listOrdered.equals(expectedList);
		// Assert
		Assert.assertTrue(assertion);
	}

}
