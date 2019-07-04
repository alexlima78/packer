package com.mobiquityinc.packer.core;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mobiquityinc.packer.domain.Item;
import com.mobiquityinc.packer.domain.Sample;

public class Extractor {

	/*
	 * extracts info (capacity and items) from file raw lines
	 */
	public static List<Sample> extractSamples(List<String> lines) {
		List<Sample> samples = new ArrayList<>();
		String[] lineParts;
		int capacity;
		String itensText;
		List<Item> itens;
		
		for (String line : lines) {
			lineParts = line.split(":");
			capacity = Integer.parseInt(lineParts[0].trim());
			itensText = lineParts[1];

			try {
				itens = extractItens(itensText);
				samples.add(new Sample(capacity, itens));
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Error parsing line: " + line);
			}
			
			
		}
		
		return samples;
	}

	/*
	 * parser line content and builds itens
	 */
	static List<Item> extractItens(String itensText) {
		List<Item> itens = new ArrayList<>();
		Matcher m = Pattern.compile("\\((.*?)\\)").matcher(itensText); // search text parts between parenthesis
		String itemText;
		String[] itemTextParts;
		int index;
		double weight;
		int price;
		Currency currentCurrency = Currency.getInstance(new Locale("nl", "NL")); //Netherlands currency symbol

		while(m.find()) {
			itemText = m.group(1);
		    itemTextParts = itemText.split(",");
		    index = Integer.parseInt(itemTextParts[0].trim());
		    weight = Double.parseDouble(itemTextParts[1].trim());
		    price = Integer.parseInt(itemTextParts[2].trim().replace(currentCurrency.getSymbol(), ""));

		    itens.add(new Item(index, weight, price));
		}
		
		return itens;
	}
}
