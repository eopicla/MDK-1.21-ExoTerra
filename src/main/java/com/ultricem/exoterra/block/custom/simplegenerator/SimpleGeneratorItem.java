package com.ultricem.exoterra.block.custom.simplegenerator;

import com.ultricem.exoterra.Config;
import com.ultricem.exoterra.ETDataComponents;
import com.ultricem.exoterra.utils.MagicHelpers;
import net.minecraft.world.item.BlockItem;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class SimpleGeneratorItem extends BlockItem {

    public SimpleGeneratorItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || mc.player == null) {
            return;
        }

        int power = stack.getOrDefault(ETDataComponents.ENERGY, 0);
        if (power == 0)
            return;

        tooltip.add(Component.translatable("screen.exoterra.energy", MagicHelpers.withSuffix(power), MagicHelpers.withSuffix(Config.GENERAL.simpleGenMaxPower.get())).withStyle(ChatFormatting.GREEN));
    }

    @Override
    protected boolean updateCustomBlockEntityTag(BlockPos pos, Level worldIn, @Nullable Player player, ItemStack stack, BlockState state) {
        BlockEntity te = worldIn.getBlockEntity(pos);
        if (te instanceof SimpleGeneratorBE) {
            SimpleGeneratorBE station = (SimpleGeneratorBE) te;
            station.energyStorage.receiveEnergy(stack.getOrDefault(ETDataComponents.ENERGY, 0), false);
        }

        return super.updateCustomBlockEntityTag(pos, worldIn, player, stack, state);
    }
}
