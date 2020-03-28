package com.press_x_for.porkchopmod.init;

import com.press_x_for.porkchopmod.events.RegistryEvents;
import com.press_x_for.porkchopmod.objects.fluids.FluidGrease;

import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;

public class FluidInit {

	public static FluidGrease.Source grease = null;
	public static FluidGrease.Flowing grease_flowing = null;

	public static class Tags {
		public static final Tag<Fluid> grease = new FluidTags.Wrapper(RegistryEvents.location("grease_still"));
	}
}
