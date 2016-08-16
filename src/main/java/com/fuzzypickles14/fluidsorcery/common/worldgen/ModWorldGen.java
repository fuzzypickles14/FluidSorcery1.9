package com.fuzzypickles14.fluidsorcery.common.worldgen;

import com.fuzzypickles14.fluidsorcery.common.blocks.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by Andrew Toomey on 8/13/2016.
 */
public class ModWorldGen extends WorldGenerator {
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        WorldGenPool scorchPool = new WorldGenPool(ModBlocks.scorch);
        scorchPool.generate(worldIn, rand, position);
        return false;
    }
}
