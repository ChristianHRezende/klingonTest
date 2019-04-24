package br.com.chrezende.klingontest.klingon;

import br.com.chrezende.klingontest.constants.Constants;
import br.com.chrezende.klingontest.enums.VerbEnum;

/**
 * Class responsible to maintain variables and functions for Groups Klingon
 * 
 * @author Christian Henrique Rezende
 *
 */
public class Groups {

	/**
	 * Get the number of prepositions on String Array
	 * 
	 * @param groups
	 * @param prepositionsB
	 * @param wordsText
	 * @return
	 */
	public int getNumberOsPrepositions(String[] wordsText) {

		int prepositionsB = 0;
		for (String word : wordsText) {
			if (isPreposition(word)) {
				prepositionsB++;
			}
		}
		return prepositionsB;
	}

	public VerbEnum isVerb(String string) {
		if (string.length() >= 8) {
			char[] chars = string.toCharArray();
			if (isFoo(chars[string.length() - 1])) {
				if (isBar(chars[0])) {
					return VerbEnum.FIRST_PERSON;
				}
				return VerbEnum.OTHER;
			}
		}
		return null;
	}

	public Boolean isPreposition(String string) {
		if (string.length() == 3) {
			if (!string.contains("d")) {
				char[] chars = string.toCharArray();

				if (isBar(chars[2])) {
					return true;
				}
			}

		}
		return false;
	}

	private Boolean isFoo(char charValue) {
		for (char letter : Constants.FOO) {
			if (letter == charValue) {
				return true;
			}
		}
		return false;
	}

	private Boolean isBar(char charValue) {
		for (char letter : Constants.BAR) {
			if (letter == charValue) {
				return true;
			}
		}
		return false;
	}
}
