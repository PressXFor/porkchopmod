package com.press_x_for.porkchopmod.world.feature;

import java.util.Random;

import com.press_x_for.porkchopmod.init.BlockInit;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class GreaseTree extends Tree {

	public static final TreeFeatureConfig GREASE_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.GREASE_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.GREASE_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(2, 0)))
					.baseHeight(4).heightRandA(3).foliageHeight(3).ignoreVines()
					.setSapling((IPlantable) BlockInit.GREASE_SAPLING.get()).build();
	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(GREASE_TREE_CONFIG);
	}
}
