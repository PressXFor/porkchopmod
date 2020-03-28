package com.press_x_for.porkchopmod.init;

import com.press_x_for.porkchopmod.PorkchopMod;
import com.press_x_for.porkchopmod.PorkchopMod.PorkchopItemGroup;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FoodInit {

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,
			PorkchopMod.MOD_ID);

	public static final RegistryObject<Item> COOKED_BACON_STRIP = ITEMS.register("cooked_bacon_strip",
			() -> new Item(new Item.Properties().group(PorkchopItemGroup.instance)
					.food(new Food.Builder().hunger(8).saturation(1.2f).build())));

}
