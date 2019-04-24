package br.com.chrezende.klingontest.test.builder;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TextABuilder {
	private String[] textA;
	private String[] textAOrdered;

	public TextABuilder() {
		try {
			// GEt the list
			HttpResponse<String> response = Unirest
					.get("https://raw.githubusercontent.com/financas360/provas/master/klingon-textoA.txt").asString();
			if (response.getBody() != null) {
				textA = response.getBody().trim().split(" ");
			}
			// Get the ordered list
			HttpResponse<String> response2 = Unirest
					.get("https://raw.githubusercontent.com/financas360/provas/master/klingon-textoA-ordenado.txt")
					.asString();
			if (response2.getBody() != null) {
				textAOrdered = response2.getBody().trim().split(" ");
			}
		} catch (UnirestException e) {
			e.printStackTrace();
		}

	}

	public String[] getTextA() {
		return textA;
	}

	public String[] getTextAOrdered() {
		return textAOrdered;
	}
}
