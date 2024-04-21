package com.teamabnormals.upgrade_aquatic.core.data.server;

import com.teamabnormals.boatload.core.data.server.BoatloadRecipeProvider;
import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;
import com.teamabnormals.upgrade_aquatic.core.other.UABlockFamilies;
import com.teamabnormals.upgrade_aquatic.core.other.tags.UAItemTags;
import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks;
import com.teamabnormals.upgrade_aquatic.core.registry.UAItems;
import com.teamabnormals.upgrade_aquatic.integration.boatload.UABoatTypes;
import com.teamabnormals.woodworks.core.data.server.WoodworksRecipeProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

import javax.annotation.Nullable;
import java.util.function.Consumer;

import static com.teamabnormals.upgrade_aquatic.core.registry.UABlocks.*;

public class UARecipeProvider extends RecipeProvider {
	public static final ModLoadedCondition BOATLOAD_LOADED = new ModLoadedCondition("boatload");

	public UARecipeProvider(PackOutput output) {
		super(output);
	}

	@Override
	public void buildRecipes(Consumer<FinishedRecipe> consumer) {
		oneToOneConversionRecipe(consumer, Items.PINK_DYE, PINK_SEAROCKET.get(), "pink_dye");
		oneToOneConversionRecipe(consumer, Items.WHITE_DYE, WHITE_SEAROCKET.get(), "white_dye");
		oneToOneConversionRecipe(consumer, Items.CYAN_DYE, PICKERELWEED.get(), "cyan_dye");
		oneToOneConversionRecipe(consumer, Items.PINK_DYE, FLOWERING_RUSH.get(), "pink_dye", 2);
		oneToOneConversionRecipe(consumer, Items.MAGENTA_DYE, UAItems.MULBERRY.get(), "magenta_dye");

		nineBlockStorageRecipes(consumer, RecipeCategory.MISC, Items.SCUTE, RecipeCategory.BUILDING_BLOCKS, SCUTE_BLOCK.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, UABlocks.SCUTE_SHINGLES.get(), 8).define('#', Blocks.STONE_BRICKS).define('S', Items.SCUTE).pattern("###").pattern("#S#").pattern("###").unlockedBy("has_scute", has(Items.SCUTE)).save(consumer);
		generateRecipes(consumer, UABlockFamilies.SCUTE_SHINGLES_FAMILY);
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_SHINGLE_SLAB.get(), SCUTE_SHINGLES.get(), 2);
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_SHINGLE_STAIRS.get(), SCUTE_SHINGLES.get());
		stonecutterResultFromBase(consumer, RecipeCategory.DECORATIONS, SCUTE_SHINGLE_WALL.get(), SCUTE_SHINGLES.get());
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, CHISELED_SCUTE_SHINGLES.get(), SCUTE_SHINGLES.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, SCUTE_PAVEMENT.get(), 4).define('#', SCUTE_SHINGLES.get()).pattern("##").pattern("##").unlockedBy("has_scute_shingles", has(SCUTE_SHINGLES.get())).save(consumer);
		generateRecipes(consumer, UABlockFamilies.SCUTE_PAVEMENT_FAMILY);
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_PAVEMENT_SLAB.get(), SCUTE_PAVEMENT.get(), 2);
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_PAVEMENT_STAIRS.get(), SCUTE_PAVEMENT.get());
		stonecutterResultFromBase(consumer, RecipeCategory.DECORATIONS, SCUTE_PAVEMENT_WALL.get(), SCUTE_PAVEMENT.get());
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_PAVEMENT.get(), SCUTE_SHINGLES.get());
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_PAVEMENT_SLAB.get(), SCUTE_SHINGLES.get(), 2);
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_PAVEMENT_STAIRS.get(), SCUTE_SHINGLES.get());
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_PAVEMENT_WALL.get(), SCUTE_SHINGLES.get());

		nineBlockStorageRecipes(consumer, RecipeCategory.MISC, UAItems.THRASHER_TOOTH.get(), RecipeCategory.BUILDING_BLOCKS, TOOTH_BLOCK.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, UABlocks.TOOTH_BRICKS.get(), 8).define('#', Blocks.STONE_BRICKS).define('S', UAItems.THRASHER_TOOTH.get()).pattern("###").pattern("#S#").pattern("###").unlockedBy("has_thrasher_tooth", has(UAItems.THRASHER_TOOTH.get())).save(consumer);
		generateRecipes(consumer, UABlockFamilies.TOOTH_BRICKS_FAMILY);
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_BRICK_SLAB.get(), TOOTH_BRICKS.get(), 2);
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_BRICK_STAIRS.get(), TOOTH_BRICKS.get());
		stonecutterResultFromBase(consumer, RecipeCategory.DECORATIONS, TOOTH_BRICK_WALL.get(), TOOTH_BRICKS.get());
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, CHISELED_TOOTH_BRICKS.get(), TOOTH_BRICKS.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TOOTH_TILES.get(), 4).define('#', TOOTH_BRICKS.get()).pattern("##").pattern("##").unlockedBy("has_tooth_bricks", has(TOOTH_BRICKS.get())).save(consumer);
		generateRecipes(consumer, UABlockFamilies.TOOTH_TILES_FAMILY);
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_TILE_SLAB.get(), TOOTH_TILES.get(), 2);
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_TILE_STAIRS.get(), TOOTH_TILES.get());
		stonecutterResultFromBase(consumer, RecipeCategory.DECORATIONS, TOOTH_TILE_WALL.get(), TOOTH_TILES.get());
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_TILES.get(), TOOTH_BRICKS.get());
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_TILE_SLAB.get(), TOOTH_BRICKS.get(), 2);
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_TILE_STAIRS.get(), TOOTH_BRICKS.get());
		stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_TILE_WALL.get(), TOOTH_BRICKS.get());

		generateRecipes(consumer, UABlockFamilies.DRIFTWOOD_PLANKS_FAMILY);
		planksFromLogs(consumer, DRIFTWOOD_PLANKS.get(), UAItemTags.DRIFTWOOD_LOGS, 4);
		woodFromLogs(consumer, DRIFTWOOD.get(), DRIFTWOOD_LOG.get());
		woodFromLogs(consumer, STRIPPED_DRIFTWOOD.get(), STRIPPED_DRIFTWOOD_LOG.get());
		hangingSign(consumer, DRIFTWOOD_HANGING_SIGNS.getFirst().get(), STRIPPED_DRIFTWOOD_LOG.get());

		BoatloadRecipeProvider.boatRecipes(consumer, UABoatTypes.DRIFTWOOD);
		WoodworksRecipeProvider.baseRecipes(consumer, DRIFTWOOD_PLANKS.get(), DRIFTWOOD_SLAB.get(), DRIFTWOOD_BOARDS.get(), DRIFTWOOD_BOOKSHELF.get(), CHISELED_DRIFTWOOD_BOOKSHELF.get(), DRIFTWOOD_LADDER.get(), DRIFTWOOD_BEEHIVE.get(), DRIFTWOOD_CHEST.get(), TRAPPED_DRIFTWOOD_CHEST.get(), UpgradeAquatic.MOD_ID);
		WoodworksRecipeProvider.sawmillRecipes(consumer, UABlockFamilies.DRIFTWOOD_PLANKS_FAMILY, UAItemTags.DRIFTWOOD_LOGS, DRIFTWOOD_BOARDS.get(), DRIFTWOOD_LADDER.get(), UpgradeAquatic.MOD_ID);

		generateRecipes(consumer, UABlockFamilies.RIVER_PLANKS_FAMILY);
		planksFromLogs(consumer, RIVER_PLANKS.get(), UAItemTags.RIVER_LOGS, 4);
		woodFromLogs(consumer, RIVER_WOOD.get(), RIVER_LOG.get());
		woodFromLogs(consumer, STRIPPED_RIVER_WOOD.get(), STRIPPED_RIVER_LOG.get());
		hangingSign(consumer, RIVER_HANGING_SIGNS.getFirst().get(), STRIPPED_RIVER_LOG.get());

		BoatloadRecipeProvider.boatRecipes(consumer, UABoatTypes.RIVER);
		WoodworksRecipeProvider.baseRecipes(consumer, RIVER_PLANKS.get(), RIVER_SLAB.get(), RIVER_BOARDS.get(), RIVER_BOOKSHELF.get(), CHISELED_RIVER_BOOKSHELF.get(), RIVER_LADDER.get(), RIVER_BEEHIVE.get(), RIVER_CHEST.get(), TRAPPED_RIVER_CHEST.get(), UpgradeAquatic.MOD_ID);
		WoodworksRecipeProvider.sawmillRecipes(consumer, UABlockFamilies.RIVER_PLANKS_FAMILY, UAItemTags.RIVER_LOGS, RIVER_BOARDS.get(), RIVER_LADDER.get(), UpgradeAquatic.MOD_ID);
		WoodworksRecipeProvider.leafPileRecipes(consumer, RIVER_LEAVES.get(), RIVER_LEAF_PILE.get(), UpgradeAquatic.MOD_ID);
	}

	public static void nineBlockStorageRecipes(Consumer<FinishedRecipe> consumer, RecipeCategory itemCategory, ItemLike item, RecipeCategory storageCategory, ItemLike storage) {
		nineBlockStorageRecipes(consumer, itemCategory, item, storageCategory, storage, UpgradeAquatic.MOD_ID + ":" + getSimpleRecipeName(storage), null, UpgradeAquatic.MOD_ID + ":" + getSimpleRecipeName(item), null);
	}

	public static void oneToOneConversionRecipe(Consumer<FinishedRecipe> consumer, ItemLike output, ItemLike input, @Nullable String group) {
		oneToOneConversionRecipe(consumer, output, input, group, 1);
	}

	public static void oneToOneConversionRecipe(Consumer<FinishedRecipe> consumer, ItemLike output, ItemLike input, @Nullable String group, int count) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, count).requires(input).group(group).unlockedBy(getHasName(input), has(input)).save(consumer, getModConversionRecipeName(output, input));
	}

	public static void stonecutterResultFromBase(Consumer<FinishedRecipe> consumer, RecipeCategory category, ItemLike output, ItemLike input) {
		stonecutterResultFromBase(consumer, category, output, input, 1);
	}

	public static void stonecutterResultFromBase(Consumer<FinishedRecipe> consumer, RecipeCategory category, ItemLike output, ItemLike input, int count) {
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), category, output, count).unlockedBy(getHasName(input), has(input)).save(consumer, getModConversionRecipeName(output, input) + "_stonecutting");
	}

	protected static ResourceLocation getModConversionRecipeName(ItemLike output, ItemLike input) {
		return new ResourceLocation(UpgradeAquatic.MOD_ID, getConversionRecipeName(output, input));
	}
}