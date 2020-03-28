package com.press_x_for.porkchopmod.events;

import com.press_x_for.porkchopmod.PorkchopMod;
import com.press_x_for.porkchopmod.PorkchopMod.PorkchopItemGroup;
import com.press_x_for.porkchopmod.init.FluidInit;
import com.press_x_for.porkchopmod.init.ItemInit;
import com.press_x_for.porkchopmod.objects.fluids.FluidGrease;
import com.press_x_for.porkchopmod.objects.fluids.FluidGrease.Flowing;
import com.press_x_for.porkchopmod.objects.fluids.FluidGrease.Source;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = PorkchopMod.MOD_ID, bus = Bus.MOD)
public class RegistryEvents {

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {

		event.getRegistry()
				.registerAll(ItemInit.GREASE_BUCKET = new BucketItem(() -> FluidInit.grease,
						new Item.Properties().group(PorkchopItemGroup.instance).maxStackSize(1))
								.setRegistryName("grease_bucket"));

	}


	@SubscribeEvent
	public static void registerFluids(final RegistryEvent.Register<Fluid> event) {

		event.getRegistry().registerAll(
				FluidInit.grease_flowing = (Flowing) new FluidGrease.Flowing()
						.setRegistryName(location("flowing_grease")),
				FluidInit.grease = (Source) new FluidGrease.Source().setRegistryName(location("grease_fluid"))

		);

	}

	public static ResourceLocation location(String name) {
		return new ResourceLocation(PorkchopMod.MOD_ID, name);
	}

}
