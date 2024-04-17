package ru.nikkey.adventure.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class GlownItem extends BaseItem{
    public GlownItem() {
        super();
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }
}
