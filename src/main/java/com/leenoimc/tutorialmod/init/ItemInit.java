package com.leenoimc.tutorialmod.init;

import com.leenoimc.tutorialmod.TutorialMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(TutorialMod.MOD_ID)
public class ItemInit {
	public static final Item tutorial_item = null;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new Item(new Item.Properties()
				.group(ItemGroup.MISC))
				.setRegistryName("tutorial_item"));
	}
}
