package xiroc.lootplus.api;

import java.util.ArrayList;
import java.util.HashMap;

import xiroc.lootplus.LootPlus;
import xiroc.lootplus.api.loot.LootEntryCustom;

public class LootRegistry {

	private static int count = 0;
	public static HashMap<String, LootEntryCustom[]> registry = new HashMap<>();
	
	public static void register(LootEntryCustom[] loot) {
		for (LootEntryCustom entry : loot) {
			merge(entry.lootTable, entry);
		}
	}

	private static void merge(String key, LootEntryCustom entry) {
		count++;
		LootPlus.logger.info("Registering " + entry.lootPoolName + " for loot table " + entry.lootTable + " (" + count + ")");
		if (registry.containsKey(key)) {
			LootEntryCustom[] list = registry.get(key);
			for (int i = 0; i < list.length; i++) {
				if (list[i] == null) {
					list[i] = entry;
					return;
				}
			}
		} else {
			LootEntryCustom[] list = new LootEntryCustom[256];
			list[0] = entry;
			registry.put(key, list);
		}
	}

}
