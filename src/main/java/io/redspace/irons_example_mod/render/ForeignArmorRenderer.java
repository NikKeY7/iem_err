package io.redspace.irons_example_mod.render;

import io.redspace.irons_example_mod.IronsExampleMod;
import io.redspace.irons_example_mod.items.ForeignArmor;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class ForeignArmorRenderer extends DefaultedItemGeoModel<ForeignArmor> {

    public ForeignArmorRenderer(){
        super(new ResourceLocation(IronsExampleMod.MODID, ""));
    }

    @Override
    public ResourceLocation getModelResource(ForeignArmor object) {
        return new ResourceLocation(IronsExampleMod.MODID, "geo/foreign_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ForeignArmor object) {
        return new ResourceLocation(IronsExampleMod.MODID, "textures/models/armor/foreign.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ForeignArmor animatable) {
        return new ResourceLocation(IronsExampleMod.MODID, "animations/wizard_armor_animation.json");
    }
}
