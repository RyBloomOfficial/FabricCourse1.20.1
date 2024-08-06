package net.rybloom.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rybloom.mccourse.MCCourseMod;
import net.rybloom.mccourse.item.custom.*;

import java.util.List;

public class ModItems {
    public static final Item FLUORITE = registerItem("fluorite", new Item(new Item.Settings()));
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite", new Item(new Item.Settings()));

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.mccourse.starlight_ashes.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item CHAINSAW = registerItem("chainsaw", new ChainsawItem(new Item.Settings().maxDamage(32)));

    public static final Item FLUORITE_SWORD = registerItem("fluorite_sword", new ModEffectSwordItem(ModToolMaterials.FLUORITE,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 3, -2.4f)), StatusEffects.LEVITATION));
    public static final Item FLUORITE_PICKAXE = registerItem("fluorite_pickaxe", new PickaxeItem(ModToolMaterials.FLUORITE,
            new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 6, -3.2f))));
    public static final Item FLUORITE_AXE = registerItem("fluorite_axe", new AxeItem(ModToolMaterials.FLUORITE,
            new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 3, -2.4f))));
    public static final Item FLUORITE_SHOVEL = registerItem("fluorite_shovel", new ShovelItem(ModToolMaterials.FLUORITE,
            new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 1.5f, -3f))));
    public static final Item FLUORITE_HOE = registerItem("fluorite_hoe", new HoeItem(ModToolMaterials.FLUORITE,
            new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 0, -3f))));
    public static final Item FLUORITE_PAXEL = registerItem("fluorite_paxel", new PaxelItem(ModToolMaterials.FLUORITE,
            new Item.Settings().attributeModifiers(PaxelItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 6, -3.2f))));
    public static final Item FLUORITE_HAMMER = registerItem("fluorite_hammer", new HammerItem(ModToolMaterials.FLUORITE,
            new Item.Settings().attributeModifiers(HammerItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 8, -3.4f))));

    public static final Item FLUORITE_HELMET = registerItem("fluorite_helmet", new ModArmorItem(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item FLUORITE_CHESTPLATE = registerItem("fluorite_chestplate", new ModArmorItem(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item FLUORITE_BOOTS = registerItem("fluorite_boots", new ModArmorItem(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item FLUORITE_LEGGINGS = registerItem("fluorite_leggings", new ModArmorItem(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));


    public static final Item STRAWBERRY = registerItem("strawberry", new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRY)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.mccourse.strawberry.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MCCourseMod.MOD_ID, name), item);
    }

    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(FLUORITE);
        entries.add(RAW_FLUORITE);
    }


    public static void registerModItems() {
        MCCourseMod.LOGGER.info("Registering Mod Items for " + MCCourseMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);
    }
}
