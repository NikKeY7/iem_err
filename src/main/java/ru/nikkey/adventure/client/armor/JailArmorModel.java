package ru.nikkey.adventure.client.armor;

import net.minecraft.resources.ResourceLocation;
import ru.nikkey.adventure.Adventure;
import ru.nikkey.adventure.items.armor.JailArmorItem;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.model.GeoModel;

public class JailArmorModel extends GeoModel<JailArmorItem> {
    @Override
    public ResourceLocation getModelResource(JailArmorItem jailArmorItem) {
        return new ResourceLocation(Adventure.MODID + "geo/CustomArmor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(JailArmorItem jailArmorItem) {
        return new ResourceLocation(Adventure.MODID + "textures/armor/jail_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(JailArmorItem jailArmorItem) {
        return new ResourceLocation(Adventure.MODID + "animations/custom_armor.animation.json");
    }
}
