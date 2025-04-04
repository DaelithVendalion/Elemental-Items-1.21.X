package net.daelith.eclipse.block;

import net.daelith.eclipse.Tutorialmod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block DARK_STEEL_BLOCK = registerBlock("dark_steel_block",
            new Block(AbstractBlock.Settings.create().strength(70.0f, 1800.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE)));

    public static final Block RAW_DARK_STEEL_BLOCK = registerBlock("raw_dark_steel_block",
            new Block(AbstractBlock.Settings.create().strength(50.0f, 1200.0f)
                    .requiresTool()));

    public static final Block DARK_STEEL_ORE = registerBlock("dark_steel_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 10),
                    AbstractBlock.Settings.create().strength(40.0f, 1000.0f).requiresTool()));
    public static final Block DARK_STEEL_DEEPSLATE_ORE = registerBlock("dark_steel_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 10),
                    AbstractBlock.Settings.create().strength(45.0f, 1100.0f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Tutorialmod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Tutorialmod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Tutorialmod.LOGGER.info("Registering Mod Blocks for " + Tutorialmod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.DARK_STEEL_BLOCK);
            entries.add(ModBlocks.RAW_DARK_STEEL_BLOCK);
        });
    }
}
