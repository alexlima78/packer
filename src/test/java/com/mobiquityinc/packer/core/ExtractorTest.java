package com.mobiquityinc.packer.core;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.mobiquityinc.packer.domain.Item;

public class ExtractorTest {

	@Test
	public void extractItensTest() {
		String itensText = "(1,53.38,€45) (2,88.62,€98) (3,78.48,€3)";
		List<Item> itensExpected = Arrays.asList(new Item(1, 53.38, 45),
				new Item(2, 88.62, 98),
				new Item(3, 78.48, 3));
		
		List<Item> itens = Extractor.extractItens(itensText);
		Assert.assertEquals("Failed extracting itens!", itensExpected, itens);
	}

}
