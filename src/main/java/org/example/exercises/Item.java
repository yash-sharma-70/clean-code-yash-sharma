package org.example.exercises;

public class Item {
	public String name;
	public Integer sellIn;
	public Integer quality;

	public Item(String name, Integer sellIn, Integer quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

	@Override
	public String toString() {
		return String.format("Item{name='%s', sellIn=%d, quality=%d}", name, sellIn, quality);
	}
}
