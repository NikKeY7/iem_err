package ru.nikkey.adventure.client.armor;

import ru.nikkey.adventure.items.armor.JailArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class JailArmorRender extends GeoArmorRenderer<JailArmorItem> {
    public JailArmorRender() {
        super(new JailArmorModel());
    }
}
