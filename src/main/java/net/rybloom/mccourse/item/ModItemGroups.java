package net.rybloom.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rybloom.mccourse.MCCourseMod;
import net.rybloom.mccourse.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup FLUORITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MCCourseMod.MOD_ID, "fluorite"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fluorite"))
                    .icon(() -> new ItemStack(ModItems.FLUORITE)).entries((displayContext, entries) -> {
                        entries.add(new ItemStack(ModItems.FLUORITE));
                        entries.add(new ItemStack(ModItems.RAW_FLUORITE));

                        entries.add(new ItemStack(ModItems.STARLIGHT_ASHES));

                        entries.add(new ItemStack(ModItems.CHAINSAW));

                        entries.add(new ItemStack(ModItems.FLUORITE_SWORD));
                        entries.add(new ItemStack(ModItems.FLUORITE_AXE));
                        entries.add(new ItemStack(ModItems.FLUORITE_SHOVEL));
                        entries.add(new ItemStack(ModItems.FLUORITE_PICKAXE));
                        entries.add(new ItemStack(ModItems.FLUORITE_HOE));

                        entries.add(new ItemStack(ModItems.FLUORITE_PAXEL));
                        entries.add(new ItemStack(ModItems.FLUORITE_HAMMER));

                        entries.add(new ItemStack(ModItems.FLUORITE_HELMET));
                        entries.add(new ItemStack(ModItems.FLUORITE_CHESTPLATE));
                        entries.add(new ItemStack(ModItems.FLUORITE_BOOTS));
                        entries.add(new ItemStack(ModItems.FLUORITE_LEGGINGS));

                        entries.add(new ItemStack(ModItems.STRAWBERRY));
                    }).build());

    public static final ItemGroup FLUORITE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MCCourseMod.MOD_ID, "fluorite_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fluorite_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.FLUORITE_BLOCK)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.FLUORITE_BLOCK);
                        entries.add(ModBlocks.FLUORITE_STAIRS);
                        entries.add(ModBlocks.FLUORITE_SLAB);

                        entries.add(ModBlocks.FLUORITE_PRESSURE_PLATE);
                        entries.add(ModBlocks.FLUORITE_BUTTON);

                        entries.add(ModBlocks.FLUORITE_FENCE);
                        entries.add(ModBlocks.FLUORITE_FENCE_GATE);
                        entries.add(ModBlocks.FLUORITE_WALL);

                        entries.add(ModBlocks.FLUORITE_DOOR);
                        entries.add(ModBlocks.FLUORITE_TRAPDOOR);

                        entries.add(ModBlocks.FLUORITE_ORE);
                        entries.add(ModBlocks.FLUORITE_DEEPSLATE_ORE);
                        entries.add(ModBlocks.FLUORITE_END_ORE);
                        entries.add(ModBlocks.FLUORITE_NETHER_ORE);

                        entries.add(ModBlocks.MAGIC_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        MCCourseMod.LOGGER.info("Registering Mod Item Groups for " + MCCourseMod.MOD_ID);
    }
}
