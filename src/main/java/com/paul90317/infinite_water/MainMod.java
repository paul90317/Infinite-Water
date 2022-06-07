package com.paul90317.infinite_water;

import com.paul90317.infinite_water.core.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;

@Mod(MainMod.MOD_ID)
public class MainMod {
    public static final String MOD_ID = "infinite_water";
    public static final CreativeModeTab MOD_TAB=new CreativeModeTab(MOD_ID){
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon(){
            return new ItemStack(ModItems.InfiniteWater.get());
        }
    };

    public MainMod() {
        IEventBus bus=FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
