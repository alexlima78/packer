package com.mobiquityinc.packer.domain;

import java.util.List;

public class Sample {
	
	private static final int MAX_CAPACITY = 100;
	private static final int MAX_SIZE = 15;

	private int capacity;
	private List<Item> itens;
	
	public Sample(int capacity, List<Item> itens) {
		
		if (!validateInput(capacity, MAX_CAPACITY)) {
			throw new IllegalArgumentException("Capacity is invalid: " + capacity);
		}
		
		if (!validateInput(itens.size(), MAX_SIZE)) {
			throw new IllegalArgumentException("Size is invalid: " + itens.size());
		}
		
		this.capacity = capacity;
		this.itens = itens;
	}

	public int getCapacity() {
		return capacity;
	}

	public List<Item> getItens() {
		return itens;
	}

	private boolean validateInput(int input, int maxValue) {
		return 0 < input && maxValue >= input;
	}
}
