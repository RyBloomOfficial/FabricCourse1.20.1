package net.rybloom.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.loot.FabricBlockLootTableGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.rybloom.mccourse.block.ModBlocks;
import net.rybloom.mccourse.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {

    public ModLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.FLUORITE_BLOCK);
        addDrop(ModBlocks.FLUORITE_STAIRS);
        addDrop(ModBlocks.FLUORITE_SLAB, slabDrops(ModBlocks.FLUORITE_SLAB));
        addDrop(ModBlocks.FLUORITE_BUTTON);
        addDrop(ModBlocks.FLUORITE_PRESSURE_PLATE);
        addDrop(ModBlocks.MAGIC_BLOCK);




        addDrop(ModBlocks.FLUORITE_ORE, multiOreDrops(ModBlocks.FLUORITE_ORE, ModItems.RAW_FLUORITE, 1, 2));
        addDrop(ModBlocks.FLUORITE_END_ORE, multiOreDrops(ModBlocks.FLUORITE_END_ORE, ModItems.RAW_FLUORITE, 3, 8));
        addDrop(ModBlocks.FLUORITE_NETHER_ORE, multiOreDrops(ModBlocks.FLUORITE_NETHER_ORE, ModItems.RAW_FLUORITE, 2, 6));
        addDrop(ModBlocks.FLUORITE_DEEPSLATE_ORE, multiOreDrops(ModBlocks.FLUORITE_DEEPSLATE_ORE, ModItems.RAW_FLUORITE, 2, 5));
    }

    public LootTable.Builder multiOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
