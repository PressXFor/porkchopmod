package com.press_x_for.porkchopmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.press_x_for.porkchopmod.init.BlockInit;
import com.press_x_for.porkchopmod.init.FoodInit;
import com.press_x_for.porkchopmod.init.ItemInit;
import com.press_x_for.porkchopmod.world.gen.PorkchopModOreGen;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("porkchopmod")
@Mod.EventBusSubscriber(modid = PorkchopMod.MOD_ID, bus = Bus.MOD)
public class PorkchopMod {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "porkchopmod";
	public static PorkchopMod instance;

	public PorkchopMod() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::doClientStuff);

		ItemInit.ITEMS.register(modEventBus);
		FoodInit.ITEMS.register(modEventBus);
		BlockInit.BLOCKS.register(modEventBus);

		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(PorkchopItemGroup.instance);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});

		ItemInit.UNCOOKED_BACON_STRIP.get();
		ItemInit.PORK_BITS.get();
		FoodInit.COOKED_BACON_STRIP.get();
		BlockInit.GREASE.get();
		BlockInit.PORKCHOP_ORE.get();
		ItemInit.PORKCHOP_ORE.get();
		ItemInit.PORKCHOP_SWORD.get();
		ItemInit.PORKCHOP_PICKAXE.get();
		ItemInit.PORKCHOP_SHOVEL.get();
		ItemInit.PORKCHOP_PICKAXE.get();
		ItemInit.PORKSHOP_HOE.get();
		

		LOGGER.debug("Registered BlockItems!");
	}

	private void setup(final FMLCommonSetupEvent event) {

	}

	private void doClientStuff(final FMLClientSetupEvent event) {

	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {

	}
	
	@SubscribeEvent
	public static void loadCompleteEvent(FMLLoadCompleteEvent event) 
	{
		PorkchopModOreGen.generatOre();
	}
	
	public static class PorkchopItemGroup extends ItemGroup {

		public static final PorkchopItemGroup instance = new PorkchopItemGroup(ItemGroup.GROUPS.length, "porkchoptab");

		public PorkchopItemGroup(int index, String label)

		{
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(Items.PORKCHOP);
		}
	}
}
