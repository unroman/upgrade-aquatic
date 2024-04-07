package com.teamabnormals.upgrade_aquatic.core.other;

import net.minecraft.data.BlockFamily;

import static com.teamabnormals.upgrade_aquatic.core.registry.UABlocks.*;

public class UABlockFamilies {
	public static final BlockFamily DRIFTWOOD_PLANKS_FAMILY = new BlockFamily.Builder(DRIFTWOOD_PLANKS.get()).button(DRIFTWOOD_BUTTON.get()).fence(DRIFTWOOD_FENCE.get()).fenceGate(DRIFTWOOD_FENCE_GATE.get()).pressurePlate(DRIFTWOOD_PRESSURE_PLATE.get()).sign(DRIFTWOOD_SIGNS.getFirst().get(), DRIFTWOOD_SIGNS.getSecond().get()).slab(DRIFTWOOD_SLAB.get()).stairs(DRIFTWOOD_STAIRS.get()).door(DRIFTWOOD_DOOR.get()).trapdoor(DRIFTWOOD_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
	public static final BlockFamily RIVER_PLANKS_FAMILY = new BlockFamily.Builder(RIVER_PLANKS.get()).button(RIVER_BUTTON.get()).fence(RIVER_FENCE.get()).fenceGate(RIVER_FENCE_GATE.get()).pressurePlate(RIVER_PRESSURE_PLATE.get()).sign(RIVER_SIGNS.getFirst().get(), RIVER_SIGNS.getSecond().get()).slab(RIVER_SLAB.get()).stairs(RIVER_STAIRS.get()).door(RIVER_DOOR.get()).trapdoor(RIVER_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
	
	public static final BlockFamily SCUTE_SHINGLES_FAMILY = new BlockFamily.Builder(SCUTE_SHINGLES.get()).wall(SCUTE_SHINGLE_WALL.get()).stairs(SCUTE_SHINGLE_STAIRS.get()).slab(SCUTE_SHINGLE_SLAB.get()).chiseled(CHISELED_SCUTE_SHINGLES.get()).getFamily();
	public static final BlockFamily SCUTE_PAVEMENT_FAMILY = new BlockFamily.Builder(SCUTE_PAVEMENT.get()).wall(SCUTE_PAVEMENT_WALL.get()).stairs(SCUTE_PAVEMENT_STAIRS.get()).slab(SCUTE_PAVEMENT_SLAB.get()).getFamily();
	
	public static final BlockFamily TOOTH_BRICKS_FAMILY = new BlockFamily.Builder(TOOTH_BRICKS.get()).wall(TOOTH_BRICK_WALL.get()).stairs(TOOTH_BRICK_STAIRS.get()).slab(TOOTH_BRICK_SLAB.get()).chiseled(CHISELED_TOOTH_BRICKS.get()).getFamily();
	public static final BlockFamily TOOTH_TILES_FAMILY = new BlockFamily.Builder(TOOTH_TILES.get()).wall(TOOTH_TILE_WALL.get()).stairs(TOOTH_TILE_STAIRS.get()).slab(TOOTH_TILE_SLAB.get()).getFamily();
}
