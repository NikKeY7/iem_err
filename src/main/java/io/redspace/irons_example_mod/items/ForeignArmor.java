package io.redspace.irons_example_mod.items;

import io.redspace.irons_example_mod.items.armor.ImbuableChestplateArmorItem;
import io.redspace.irons_example_mod.render.ForeignArmorRenderer;
import io.redspace.irons_example_mod.materials.ExtendedArmorMaterials;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ForeignArmor extends ImbuableChestplateArmorItem {
    public ForeignArmor(Type type, Properties settings) {
        super(ExtendedArmorMaterials.FOREIGN, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GeoArmorRenderer<>(new ForeignArmorRenderer());
    }
}
