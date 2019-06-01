package xiroc.lootplus.api.loot;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;

public class LootEntryCustom {

	public String lootTable;
	public String registryName;
	public String lootPoolName;
	public RandomValueRange amount;
	public RandomValueRange damage;
	public float chance;

	public LootEntryCustom(String lootTable, String itemRegistryName, String lootPoolName, RandomValueRange amount,
			RandomValueRange damage, float chance) {
		this.lootTable = lootTable;
		this.registryName = itemRegistryName;
		this.lootPoolName = lootPoolName;
		this.amount = amount;
		this.damage = damage;
		this.chance = chance;
	}

	public LootPoolItem lootPool() {
		return new LootPoolItem(new ItemStack(Item.getByNameOrId(registryName)), amount, damage, chance,
				new LootEntry[0], new LootCondition[0], new RandomValueRange(0F), new RandomValueRange(0F),
				lootPoolName);
	}

}
