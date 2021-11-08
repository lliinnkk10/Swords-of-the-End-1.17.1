package com.github.atheera.swordsoftheend.client.gui;

import com.github.atheera.swordsoftheend.inits.ContainerInit;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import com.github.atheera.swordsoftheend.materials.SOTEHooks;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nonnull;

public class LightsaberContainer extends AbstractContainerMenu {

    private final Player player;
    private final IItemHandler playerInventory;

    private final ItemStackHandler itemCrystalHandler = createHandler();
    private final LazyOptional<IItemHandler> crystalHandler = LazyOptional.of(() -> itemCrystalHandler);
    private final ItemStackHandler itemBatteryHandler = createBatteryHandler();
    private final LazyOptional<IItemHandler> batteryHandler = LazyOptional.of(() -> itemBatteryHandler);

    public LightsaberContainer(int windowId, Level world, Inventory playerInventory, Player player) {
        super(ContainerInit.LIGHTSABER_CONTAINER.get(), windowId);
        this.player = player;
        this.playerInventory = new InvWrapper(playerInventory);

        addSlot(new SlotItemHandler(itemCrystalHandler, 0, 81, 23));
        //addSlot(new SlotItemHandler(itemBatteryHandler, 1, 51, 45));

        layoutPlayerInventorySlots(10, 70);
    }

    private ItemStackHandler createBatteryHandler() {
        return new ItemStackHandler(1) {
            @Override
            protected void onContentsChanged(int slot) {
                super.onContentsChanged(slot);
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                Item item = stack.getItem();
              //  return (item == ItemInit.ITEM_BATTERY_LIGHTSABER.get());
                return true;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                Item item = stack.getItem();
               // if(item == ItemInit.ITEM_BATTERY_LIGHTSABER.get()) {return stack;}

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(1) {
            @Override
            protected void onContentsChanged(int slot) {
                super.onContentsChanged(slot);
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return SOTEHooks.isCrystalValid(stack);
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!SOTEHooks.isCrystalValid(stack)) {
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if(slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();
            itemStack = stack.copy();
            if(index == 0 || index == 1) {
                if(!this.moveItemStackTo(stack, 1, 37, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(stack, itemStack);
            } else {
                if(SOTEHooks.isCrystalValid(stack)) {
                    if(!this.moveItemStackTo(stack, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } //else if(stack.getItem() == ItemInit.ITEM_BATTERY_LIGHTSABER.get()) {if(!this.moveItemStackTo(stack, 1, 2, false)) {return ItemStack.EMPTY;}}
                else if(index < 29) {
                    if(!this.moveItemStackTo(stack, 29, 38, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if(index < 38 && !this.moveItemStackTo(stack, 2, 29, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if(stack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
            if(stack.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, stack);
        }

        return itemStack;
    }

    @Override
    public boolean stillValid(Player p_38874_) {
        return false;
    }

    private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
        for(int i = 0; i < amount; i++) {
            addSlot(new SlotItemHandler(handler, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for(int j = 0; j < verAmount; j++) {
            index = addSlotRange(handler, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

    private void layoutPlayerInventorySlots(int leftCol, int topRow) {
        addSlotBox(playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);

        topRow += 58;
        addSlotRange(playerInventory, 0, leftCol, topRow, 9, 18);
    }

}