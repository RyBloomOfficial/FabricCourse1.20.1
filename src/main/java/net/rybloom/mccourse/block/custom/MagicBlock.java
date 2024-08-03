package net.rybloom.mccourse.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.rybloom.mccourse.item.ModItems;
import org.joml.Vector3f;

public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 5f, 1f);
        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity item) {
            if(isValidItem(item.getStack())) {
                spawnParticles(world, pos, item);
                item.setStack(new ItemStack(Items.DIAMOND, item.getStack().getCount()));
                world.playSound(null, pos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1f, 5f);
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.getItem() == ModItems.FLUORITE ||
                stack.getItem() == ModItems.RAW_FLUORITE ||
                stack.getItem() == Items.COAL;
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
}
