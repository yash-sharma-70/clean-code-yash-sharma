package org.example.exercises;

import java.util.Arrays;

public class OlxApp {
	private static final int MAX_QUALITY = 50;
	private static final int MIN_QUALITY = 0;
	private static final String AGED_WINE = "Aged Wine";
	private static final String BACKSTAGE_PASS = "ColdPlay concert passes";
	private static final String LEGENDARY_ITEM = "PokemonGo";

	public Item[] items;

	public OlxApp(Item[] items) {
		this.items = items;
	}

	public static void main(String[] args) {

		Item[] items = new Item[]{
				new Item("Mangoes", 10, 20)
		};

		OlxApp app = new OlxApp(items);
		app.updateQuality();
		System.out.println(app);
	}

	public void updateQuality() {
		for (Item item : items) {
			if (!isSpecialItem(item)) {
				decreaseQuality(item);
			} else {
				increaseQuality(item);
			}

			if (!isLegendary(item)) {
				item.sellIn--;
			}
			if (item.sellIn < 0) {
				handleExpiredItem(item);
			}
		}
	}

	private boolean isSpecialItem(Item item) {
		return AGED_WINE.equals(item.name) || BACKSTAGE_PASS.equals(item.name);
	}

	private boolean isLegendary(Item item) {
		return LEGENDARY_ITEM.equals(item.name);
	}

	private void decreaseQuality(Item item) {
		if (item.quality > MIN_QUALITY && !isLegendary(item)) {
			item.quality--;
		}
	}

	private void increaseQuality(Item item) {
		if (item.quality < MAX_QUALITY) {
			item.quality++;

			if (BACKSTAGE_PASS.equals(item.name)) {
				if (item.sellIn < 11 && item.quality < MAX_QUALITY) {
					item.quality++;
				}
				if (item.sellIn < 6 && item.quality < MAX_QUALITY) {
					item.quality++;
				}
			}
		}
	}

	private void handleExpiredItem(Item item) {
		if (AGED_WINE.equals(item.name)) {
			if (item.quality < MAX_QUALITY) {
				item.quality++;
			}
		} else if (BACKSTAGE_PASS.equals(item.name)) {
			item.quality = 0;
		} else {
			decreaseQuality(item);
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(items);
	}
}