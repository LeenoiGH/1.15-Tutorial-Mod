package com.leenoimc.tutorialmod.init;

import com.leenoimc.tutorialmod.TutorialMod;
import com.leenoimc.tutorialmod.TutorialMod.TutorialItemGroup;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(TutorialMod.MOD_ID)
public class ItemInit {
	public static final Item tutorial_item = null;
	public static final Item tutorial_food = null;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry()
				.register(new Item(new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("tutorial_item"));

		event.getRegistry()
				.register(new Item(new Item.Properties().group(TutorialItemGroup.instance)
						.food(new Food.Builder().hunger(20).saturation(40.0F)
								.effect(new EffectInstance(Effects.GLOWING, 60, 3), 6.0F).build()))
										.setRegistryName("tutorial_food"));
	}
}
