package com.mobiquityinc.packer.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SampleTest {
	
	private static final double WEIGHT = 50.5;
	private static final int PRICE = 50;

	@Test(expected = IllegalArgumentException.class)
	public void illegalCapacityTest() {
		final int OVERCAPACITY = 101;
		
		new Sample(OVERCAPACITY, Arrays.asList(new Item(1, WEIGHT, PRICE)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void illegalItensSizeTest() {
		final int OVERSIZE = 20;
		final int CAPACITY = 50;
		
		List<Item> itens = new ArrayList<>();
		
		for (int i = 1; i <= OVERSIZE; i++) {
			itens.add(new Item(i, WEIGHT, PRICE));
		}

		new Sample(CAPACITY, itens);
	}

}
