package io.redspace.irons_example_mod.items.armor;

import io.redspace.irons_example_mod.materials.ExtendedArmorMaterials;
import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public abstract class ImbuableChestplateArmorItem extends ExtendedArmorItem implements IPresetSpellContainer {
    public ImbuableChestplateArmorItem(ExtendedArmorMaterials material, Type type, Properties settings) {
        super(material, type, settings);
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }

        if (itemStack.getItem() instanceof ArmorItem armorItem && armorItem.getType() == ArmorItem.Type.CHESTPLATE) {
            if (!ISpellContainer.isSpellContainer(itemStack)) {
                var spellContainer = ISpellContainer.create(1, true, true);
                spellContainer.save(itemStack);
            }
        }
    }
}