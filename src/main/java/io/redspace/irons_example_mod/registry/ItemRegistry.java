package io.redspace.irons_example_mod.registry;

import io.redspace.irons_example_mod.IronsExampleMod;
import io.redspace.irons_example_mod.items.ExampleMagicSword;
import io.redspace.irons_example_mod.items.ForeignArmor;
import io.redspace.irons_example_mod.utils.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IronsExampleMod.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> EXAMPLE_MAGIC_SWORD = ITEMS.register("example_magic_sword", () -> new ExampleMagicSword(new SpellDataRegistryHolder[]{new SpellDataRegistryHolder(ExampleSpellRegistry.SUPER_HEAL_SPELL, 1)}));
    public static final RegistryObject<Item> FOREIGN_HELMET = ITEMS.register("foreign_helmet", () -> new ForeignArmor(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment()));
    public static final RegistryObject<Item> FOREIGN_CHESTPLATE = ITEMS.register("foreign_chestplate", () -> new ForeignArmor(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment()));
    public static final RegistryObject<Item> FOREIGN_LEGGINGS = ITEMS.register("foreign_leggings", () -> new ForeignArmor(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment()));
    public static final RegistryObject<Item> FOREIGN_BOOTS = ITEMS.register("foreign_boots", () -> new ForeignArmor(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment()));

}
