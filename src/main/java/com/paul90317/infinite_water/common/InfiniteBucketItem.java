package com.paul90317.infinite_water.common;

import com.paul90317.infinite_water.MainMod;
import com.paul90317.infinite_water.core.init.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import javax.annotation.Nullable;

public class InfiniteBucketItem extends BucketItem {
    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return itemStack.copy();
    }

    /**
     * @param supplier A fluid supplier such as {@link net.minecraftforge.registries.RegistryObject<Fluid>}
     */

    public InfiniteBucketItem(java.util.function.Supplier<? extends Fluid> supplier) {
        super(supplier,new Properties().stacksTo(1).tab(MainMod.MOD_TAB));
    }
    private static InteractionResultHolder<ItemStack> result_copy(InteractionResult res, ItemStack itemstack,boolean world_isClientSide){
        switch(res){
            case PASS:
                return InteractionResultHolder.pass(itemstack);
            case FAIL:
                return InteractionResultHolder.fail(itemstack);
            case SUCCESS:
                return InteractionResultHolder.success(itemstack);
            case CONSUME_PARTIAL:
                return InteractionResultHolder.sidedSuccess(itemstack,world_isClientSide);
            case CONSUME:
                return InteractionResultHolder.consume(itemstack);
        }
        return InteractionResultHolder.pass(itemstack);
    }
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        InteractionResultHolder<ItemStack> res= super.use(world,player,hand);
        ItemStack handItem=player.getItemInHand(hand);
        return result_copy(res.getResult(),
                handItem.isEmpty()? ModItems.InfiniteVoid.get().getDefaultInstance():handItem
                ,world.isClientSide());
    }
}
