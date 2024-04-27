package com.teamabnormals.upgrade_aquatic.core.data.server;

import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import com.teamabnormals.boatload.core.data.server.BoatloadRecipeProvider;
import com.teamabnormals.upgrade_aquatic.common.block.CoralType;
import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;
import com.teamabnormals.upgrade_aquatic.core.other.UABlockFamilies;
import com.teamabnormals.upgrade_aquatic.core.other.tags.UAItemTags;
import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks;
import com.teamabnormals.upgrade_aquatic.core.registry.UAItems;
import com.teamabnormals.upgrade_aquatic.integration.boatload.UABoatTypes;
import com.teamabnormals.woodworks.core.data.server.WoodworksRecipeProvider;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.BlockFamily.Variant;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

import static com.teamabnormals.upgrade_aquatic.core.registry.UABlocks.*;

public class UARecipeProvider extends BlueprintRecipeProvider {

	public UARecipeProvider(PackOutput output) {
		super(UpgradeAquatic.MOD_ID, output);
	}

	@Override
	public void buildRecipes(Consumer<FinishedRecipe> consumer) {
		conversionRecipe(consumer, Items.PINK_DYE, PINK_SEAROCKET.get(), "pink_dye");
		conversionRecipe(consumer, Items.WHITE_DYE, WHITE_SEAROCKET.get(), "white_dye");
		conversionRecipe(consumer, Items.CYAN_DYE, PICKERELWEED.get(), "cyan_dye");
		conversionRecipe(consumer, Items.PINK_DYE, FLOWERING_RUSH.get(), "pink_dye", 2);
		conversionRecipe(consumer, Items.MAGENTA_DYE, UAItems.MULBERRY.get(), "magenta_dye");

		foodCookingRecipes(consumer, UAItems.PIKE.get(), UAItems.COOKED_PIKE.get());
		foodCookingRecipes(consumer, UAItems.PERCH.get(), UAItems.COOKED_PERCH.get());
		foodCookingRecipes(consumer, UAItems.LIONFISH.get(), UAItems.COOKED_LIONFISH.get());
		foodCookingRecipes(consumer, PICKERELWEED.get(), UAItems.BOILED_PICKERELWEED.get());

		storageRecipes(consumer, RecipeCategory.MISC, Items.SCUTE, RecipeCategory.BUILDING_BLOCKS, SCUTE_BLOCK.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, UABlocks.SCUTE_SHINGLES.get(), 8).define('#', Blocks.STONE_BRICKS).define('S', Items.SCUTE).pattern("###").pattern("#S#").pattern("###").unlockedBy("has_scute", has(Items.SCUTE)).save(consumer);
		generateRecipes(consumer, UABlockFamilies.SCUTE_SHINGLES_FAMILY);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_SHINGLE_SLAB.get(), SCUTE_SHINGLES.get(), 2);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_SHINGLE_STAIRS.get(), SCUTE_SHINGLES.get());
		stonecutterRecipe(consumer, RecipeCategory.DECORATIONS, SCUTE_SHINGLE_WALL.get(), SCUTE_SHINGLES.get());
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CHISELED_SCUTE_SHINGLES.get(), SCUTE_SHINGLES.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, SCUTE_PAVEMENT.get(), 4).define('#', SCUTE_SHINGLES.get()).pattern("##").pattern("##").unlockedBy("has_scute_shingles", has(SCUTE_SHINGLES.get())).save(consumer);
		generateRecipes(consumer, UABlockFamilies.SCUTE_PAVEMENT_FAMILY);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_PAVEMENT_SLAB.get(), SCUTE_PAVEMENT.get(), 2);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_PAVEMENT_STAIRS.get(), SCUTE_PAVEMENT.get());
		stonecutterRecipe(consumer, RecipeCategory.DECORATIONS, SCUTE_PAVEMENT_WALL.get(), SCUTE_PAVEMENT.get());
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_PAVEMENT.get(), SCUTE_SHINGLES.get());
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_PAVEMENT_SLAB.get(), SCUTE_SHINGLES.get(), 2);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_PAVEMENT_STAIRS.get(), SCUTE_SHINGLES.get());
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, SCUTE_PAVEMENT_WALL.get(), SCUTE_SHINGLES.get());

		storageRecipes(consumer, RecipeCategory.MISC, UAItems.THRASHER_TOOTH.get(), RecipeCategory.BUILDING_BLOCKS, TOOTH_BLOCK.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, UABlocks.TOOTH_BRICKS.get(), 8).define('#', Blocks.STONE_BRICKS).define('S', UAItems.THRASHER_TOOTH.get()).pattern("###").pattern("#S#").pattern("###").unlockedBy("has_thrasher_tooth", has(UAItems.THRASHER_TOOTH.get())).save(consumer);
		generateRecipes(consumer, UABlockFamilies.TOOTH_BRICKS_FAMILY);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_BRICK_SLAB.get(), TOOTH_BRICKS.get(), 2);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_BRICK_STAIRS.get(), TOOTH_BRICKS.get());
		stonecutterRecipe(consumer, RecipeCategory.DECORATIONS, TOOTH_BRICK_WALL.get(), TOOTH_BRICKS.get());
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CHISELED_TOOTH_BRICKS.get(), TOOTH_BRICKS.get());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TOOTH_TILES.get(), 4).define('#', TOOTH_BRICKS.get()).pattern("##").pattern("##").unlockedBy("has_tooth_bricks", has(TOOTH_BRICKS.get())).save(consumer);
		generateRecipes(consumer, UABlockFamilies.TOOTH_TILES_FAMILY);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_TILE_SLAB.get(), TOOTH_TILES.get(), 2);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_TILE_STAIRS.get(), TOOTH_TILES.get());
		stonecutterRecipe(consumer, RecipeCategory.DECORATIONS, TOOTH_TILE_WALL.get(), TOOTH_TILES.get());
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_TILES.get(), TOOTH_BRICKS.get());
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_TILE_SLAB.get(), TOOTH_BRICKS.get(), 2);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_TILE_STAIRS.get(), TOOTH_BRICKS.get());
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TOOTH_TILE_WALL.get(), TOOTH_BRICKS.get());

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

		generateRecipes(consumer, UABlockFamilies.CORALSTONE_FAMILY);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CORALSTONE_SLAB.get(), CORALSTONE.get(), 2);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CORALSTONE_STAIRS.get(), CORALSTONE.get());
		stonecutterRecipe(consumer, RecipeCategory.DECORATIONS, CORALSTONE_WALL.get(), CORALSTONE.get());

		generateRecipes(consumer, UABlockFamilies.DEAD_CORALSTONE_FAMILY);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, DEAD_CORALSTONE_SLAB.get(), DEAD_CORALSTONE.get(), 2);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, DEAD_CORALSTONE_STAIRS.get(), DEAD_CORALSTONE.get());
		stonecutterRecipe(consumer, RecipeCategory.DECORATIONS, DEAD_CORALSTONE_WALL.get(), DEAD_CORALSTONE.get());

		generateRecipes(consumer, UABlockFamilies.ELDER_PRISMARINE_CORALSTONE_FAMILY);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, ELDER_PRISMARINE_CORALSTONE_SLAB.get(), ELDER_PRISMARINE_CORALSTONE.get(), 2);
		stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, ELDER_PRISMARINE_CORALSTONE_STAIRS.get(), ELDER_PRISMARINE_CORALSTONE.get());
		stonecutterRecipe(consumer, RecipeCategory.DECORATIONS, ELDER_PRISMARINE_CORALSTONE_WALL.get(), ELDER_PRISMARINE_CORALSTONE.get());

		CoralType.values().forEach(coralType -> {
			BlockFamily family = coralType.coralstoneFamily();
			coralBlockRecipe(consumer, coralType.coralBlock().get(), coralType.coral().get(), coralType.itemTag());
			coralBlockRecipe(consumer, coralType.deadCoralBlock().get(), coralType.deadCoral().get(), coralType.deadItemTag());
			generateRecipes(consumer, coralType.coralstoneFamily());
			stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, family.get(Variant.SLAB), family.getBaseBlock(), 2);
			stonecutterRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, family.get(Variant.STAIRS), family.getBaseBlock());
			stonecutterRecipe(consumer, RecipeCategory.DECORATIONS, family.get(Variant.WALL), family.getBaseBlock());
		});
	}

	public void coralBlockRecipe(Consumer<FinishedRecipe> consumer, Block coralBlock, Block coral, TagKey<Item> itemTag) {
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, coralBlock).define('#', itemTag).pattern("##").pattern("##").unlockedBy(getHasName(coral), has(itemTag)).save(consumer, new ResourceLocation(this.getModID(), RecipeBuilder.getDefaultRecipeId(coralBlock).getPath()));
	}
}