package com.leenoimc.tutorialmod.events;

import com.leenoimc.tutorialmod.TutorialMod;
import com.leenoimc.tutorialmod.init.BlockInit;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

//@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Bus.FORGE) // note: this line could get the game to lag as it places blocks! // another note: the @Mod line activates ethe whole event
public class TestJumpEvent
{
	@SubscribeEvent
	public static void testJumpEvent(LivingJumpEvent event) {
		TutorialMod.LOGGER.info("testJumpEvent fired");
		LivingEntity livingEntity = event.getEntityLiving();
		World world = livingEntity.getEntityWorld();
		world.setBlockState(livingEntity.getPosition().add(0, 5, 0), BlockInit.tutorial_block.getDefaultState());
		livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 600, 255));
		livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5000, 255));
		livingEntity.setGlowing(true);
	}
}
