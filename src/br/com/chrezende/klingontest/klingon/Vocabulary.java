package br.com.chrezende.klingontest.klingon;

import java.util.ArrayList;
import java.util.List;

import br.com.chrezende.klingontest.constants.Constants;


/**
 * Class responsible to maintain variables and functions for Numbers Klingon
 * 
 * @author Christian Henrique Rezende
 *
 */
public class Vocabulary {
	/**
	 * Order list by Vocabulary
	 * 
	 * @param listOrdered
	 * @param listForOrder
	 */
	public List<String> orderListByVocabulary(List<String> listForOrder) {
		List<String> listOrdered = new ArrayList<String>();

		for (String string : listForOrder) {
			// Boolean for check is ordered
			boolean isOrder = false;

			// Cont for words position
			int word = 0;

			// Get the chars of word
			char[] word1Chars = string.toCharArray();

			// Repeat while os not ordered
			while (!isOrder) {
				// If list is empty
				if (listOrdered.isEmpty()) {
					listOrdered.add(string);
					break;
				}
				// Get the word on position cont word on list orded
				char[] word2Chars = listOrdered.get(word).toCharArray();
				int letter = 0;
				while (letter >= 0) {

					// Check if letter on position is after of position on vocabulary
					if (word2Chars.length == letter || getPositionOnVocabulary(
							word1Chars[letter]) > getPositionOnVocabulary(word2Chars[letter])) {
						word++;
						letter = -1;

						// Check if this word os the last
						if (word == listOrdered.size()) {
							listOrdered.add(string);
						}
						// Check if this letter is equals of the word2 letter
					} else if (getPositionOnVocabulary(word1Chars[letter]) == getPositionOnVocabulary(
							word2Chars[letter])) {
						// pass to another letter
						if (letter != word1Chars.length - 1) {
							letter++;
						} else {
							// if the word is repeated
							word++;
							letter = -1;
						}
					} else {
						// When the list need to be reordered
						List<String> newList = new ArrayList<String>();
						int cont = 0;
						while (cont >= 0) {
							// While the cont is diferent os position of new word iterate the new ordered
							// lost
							if (word == cont) {
								// Add new word
								newList.add(cont, string);
								// Iterate last words of list
								for (int i = cont; i < listOrdered.size(); i++) {
									newList.add(i + 1, listOrdered.get(i));
								}
								// is ordered true
								cont = -1;
								isOrder = true;
							} else {
								newList.add(cont, listOrdered.get(cont));
								cont++;
							}
						}
						// new list ordered
						listOrdered = newList;
						letter = -1;
					}
				}
				// Check is ordered all list by this word
				if (word == listOrdered.size()) {
					isOrder = true;
				}
			}
		}
		return listOrdered;
	}

	/**
	 * Return the position of char on vocabulary Kinglon
	 * 
	 * @param c
	 * @return
	 */
	public int getPositionOnVocabulary(char c) {
		int i = 0;
		while (Constants.VOCABULARY_KLINGON[i] != c) {
			i++;
			if (Constants.VOCABULARY_KLINGON[i] == c) {
				return i;
			}
		}
		return 0;
	}

}
