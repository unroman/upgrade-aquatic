package com.teamabnormals.upgrade_aquatic.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class UAItemTags {
	public static final TagKey<Item> DRIFTWOOD_LOGS = itemTag("driftwood_logs");
	public static final TagKey<Item> RIVER_LOGS = itemTag("river_logs");

	private static TagKey<Item> itemTag(String name) {
		return TagUtil.itemTag(UpgradeAquatic.MOD_ID, name);
	}
}