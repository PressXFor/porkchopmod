package com.press_x_for.porkchopmod.objects.fluids;

import com.press_x_for.porkchopmod.events.RegistryEvents;
import com.press_x_for.porkchopmod.init.BlockInit;
import com.press_x_for.porkchopmod.init.FluidInit;
import com.press_x_for.porkchopmod.init.ItemInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;

public abstract class FluidGrease extends FlowingFluid {

	@Override
	public Fluid getFlowingFluid() {
		return FluidInit.grease_flowing;
	}

	@Override
	public Fluid getStillFluid() {
		return FluidInit.grease;
	}

	@Override
	protected boolean canSourcesMultiply() {
		return true;
	}

	@Override
	protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
		
	}

	@Override
	protected int getSlopeFindDistance(IWorldReader worldIn) {
		return 4;
	}

	@Override
	protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
		return 3;
	}

	@Override
	public Item getFilledBucket() {
		return ItemInit.GREASE_BUCKET;
	}

	@Override
	protected boolean canDisplace(IFluidState state, IBlockReader world, BlockPos pos, Fluid fluid, Direction direction) {
		return direction == Direction.DOWN && !fluid.isIn(FluidInit.Tags.grease);
	}

	@Override
	public int getTickRate(IWorldReader p_205569_1_) {
		return 30;
	}

	@Override
	protected float getExplosionResistance() {
		return 100.0f;
	}

	@Override
	protected BlockState getBlockState(IFluidState state) {
		return BlockInit.GREASE.get().getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state)));
	}
	
	@Override
	public boolean isEquivalentTo(Fluid fluidIn) {
		return fluidIn == FluidInit.grease || fluidIn == FluidInit.grease_flowing;
	}
	
	@Override
	protected FluidAttributes createAttributes() {
		return FluidAttributes.builder(RegistryEvents.location("blocks/grease_still"), RegistryEvents.location("blocks/grease_flow"))
		.translationKey("block.porkchopmod.grease")
		.build(this);
	}
	
	public static class Flowing extends FluidGrease {
		
		@Override
		protected void fillStateContainer(Builder<Fluid, IFluidState> builder) {
			super.fillStateContainer(builder);
			builder.add(LEVEL_1_8);
		}
		
		@Override
		public boolean isSource(IFluidState state) {
			return false;
		}

		@Override
		public int getLevel(IFluidState state) {
			return state.get(FluidGrease.LEVEL_1_8);
		}
		
	}
	
	public static class Source extends FluidGrease {

		@Override
		public boolean isSource(IFluidState state) {
			return true;
		}

		@Override
		public int getLevel(IFluidState state) {
			return 8;
		}
		
	}
	
	


}
