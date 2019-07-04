package com.mobiquityinc.packer.domain;

public class Item {
	
	private static final int MAX = 100;

	private int index;
	private double weight;
	private int price;

	public Item(int index, double weight, int price) {
		
		if (!validateInput(weight)) {
			throw new IllegalArgumentException("Weight is invalid: " + weight);
		}
		
		if (!validateInput(price)) {
			throw new IllegalArgumentException("Price is invalid: " + price);
		}

		this.index = index;
		this.weight = weight;
		this.price = price;
	}

	public int getIndex() {
		return index;
	}

	public double getWeight() {
		return weight;
	}

	public int getPrice() {
		return price;
	}
	
	private boolean validateInput(double input) {
		return 0 < input && MAX >= input;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + price;
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (index != other.index)
			return false;
		if (price != other.price)
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [index=" + index + ", weight=" + weight + ", price=" + price + "]";
	}

}
