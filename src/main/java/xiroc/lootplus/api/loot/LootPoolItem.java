package xiroc.lootplus.api.loot;

import java.util.Collection;
import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import xiroc.lootplus.LootPlus;

public class LootPoolItem extends LootPool {

	private ItemStack item;
	private float chance;
	private RandomValueRange amount;
	private RandomValueRange damage;

	public LootPoolItem(ItemStack item, RandomValueRange amount, RandomValueRange damage, float chance,
			LootEntry[] lootEntriesIn, LootCondition[] poolConditionsIn, RandomValueRange rollsIn,
			RandomValueRange bonusRollsIn, String name) {
		super(lootEntriesIn, poolConditionsIn, rollsIn, bonusRollsIn, name);
		this.item = item;
		this.chance = chance;
		this.amount = amount;
		this.damage = damage;
	}

	@Override
	public void generateLoot(Collection<ItemStack> stacks, Random rand, LootContext context) {
		if (rand.nextFloat() < chance) {
			item.setItemDamage(damage.generateInt(rand));
			item.setCount(amount.generateInt(rand));
			stacks.add(item);
		}
	}

}
