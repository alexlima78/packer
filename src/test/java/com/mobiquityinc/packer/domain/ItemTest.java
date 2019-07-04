package com.mobiquityinc.packer.domain;

import org.junit.Test;

public class ItemTest {

	@Test(expected = IllegalArgumentException.class)
	public void illegalWeightTest() {
		final double OVERWEIGHT = 101.5;
		final int PRICE = 50;

		new Item(1, OVERWEIGHT, PRICE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void illegalPriceTest() {
		final double WEIGHT = 100;
		final int OVERPRICE = 101;
		
		new Item(1, WEIGHT, OVERPRICE);
	}

}
