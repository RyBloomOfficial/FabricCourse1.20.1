package net.rybloom.mccourse.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.rybloom.mccourse.item.ModItems;
import net.rybloom.mccourse.util.ModTags;
import org.joml.Vector3f;

import java.util.List;

public class MagicBlock extends Block {
    private static final String PROCESSED_KEY = "ProcessedByMagicBlock";

    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 5f, 1f);
        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            ItemStack stack = itemEntity.getStack();
                if (isValidItem(stack)) {
                    spawnParticles(world, pos, itemEntity);
                    itemEntity.setStack(new ItemStack(Items.DIAMOND, stack.getCount()));
                    world.playSound(null, pos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1f, 1f);
                }
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    private void spawnParticles(World world, BlockPos pos, ItemEntity itemEntity) {
        Vec3d itemPos = itemEntity.getPos();
        float red = 1.0f;
        float green = 0.0f;
        float blue = 1.0f;
        for (int i = 0; i < 100; i++) { // Adjust the number of particles as needed
            double offsetX = world.random.nextGaussian() * 0.2;
            double offsetY = world.random.nextGaussian() * 0.2;
            double offsetZ = world.random.nextGaussian() * 0.2;
            world.addParticle(new DustParticleEffect(new Vector3f(red, green, blue), 1.0f),
                    itemPos.x + offsetX, itemPos.y + offsetY, itemPos.z + offsetZ, 0, 0, 0);
        }
    }

    private void spawnParticles2(World world, BlockPos pos, ItemEntity itemEntity) {
        Vec3d itemPos = itemEntity.getPos();
        float red = 0.0f;
        float green = 0.0f;
        float blue = 0.0f;
        for (int i = 0; i < 100; i++) { // Adjust the number of particles as needed
            double offsetX = world.random.nextGaussian() * 0.2;
            double offsetY = world.random.nextGaussian() * 0.2;
            double offsetZ = world.random.nextGaussian() * 0.2;
            world.addParticle(new DustParticleEffect(new Vector3f(red, green, blue), 1.0f),
                    itemPos.x + offsetX, itemPos.y + offsetY, itemPos.z + offsetZ, 0, 0, 0);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.mccourse.magic_block.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("tooltip.mccourse.magic_block.tooltip.1"));
            tooltip.add(Text.translatable("tooltip.mccourse.magic_block.tooltip.2"));
        }
        super.appendTooltip(stack, context, tooltip, options);
    }
}
