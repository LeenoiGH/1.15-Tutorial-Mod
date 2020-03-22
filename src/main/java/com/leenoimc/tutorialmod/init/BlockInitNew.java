package com.leenoimc.tutorialmod.init;

import com.leenoimc.tutorialmod.TutorialMod;
import com.leenoimc.tutorialmod.objects.blocks.ModWoodButtonBlock;
import com.leenoimc.tutorialmod.objects.blocks.ModWoodPressurePlateBlock;

import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitNew {
	
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);
	
	public static final RegistryObject<Block> DEF_BLOCK = BLOCKS.register("def_block", () -> new Block(Block.Properties.create(Material.IRON)));
	
	public static final RegistryObject<Block> TUTORIAL_STAIRS = BLOCKS.register("example_stairs", () -> new StairsBlock(() -> BlockInit.tutorial_block.getDefaultState(), Block.Properties.create(Material.WOOD, MaterialColor.GOLD)));
	public static final RegistryObject<Block> TUTORIAL_FENCE = BLOCKS.register("example_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.GOLD)));
	public static final RegistryObject<Block> TUTORIAL_BUTTON = BLOCKS.register("example_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.GOLD)));
	public static final RegistryObject<Block> TUTORIAL_PRESSURE_PLATE = BLOCKS.register("example_pressure_plate", () -> new ModWoodPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.GOLD)));
}
