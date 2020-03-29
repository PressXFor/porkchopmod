package com.press_x_for.porkchopmod.init;

import com.press_x_for.porkchopmod.PorkchopMod;
import com.press_x_for.porkchopmod.objects.blocks.ModSaplingBlock;
import com.press_x_for.porkchopmod.world.feature.GreaseTree;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
			PorkchopMod.MOD_ID);

	public static final RegistryObject<Block> GREASE = BLOCKS.register("grease",
			() -> new FlowingFluidBlock(() -> FluidInit.grease, Block.Properties.create(Material.WATER).noDrops()));

	public static final RegistryObject<Block> PORKCHOP_ORE = BLOCKS.register("porkchop_ore", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 15.0f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> GREASE_DIRT = BLOCKS.register("grease_dirt",
			() -> new Block(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5f, 0.5f)
					.sound(SoundType.GROUND).slipperiness(0.989f)));

	public static final RegistryObject<Block> GREASE_PLANKS = BLOCKS.register("grease_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> GREASE_LOG = BLOCKS.register("grease_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));

	public static final RegistryObject<Block> GREASE_LEAVES = BLOCKS.register("grease_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> GREASE_SAPLING = BLOCKS.register("grease_sapling",
			() -> new ModSaplingBlock(() -> new GreaseTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
}
