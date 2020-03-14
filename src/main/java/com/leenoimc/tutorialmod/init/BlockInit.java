package com.leenoimc.tutorialmod.init;

import com.leenoimc.tutorialmod.TutorialMod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(TutorialMod.MOD_ID)
@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Bus.MOD)
public class BlockInit
{
	public static final Block tutorial_block = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F,3.0F)
				.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)).setRegistryName("tutorial_block"));
	}
	
	@SubscribeEvent()
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(tutorial_block, new Item.Properties().group(ItemGroup.DECORATIONS))
				.setRegistryName("tutorial_block"));
	}
}
