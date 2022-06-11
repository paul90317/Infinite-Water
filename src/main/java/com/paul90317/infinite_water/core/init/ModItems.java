package com.paul90317.infinite_water.core.init;

import com.paul90317.infinite_water.MainMod;
import com.paul90317.infinite_water.common.InfiniteBucketItem;
import com.paul90317.infinite_water.common.InfiniteMilkItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MainMod.MOD_ID);
    public static final RegistryObject<Item> InfiniteWater = ITEMS.register("infinite_water",
            ()->new InfiniteBucketItem(()->Fluids.WATER));
    public static final RegistryObject<Item> InfiniteLava = ITEMS.register("infinite_lava",
            ()->new InfiniteBucketItem(()->Fluids.LAVA));
    public static final RegistryObject<Item> InfiniteVoid = ITEMS.register("infinite_void",
            ()->new InfiniteBucketItem(()->Fluids.EMPTY));
    public static final RegistryObject<Item> InfiniteMilk = ITEMS.register("infinite_milk",
            ()->new InfiniteMilkItem());

}
