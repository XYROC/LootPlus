package xiroc.lootplus.util;

import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xiroc.lootplus.LootPlus;
import xiroc.lootplus.api.LootRegistry;
import xiroc.lootplus.api.loot.LootEntryCustom;
import xiroc.lootplus.api.loot.LootPoolItem;

public class EventManager {

	@SubscribeEvent
	public void loadLoot(LootTableLoadEvent event) {
		String name = event.getName().toString();
		LootPlus.logger.info("Loading " + name);
		if (LootRegistry.registry.containsKey(name)) {
			for (LootEntryCustom entry : LootRegistry.registry.get(name)) {
				if (entry == null)
					continue;
				event.getTable().addPool(entry.lootPool());
			}
		}
	}

}
