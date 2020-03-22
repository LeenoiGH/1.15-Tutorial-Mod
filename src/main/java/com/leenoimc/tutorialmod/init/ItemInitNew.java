package com.leenoimc.tutorialmod.init;

import com.leenoimc.tutorialmod.TutorialMod;
import com.leenoimc.tutorialmod.TutorialMod.TutorialItemGroup;
import com.leenoimc.tutorialmod.objects.items.SpecialItem;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew {
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);
	
	public static final RegistryObject<Item> DEF_ITEM = ITEMS.register("def_item", () -> new SpecialItem(new Item.Properties().group(TutorialItemGroup.instance)));
}
