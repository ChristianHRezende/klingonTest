package br.com.chrezende.klingontest.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.chrezende.klingontest.enums.VerbEnum;
import br.com.chrezende.klingontest.klingon.Groups;
import br.com.chrezende.klingontest.test.builder.TextABuilder;

class GroupsTest {

	@Test
	void getNumberOsPrepositionsTest() {
		// Scene
		Groups groups = new Groups();
		TextABuilder builder = new TextABuilder();
		String[] textA = builder.getTextA();

		// Action
		int result = groups.getNumberOsPrepositions(textA);

		// Assert
		Assert.assertTrue(result == 63);
	}

	@Test
	void isVerbTest() {
		// Scene
		Groups groups = new Groups();
		TextABuilder builder = new TextABuilder();
		String[] textA = builder.getTextA();

		// Action

		int verbsB = 0;
		int verbsBFirstPerson = 0;

		for (String word : textA) {
			// if is verb
			VerbEnum verbEnum = groups.isVerb(word);
			if (verbEnum != null) {
				verbsB++;
				// if first person
				if (verbEnum.equals(VerbEnum.FIRST_PERSON)) {
					verbsBFirstPerson++;
				}

			}
		}

		// Assert
		Assert.assertTrue(verbsB == 26);
		Assert.assertTrue(verbsBFirstPerson == 23);
	}

}
