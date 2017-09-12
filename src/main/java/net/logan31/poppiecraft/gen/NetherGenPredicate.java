package net.logan31.poppiecraft.gen;

import com.google.common.base.Predicate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import javax.annotation.Nullable;

/**
 * Created by johanjulien on 21/07/2017.
 */
public class NetherGenPredicate implements Predicate<IBlockState> {
    @Override
    public boolean apply(@Nullable IBlockState input) {
        return input != null && input.getBlock() == Blocks.NETHERRACK;
    }
}
