package ru.nikkey.adventure;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import ru.nikkey.adventure.items.BaseItem;
import ru.nikkey.adventure.items.GlownItem;
import ru.nikkey.adventure.items.armor.JailArmorItem;

@Mod(Adventure.MODID)
public class Adventure {
    public static final String MODID = "adventure";

    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace

    public static final RegistryObject<Item> ANCIENT_CORE = ITEMS.register("ancient_core",  BaseItem::new);
    public static final RegistryObject<Item> ANCIENT_TEMPLATE = ITEMS.register("ancient_template",  BaseItem::new);
    public static final RegistryObject<Item> ENCHANT_TEMPLATE = ITEMS.register("enchant_template", GlownItem::new);
    public static final RegistryObject<Item> DRAGON_TEMPLATE = ITEMS.register("dragon_template", BaseItem::new);
    public static final RegistryObject<Item> FOREIGN_INGOT = ITEMS.register("foreign_ingot", BaseItem::new);

    public static final RegistryObject<Item> JAIL_HELMET = ITEMS.register("jail_helmet", ()-> new JailArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> JAIL_CHESTPLATE = ITEMS.register("jail_chestplate", ()-> new JailArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> JAIL_LEGGIGNS = ITEMS.register("jail_leggings", ()-> new JailArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> JAIL_BOOTS = ITEMS.register("jail_boots", ()-> new JailArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("adventure_items", () -> CreativeModeTab.builder()
            .icon(() -> ANCIENT_CORE.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.adventure_items"))
            .displayItems((parameters, output) -> {
                output.accept(ANCIENT_CORE.get());
                output.accept(ANCIENT_TEMPLATE.get());
                output.accept(ENCHANT_TEMPLATE.get());
                output.accept(DRAGON_TEMPLATE.get());
                output.accept(FOREIGN_INGOT.get());


                output.accept(JAIL_HELMET.get());

                output.accept(JAIL_CHESTPLATE.get());

                output.accept(JAIL_LEGGIGNS.get());

                output.accept(JAIL_BOOTS.get());
            }).build());
    public Adventure()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

//    private void addCreative(BuildCreativeModeTabContentsEvent event)
//    {
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
//            event.accept(ANCIENT_CORE);
//    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
