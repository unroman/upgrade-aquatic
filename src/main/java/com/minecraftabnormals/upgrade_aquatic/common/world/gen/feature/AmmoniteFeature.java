package com.minecraftabnormals.upgrade_aquatic.common.world.gen.feature;

import java.util.Random;

import com.minecraftabnormals.upgrade_aquatic.common.blocks.EmbeddedAmmoniteBlock;
import com.minecraftabnormals.upgrade_aquatic.core.registry.UABlocks;

import net.minecraft.util.Direction;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class AmmoniteFeature {

    public static void setupGeneration() {
        ForgeRegistries.BIOMES.getValues().stream().forEach(AmmoniteFeature::process);
    }

    public static void process(Biome biome) {
        if (biome.getCategory() == Category.BEACH || biome.getCategory() == Category.OCEAN || biome == Biomes.STONE_SHORE) {
            biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, UABlocks.EMBEDDED_AMMONITE.get().getDefaultState().with(EmbeddedAmmoniteBlock.FACING, Direction.func_239631_a_(new Random())), 3)).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(30, 20, 0, 73))));
        }
    }
}
