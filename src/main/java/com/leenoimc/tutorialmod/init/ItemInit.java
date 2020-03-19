package com.leenoimc.tutorialmod.init;

import java.util.function.Supplier;

import com.leenoimc.tutorialmod.TutorialMod;
import com.leenoimc.tutorialmod.TutorialMod.TutorialItemGroup;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
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

	// Tools
	public static final Item tutorial_pickaxe = null;
	public static final Item tutorial_axe = null;
	public static final Item tutorial_sword = null;
	public static final Item tutorial_shovel = null;
	public static final Item tutorial_hoe = null;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(
				new Item(new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("tutorial_item"));

		event.getRegistry()
				.register(new Item(new Item.Properties().group(TutorialItemGroup.instance)
						.food(new Food.Builder().hunger(20).saturation(40.0F)
								.effect(new EffectInstance(Effects.GLOWING, 60, 3), 6.0F).build()))
										.setRegistryName("tutorial_food"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.TUTORIAL, 10, 10.7F,
				new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("tutorial_pickaxe"));
		event.getRegistry().register(
				new AxeItem(ModItemTier.TUTORIAL, 8, 15.0F, new Item.Properties().group(TutorialItemGroup.instance))
						.setRegistryName("tutorial_axe"));
		event.getRegistry().register(
				new SwordItem(ModItemTier.TUTORIAL, 15, 8.0F, new Item.Properties().group(TutorialItemGroup.instance))
						.setRegistryName("tutorial_sword"));
		event.getRegistry().register(
				new ShovelItem(ModItemTier.TUTORIAL, 10, 10.0F, new Item.Properties().group(TutorialItemGroup.instance))
						.setRegistryName("tutorial_shovel"));
		event.getRegistry().register(
				new HoeItem(ModItemTier.TUTORIAL, 8.0F, new Item.Properties().group(TutorialItemGroup.instance))
						.setRegistryName("tutorial_hoe"));
	}

	public enum ModItemTier implements IItemTier {
		TUTORIAL(150, 200, 200.0F, 400.5F, 200, () -> {
			return Ingredient.fromItems(ItemInit.tutorial_item);
		});

		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;

		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
				Supplier<Ingredient> repairMaterial) {
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public int getMaxUses() {
			return this.maxUses;
		}

		@Override
		public float getEfficiency() {
			return this.efficiency;
		}

		@Override
		public float getAttackDamage() {
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
	}
}
