package net.daelith.eclipse.item;

import net.daelith.eclipse.Tutorialmod;
import net.daelith.eclipse.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ELEMENTAL_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Tutorialmod.MOD_ID, "elemental_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.DARK_STEEL))
                    .displayName(Text.translatable("itemgroup.tutorialmod.elemental_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.DARK_STEEL);
                        entries.add(ModItems.RAW_DARK_STEEL);
                    }).build());

    public static final ItemGroup ELEMENTAL_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Tutorialmod.MOD_ID, "elemental_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.DARK_STEEL_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.elemental_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.DARK_STEEL_BLOCK);
                        entries.add(ModBlocks.RAW_DARK_STEEL_BLOCK);

                        entries.add(ModBlocks.DARK_STEEL_ORE);
                        entries.add(ModBlocks.DARK_STEEL_DEEPSLATE_ORE);

                    }).build());


    public static void registerModItemGroups() {
        Tutorialmod.LOGGER.info("Registering Mod Item Groups for " + Tutorialmod.MOD_ID);
    }

}
