package br.com.chrezende.klingontest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.chrezende.klingontest.enums.VerbEnum;
import br.com.chrezende.klingontest.klingon.Groups;
import br.com.chrezende.klingontest.klingon.Numbers;
import br.com.chrezende.klingontest.klingon.Vocabulary;

/**
 * Class responsible to maintain function for Main Runnable Exec
 * 
 * @author Christian Henrique Rezende
 *
 */
public class Main {

	public static void main(String[] args) {

		try {

			// Get List B
			HttpResponse<String> response2 = getContentRequest();

			String textB = response2.getBody();

			// Instances classes functions
			Groups groups = new Groups();
			Vocabulary vocabulary = new Vocabulary();
			Numbers numbers = new Numbers();

			// Questions
			// E no Texto B, quantas preposições existem?
			int prepositionsB = 0;
			// Words B to Array
			String[] wordsTextB = textB.trim().split(" ");
			prepositionsB = groups.getNumberOsPrepositions(wordsTextB);

			// Já no Texto B, quantos são os verbos?
			int verbsB = 0;

			// E quantos verbos do Texto B estão em primeira pessoa?
			int verbsBFirstPerson = 0;

			for (String word : wordsTextB) {
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

			// Como seria a lista de vocabulário do Texto B?

			List<String> listOrdered = new ArrayList<String>();

			List<String> listForOrder = Arrays.asList(wordsTextB);

			listOrdered = vocabulary.orderListByVocabulary(listForOrder);

			// E no Texto B, quantos números bonitos distintos existem?
			int beautifulNumbers = 0;

			beautifulNumbers = numbers.getNumberOfBeaultifulNumbers(wordsTextB);

			System.out.println("E no Texto B, quantas preposições existem?");
			System.out.println(prepositionsB);
			System.out.println("\n");

			System.out.println("Já no Texto B, quantos são os verbos?");
			System.out.println(verbsB);
			System.out.println("\n");

			System.out.println("E quantos verbos do Texto B estão em primeira pessoa?");
			System.out.println(verbsBFirstPerson);
			System.out.println("\n");

			System.out.println("Como seria a lista de vocabulário do Texto B?");
			System.out.println(listOrdered);
			System.out.println("\n");

			System.out.println("E no Texto B, quantos números bonitos distintos existem?");
			System.out.println(beautifulNumbers);

		} catch (UnirestException e) {
			System.out.println("Sorry is not possible get the lists on github,please check the internet connection");
		}

	}

	/**
	 * Make a web request for get the words of textB
	 * 
	 * @return
	 * @throws UnirestException
	 */
	private static HttpResponse<String> getContentRequest() throws UnirestException {
		HttpResponse<String> response2 = Unirest
				.get("https://raw.githubusercontent.com/financas360/provas/master/klingon-textoB.txt").asString();
		return response2;
	}

}
