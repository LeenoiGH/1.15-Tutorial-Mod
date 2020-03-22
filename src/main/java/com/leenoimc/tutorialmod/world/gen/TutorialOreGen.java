package com.leenoimc.tutorialmod.world.gen;

import com.leenoimc.tutorialmod.init.BlockInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

// Unfortunately, this code is currently broken. I will either fix it or I will find a new method.
public class TutorialOreGen {
	public static void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if(biome == Biomes.PLAINS) {  
                ConfiguredPlacement<?> customConfig = Placement.COUNT_RANGE
                    .configure(new CountRangeConfig(200, 300, 100, 300));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,BlockInit.tutorial_block.getDefaultState(), 100)).withPlacement(customConfig));
            }
        }
    }
}
