package xiroc.lootplus.api.loot;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import xiroc.lootplus.LootPlus;

public class LootFile {

	public LootEntryCustom[] loot;

	public LootFile(LootEntryCustom[] loot) {
		this.loot = loot;
	}

	public void toFile(File file) {
		toFile(this, file);
	}

	public static void toFile(LootFile lootFile, File file) {
		try {
			if (!file.exists()) {
				if (!file.getParentFile().exists())
					file.getParentFile().mkdirs();
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file);
			LootPlus.gson.toJson(lootFile, writer);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static LootFile fromFile(File file) {
		try {
			FileReader reader = new FileReader(file);
			return LootPlus.gson.fromJson(reader, LootFile.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
