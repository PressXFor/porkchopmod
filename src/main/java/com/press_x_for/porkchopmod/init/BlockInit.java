package com.press_x_for.porkchopmod.init;

import com.press_x_for.porkchopmod.PorkchopMod;

import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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

}
