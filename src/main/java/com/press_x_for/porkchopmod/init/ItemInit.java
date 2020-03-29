package com.press_x_for.porkchopmod.init;

import com.google.common.base.Supplier;
import com.press_x_for.porkchopmod.PorkchopMod;
import com.press_x_for.porkchopmod.PorkchopMod.PorkchopItemGroup;

import net.minecraft.item.BlockItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = PorkchopMod.MOD_ID, bus = Bus.MOD)
public class ItemInit {

	public static Item GREASE_BUCKET;

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,
			PorkchopMod.MOD_ID);

	public static final RegistryObject<Item> UNCOOKED_BACON_STRIP = ITEMS.register("uncooked_bacon_strip",
			() -> new Item(new Item.Properties().group(PorkchopItemGroup.instance)));

	public static final RegistryObject<Item> PORK_BITS = ITEMS.register("pork_bits",
			() -> new Item(new Item.Properties().group(PorkchopItemGroup.instance)));
	
	public static final RegistryObject<Item> PORK_INGOT = ITEMS.register("pork_ingot",
			() -> new Item(new Item.Properties().group(PorkchopItemGroup.instance)));

	public static final RegistryObject<Item> PORKCHOP_ORE = ITEMS.register("pork_ore",
			() -> new BlockItem(BlockInit.PORKCHOP_ORE.get(), new Item.Properties().group(PorkchopItemGroup.instance)));

	public static final RegistryObject<Item> GREASE_DIRT = ITEMS.register("pork_dirt_item",
			() -> new BlockItem(BlockInit.GREASE_DIRT.get(), new Item.Properties().group(PorkchopItemGroup.instance)));

	// Tools

	public static final RegistryObject<Item> PORKCHOP_SWORD = ITEMS.register("porkchop_sword",
			() -> new SwordItem(ModItemTier.PORKCHOP, 7, 5.0f,
					new Item.Properties().group(PorkchopItemGroup.instance)));

	public static final RegistryObject<Item> PORKCHOP_PICKAXE = ITEMS.register("porkchop_pickaxe",
			() -> new SwordItem(ModItemTier.PORKCHOP, 4, 5.0f,
					new Item.Properties().group(PorkchopItemGroup.instance)));

	public static final RegistryObject<Item> PORKCHOP_SHOVEL = ITEMS.register("porkchop_shovel",
			() -> new SwordItem(ModItemTier.PORKCHOP, 2, 5.0f,
					new Item.Properties().group(PorkchopItemGroup.instance)));

	public static final RegistryObject<Item> PORKCHOP_AXE = ITEMS.register("porkchop_axe",
			() -> new SwordItem(ModItemTier.PORKCHOP, 11, 5.0f,
					new Item.Properties().group(PorkchopItemGroup.instance)));

	public static final RegistryObject<Item> PORKSHOP_HOE = ITEMS.register("porkchop_hoe",
			() -> new SwordItem(ModItemTier.PORKCHOP, 5, 5.0f,
					new Item.Properties().group(PorkchopItemGroup.instance)));

	// Tier
	public enum ModItemTier implements IItemTier {
		PORKCHOP(4, 1500, 15.0F, 7.0F, 250, () -> {
			return Ingredient.fromItems(ItemInit.PORK_BITS.get());
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
