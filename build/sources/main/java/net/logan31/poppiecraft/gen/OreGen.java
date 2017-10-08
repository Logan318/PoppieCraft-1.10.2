package net.logan31.poppiecraft.gen;

import net.logan31.poppiecraft.init.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

/**
 * Created by johanjulien on 21/07/2017.
 */
public class OreGen implements IWorldGenerator {

    private WorldGenerator Carbon_ore;
    private WorldGenerator Pironnite_ore_overworld;
    private WorldGenerator Pironnite_ore_nether;
    private WorldGenerator Mefferite_ore;
    private WorldGenerator Alzanite_ore;
    private WorldGenerator Ragmarite_ore;

    public OreGen() {
        Carbon_ore = new WorldGenMinable(ModBlocks.Carbon_ore.getDefaultState(), 8);
        Pironnite_ore_overworld = new WorldGenMinable(ModBlocks.Pironnite_ore_OW.getDefaultState(), 8);
        Pironnite_ore_nether = new WorldGenMinable(ModBlocks.Pironnite_ore_N.getDefaultState(), 8, new NetherGenPredicate());
        Mefferite_ore = new WorldGenMinable(ModBlocks.Mefferite_ore.getDefaultState(), 8);
        Alzanite_ore = new WorldGenMinable(ModBlocks.Alzanite_ore.getDefaultState(), 8, new EndGenPredicate());
        Ragmarite_ore = new WorldGenMinable(ModBlocks.Ragmarite_ore.getDefaultState(), 8, new NetherGenPredicate());

    }

    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i ++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 0: //OverWorld
                this.runGenerator(Carbon_ore, world, random, chunkX, chunkZ, 18, 5, 40);
                this.runGenerator(Pironnite_ore_overworld, world, random, chunkX, chunkZ, 1, 9, 13);
                this.runGenerator(Mefferite_ore, world, random, chunkX, chunkZ, 1, 8, 15);
            case 1: //End
                this.runGenerator(Alzanite_ore, world, random, chunkX, chunkZ, 1, 5, 250);
            case -1: //Nether
                this.runGenerator(Pironnite_ore_nether, world, random, chunkX, chunkZ, 50, 10, 250);
                this.runGenerator(Ragmarite_ore, world, random, chunkX, chunkZ, 1, 50, 150);
        }
    }
}
