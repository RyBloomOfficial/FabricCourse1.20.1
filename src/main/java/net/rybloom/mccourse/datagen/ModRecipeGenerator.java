package net.rybloom.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.rybloom.mccourse.MCCourseMod;
import net.rybloom.mccourse.block.ModBlocks;
import net.rybloom.mccourse.block.custom.MagicBlock;
import net.rybloom.mccourse.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> FLUORITE_SMELTABLES = List.of(ModItems.RAW_FLUORITE, ModBlocks.FLUORITE_ORE,
                ModBlocks.FLUORITE_DEEPSLATE_ORE, ModBlocks.FLUORITE_END_ORE, ModBlocks.FLUORITE_NETHER_ORE);
        List<ItemConvertible> STARLIGHT_ASH_SMELTABLES = List.of(ModItems.FLUORITE);

        offerSmelting(exporter, FLUORITE_SMELTABLES, RecipeCategory.MISC, ModItems.FLUORITE, 0.2f, 200, "fluorite" );
        offerBlasting(exporter, FLUORITE_SMELTABLES, RecipeCategory.MISC, ModItems.FLUORITE, 0.2f, 100, "fluorite" );
        offerSmelting(exporter, STARLIGHT_ASH_SMELTABLES, RecipeCategory.MISC, ModItems.STARLIGHT_ASHES, 0.2f, 200, "fluorite" );
        offerBlasting(exporter, STARLIGHT_ASH_SMELTABLES, RecipeCategory.MISC, ModItems.STARLIGHT_ASHES, 0.2f, 100, "fluorite" );

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.FLUORITE, RecipeCategory.DECORATIONS, ModBlocks.FLUORITE_BLOCK);

        // MISC Recipes
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_FLUORITE)
                .pattern("SSS")
                .pattern("SFS")
                .pattern("SSS")
                .input('S', Blocks.STONE)
                .input('F', ModItems.FLUORITE)
                .criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE))
                .criterion(hasItem(ModItems.FLUORITE), conditionsFromItem(ModItems.FLUORITE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_FLUORITE)
                .pattern("AAA")
                .pattern("AFA")
                .pattern("AAA")
                .input('A', Blocks.ANDESITE)
                .input('F', ModItems.FLUORITE)
                .criterion(hasItem(Blocks.ANDESITE), conditionsFromItem(Blocks.ANDESITE))
                .criterion(hasItem(ModItems.FLUORITE), conditionsFromItem(ModItems.FLUORITE))
                .offerTo(exporter, Identifier.of(MCCourseMod.MOD_ID, "raw_fluorite_2"));

        // Blocks/Doors/Buttons/Etc... Recipes
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK)
                .pattern("DFD")
                .pattern("FEF")
                .pattern("DFD")
                .input('E', Items.ENDER_EYE)
                .input('D', Items.DIAMOND)
                .input('F', ModItems.FLUORITE)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
                .criterion(hasItem(ModItems.FLUORITE), conditionsFromItem(ModItems.FLUORITE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_SLAB)
                .pattern("   ")
                .pattern("   ")
                .pattern("FFF")
                .input('F', ModBlocks.FLUORITE_BLOCK)
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK), conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_STAIRS)
                .pattern("F  ")
                .pattern("FF ")
                .pattern("FFF")
                .input('F', ModBlocks.FLUORITE_BLOCK)
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK), conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_PRESSURE_PLATE)
                .pattern("   ")
                .pattern("   ")
                .pattern(" FF")
                .input('F', ModBlocks.FLUORITE_BLOCK)
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK), conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_BUTTON)
                .pattern("   ")
                .pattern(" F ")
                .pattern("   ")
                .input('F', ModItems.FLUORITE)
                .criterion(hasItem(ModItems.FLUORITE), conditionsFromItem(ModItems.FLUORITE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_WALL)
                .pattern("   ")
                .pattern("FDF")
                .pattern("FDF")
                .input('F', ModBlocks.FLUORITE_BLOCK)
                .input('D', ModItems.FLUORITE)
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK), conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .criterion(hasItem(ModItems.FLUORITE), conditionsFromItem(ModItems.FLUORITE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_DOOR)
                .pattern(" FF")
                .pattern(" FF")
                .pattern(" FF")
                .input('F', ModBlocks.FLUORITE_BLOCK)
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK), conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_TRAPDOOR)
                .pattern("   ")
                .pattern("FFF")
                .pattern("FFF")
                .input('F', ModBlocks.FLUORITE_BLOCK)
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK), conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .offerTo(exporter);

        // TOOL RECIPES
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLUORITE_PICKAXE)
                .pattern("FFF")
                .pattern(" S ")
                .pattern(" S ")
                .input('F', ModItems.FLUORITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.FLUORITE), conditionsFromItem(ModItems.FLUORITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLUORITE_AXE)
                .pattern(" FF")
                .pattern(" SF")
                .pattern(" S ")
                .input('F', ModItems.FLUORITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.FLUORITE), conditionsFromItem(ModItems.FLUORITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLUORITE_HOE)
                .pattern(" FF")
                .pattern(" S ")
                .pattern(" S ")
                .input('F', ModItems.FLUORITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.FLUORITE), conditionsFromItem(ModItems.FLUORITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLUORITE_SWORD)
                .pattern(" F ")
                .pattern(" F ")
                .pattern(" S ")
                .input('F', ModItems.FLUORITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.FLUORITE), conditionsFromItem(ModItems.FLUORITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLUORITE_SHOVEL)
                .pattern(" F ")
                .pattern(" S ")
                .pattern(" S ")
                .input('F', ModItems.FLUORITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.FLUORITE), conditionsFromItem(ModItems.FLUORITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CHAINSAW)
                .pattern("  I")
                .pattern("FF ")
                .pattern("II ")
                .input('I', Items.IRON_INGOT)
                .input('F', ModItems.FLUORITE)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.FLUORITE), conditionsFromItem(ModItems.FLUORITE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLUORITE_PAXEL)
                .pattern("SAP")
                .pattern(" # ")
                .pattern(" # ")
                .input('P', ModItems.FLUORITE_PICKAXE)
                .input('A', ModItems.FLUORITE_AXE)
                .input('S', ModItems.FLUORITE_SHOVEL)
                .input('#', Items.STICK)
                .criterion(hasItem(ModItems.FLUORITE_PICKAXE), conditionsFromItem(ModItems.FLUORITE_PICKAXE))
                .criterion(hasItem(ModItems.FLUORITE_AXE), conditionsFromItem(ModItems.FLUORITE_AXE))
                .criterion(hasItem(ModItems.FLUORITE_SHOVEL), conditionsFromItem(ModItems.FLUORITE_SHOVEL))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLUORITE_HAMMER)
                .pattern(" F ")
                .pattern(" SF")
                .pattern("S  ")
                .input('F', ModItems.FLUORITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.FLUORITE), conditionsFromItem(ModItems.FLUORITE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        // Armour Recipes
    }
}
