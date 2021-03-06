package com.leenoimc.tutorialmod.init;

import com.leenoimc.tutorialmod.TutorialMod;
import com.leenoimc.tutorialmod.TutorialMod.TutorialItemGroup;
import com.leenoimc.tutorialmod.objects.blocks.BlockQuarry;
import com.leenoimc.tutorialmod.objects.blocks.SpecialBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(TutorialMod.MOD_ID)
@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Bus.MOD)
public class BlockInit {
	public static final Block tutorial_block = null;
	public static final Block special_block = null;
	public static final Block quarry = null;

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 3.0F)
				.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)).setRegistryName("tutorial_block"));
		event.getRegistry()
				.register(new SpecialBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F, 15.0F)
						.harvestLevel(2).harvestTool(ToolType.AXE).sound(SoundType.ANVIL))
								.setRegistryName("special_block"));
		event.getRegistry().register(new BlockQuarry(Block.Properties.create(Material.IRON)).setRegistryName("quarry"));
	}

	@SubscribeEvent()
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry()
				.register(new BlockItem(tutorial_block, new Item.Properties().group(TutorialItemGroup.instance))
						.setRegistryName("tutorial_block"));
		event.getRegistry()
		.register(new BlockItem(special_block, new Item.Properties().group(TutorialItemGroup.instance))
				.setRegistryName("special_block"));
		event.getRegistry().register(new BlockItem(quarry, new Item.Properties().group(TutorialItemGroup.instance))
				.setRegistryName("quarry"));
	}
}