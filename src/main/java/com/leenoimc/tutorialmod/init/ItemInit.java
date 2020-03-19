package com.leenoimc.tutorialmod.init;

import java.util.function.Supplier;

import com.leenoimc.tutorialmod.TutorialMod;
import com.leenoimc.tutorialmod.TutorialMod.TutorialItemGroup;
import com.leenoimc.tutorialmod.objects.items.SpecialItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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
	public static final Item special_item = null;

	// Tools
	public static final Item tutorial_pickaxe = null;
	public static final Item tutorial_axe = null;
	public static final Item tutorial_sword = null;
	public static final Item tutorial_shovel = null;
	public static final Item tutorial_hoe = null;

	// Armour
	public static final Item tutorial_helmet = null;
	public static final Item tutorial_chestplate = null;
	public static final Item tutorial_leggings = null;
	public static final Item tutorial_boots = null;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(
				new Item(new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("tutorial_item"));

		event.getRegistry().register(new SpecialItem(new Item.Properties().group(TutorialItemGroup.instance))
				.setRegistryName("special_item"));

		// Food
		event.getRegistry()
				.register(new Item(new Item.Properties().group(TutorialItemGroup.instance)
						.food(new Food.Builder().hunger(20).saturation(40.0F)
								.effect(new EffectInstance(Effects.GLOWING, 60, 3), 6.0F).build()))
										.setRegistryName("tutorial_food"));

		// Tools
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

		// Armour
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.HEAD,
				new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("tutorial_helmet"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.CHEST,
				new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("tutorial_chestplate"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.LEGS,
				new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("tutorial_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.FEET,
				new Item.Properties().group(TutorialItemGroup.instance)).setRegistryName("tutorial_boots"));
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

	public enum ModArmorMaterial implements IArmorMaterial {
		TEST(TutorialMod.MOD_ID + ":test", 5, new int[] { 50, 70, 110, 50 }, 420, SoundEvents.field_226124_Y_, 6.9F, () -> {
			return Ingredient.fromItems(ItemInit.tutorial_item); // For some reason eclipse crashes when i edit this
																	// ItemInit part. If you're getting the same problem
																	// please edit outside of eclipse
		});

		private static final int[] MAX_DAMAGE_ARRAY = new int[] { 50, 50, 50, 50 };
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;

		private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
				int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn,
				Supplier<Ingredient> repairMaterialIn) {
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}

		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public SoundEvent getSoundEvent() {
			return this.soundEvent;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public float getToughness() {
			return this.toughness;
		}
	}
}
