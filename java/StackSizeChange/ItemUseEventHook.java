package StackSizeChange;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

/**
 * Created by A.K. on 14/10/23.
 */
public class ItemUseEventHook {

    @SubscribeEvent
    public void itemUseFinish(PlayerUseItemEvent.Finish event) {
        if (event.entityPlayer.worldObj.isRemote) return;
        EntityPlayer player = event.entityPlayer;
        ItemStack useItemStack = event.item;
        ItemStack resultItemStack = event.result;
        if (useItemStack == null) return;
        if (player.capabilities.isCreativeMode) return;
        if (useItemStack.getItem() instanceof ItemPotion) {
            potionUseFinish(useItemStack, resultItemStack, player);
        }

        if (useItemStack.getItem() instanceof ItemSoup) {
            if (useItemStack.stackSize <= 0) return;
            event.result = useItemStack;
            player.inventory.addItemStackToInventory(new ItemStack(Items.bowl));
            dropEmptyItem(new ItemStack(Items.bowl), player);
        }

        if (useItemStack.getItem() instanceof ItemBucketMilk) {
            if (useItemStack.stackSize <= 0) return;
            player.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
            dropEmptyItem(new ItemStack(Items.bucket), player);
        }
    }

    public void potionUseFinish(ItemStack potionStack, ItemStack result, EntityPlayer player) {
        if (!potionStack.isItemEqual(result)) return;
        dropEmptyItem(new ItemStack(Items.glass_bottle), player);
    }

    public void dropEmptyItem(ItemStack emptyItemStack, EntityPlayer player) {
        int emptySlot = player.inventory.getFirstEmptyStack();
        if (emptySlot >= 0) return;
        for (ItemStack itemStack : player.inventory.mainInventory) {
            if (itemStack == null) continue;
            if (itemStack.isItemEqual(emptyItemStack) && itemStack.stackSize < itemStack.getMaxStackSize()) {
                return;
            }
        }
        player.dropPlayerItemWithRandomChoice(emptyItemStack, false);
    }
}
