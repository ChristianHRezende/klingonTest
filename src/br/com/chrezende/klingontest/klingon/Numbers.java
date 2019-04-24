package br.com.chrezende.klingontest.klingon;

import br.com.chrezende.klingontest.constants.Constants;

/**
 * Class responsible to maintain variables and functions for Numbers Klingon
 * 
 * @author Christian Henrique Rezende
 *
 */
public class Numbers {

	private Vocabulary vocabulary;

	public Numbers() {
		// Instance Vocabulary
		vocabulary = new Vocabulary();
	}

	/**
	 * Get all beaultiful numbers on array
	 * 
	 * @param wordsText
	 * @param vocabulary
	 * @param beautifulNumbers
	 * @return
	 */
	public int getNumberOfBeaultifulNumbers(String[] wordsText) {
		int beautifulNumbers = 0;
		for (String wordString : wordsText) {

			char[] wordChars = wordString.toCharArray();
			long total = 0L;
			int cont = 0;
			while (cont >= 0) {

				// Get the pow
				double valuePos = Math.pow(Constants.BASE, cont);

				// Total
				total += valuePos * vocabulary.getPositionOnVocabulary(wordChars[cont]);

				// Validate
				if (cont == wordChars.length - 1) {
					cont = -1;
				} else {
					cont++;
				}
			}
			// Check is a beautiful number
			if (total >= 440566 && total % 3 == 0) {
				beautifulNumbers++;
			}
		}
		return beautifulNumbers;
	}

}
