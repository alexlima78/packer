package com.mobiquityinc.packer.core;

import java.util.List;

import com.mobiquityinc.packer.domain.Item;
import com.mobiquityinc.packer.domain.Sample;

public class Solver {

	/**
	 * Solve using brute force for rucksack problem.
	 * 
	 * @param samples input for rucksack problem
	 * @return String answer
	 */
	public static String solve(List<Sample> samples) {
		StringBuilder finalAnswer = new StringBuilder();
		int capacity = 0;
		List<Item> itens;
		
		for (Sample sample : samples) {
			capacity = sample.getCapacity();
			itens = sample.getItens();
			
			/*
			 * for each set of line itens I create a String array with possible item combinations
			 * each entry array is an itens combination designed with 0 and 1
			 * 1 means the item is present
			 * 0 means the item is absent
			 * if a sample has 3 itens and the combination is 011 then second and third itens are present
			 * if a sample has 4 itens and the combination is 1001 then firt and last itens are present
			 * 
			 */
			String[] arrangements = new String [(int) Math.pow(2, itens.size()) - 1]; // total possibilities
			String formatRegex = "%0" + itens.size() + "d";

			/*
			 * possibilities are constructed. for a 3 itens sample we have 7 (2^3-1) total possibilities and these combinations:
			 * arrangements[0] = 001
			 * arrangements[0] = 010
			 * arrangements[0] = 011
			 * arrangements[0] = 100
			 * arrangements[0] = 101
			 * arrangements[0] = 110
			 * arrangements[0] = 111
			 */
			for (int i = 0; i < arrangements.length; i++) {
				arrangements[i] = String.format(formatRegex, Integer.parseInt(Integer.toBinaryString(i + 1)));
			}

			char[] arrangement;
			int totalWeight = 0;
			int totalPrice = 0;
			Item item;
			int bestPrice = -1;
			char[] bestArrangement = null;

			/*
			 * iterate through all combinations looking for the best fit
			 */
			for (int i = 0; i < arrangements.length; i++) {
				arrangement = arrangements[i].toCharArray();

				/*
				 * iterate through actual combination looking for total weight and price
				 */
				for (int j = 0; j < arrangement.length; j ++) {
					if (arrangement[j] == '1') {
						item = itens.get(j);
						totalWeight += item.getWeight();
						totalPrice += item.getPrice();
					}
				}

				/*
				 * keep best fit
				 */
				if (totalWeight <= capacity && totalPrice > bestPrice) {
					bestPrice = totalPrice;
					bestArrangement = arrangement;
				}

				totalWeight = 0;
				totalPrice = 0;
			}

			String sampleResult = "-";
			
			if (bestArrangement != null) { // may have not find any possible result like total set is one item with weight > capacity
				StringBuilder result = new StringBuilder();
				
				for (int i = 0; i < bestArrangement.length; i++) {
					if (bestArrangement[i] == '1') {
						result.append(i + 1).append(" ");
					}
				}
				
				sampleResult = String.join(",", result.toString().trim().split(" "));
			}

			finalAnswer.append(sampleResult + "\n"); // store sample result
		
		}

		return finalAnswer.toString();
	}
}
