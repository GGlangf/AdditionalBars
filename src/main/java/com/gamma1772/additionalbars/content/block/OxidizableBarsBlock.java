package com.gamma1772.additionalbars.content.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

public class OxidizableBarsBlock extends BasicBarsBlock implements WeatheringCopper {
    private WeatherState state;

    public OxidizableBarsBlock(WeatherState state, Properties properties) {
        super(properties);
        this.state = state;
    }

    public OxidizableBarsBlock(WeatherState state, Properties properties, BlockType... types) {
        super(properties, types);
        this.state = state;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        this.onRandomTick(state, world, pos, random);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return WeatheringCopper.getNext(state.getBlock()).isPresent();
    }

    @Override
    public WeatherState getAge() {
        return this.state;
    }
}
