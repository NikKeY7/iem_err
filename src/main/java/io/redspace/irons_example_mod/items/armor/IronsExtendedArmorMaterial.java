package io.redspace.irons_example_mod.items.armor;

import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.Map;

public interface IronsExtendedArmorMaterial extends ArmorMaterial {
    public Map<Attribute, AttributeModifier> getAdditionalAttributes();
}
