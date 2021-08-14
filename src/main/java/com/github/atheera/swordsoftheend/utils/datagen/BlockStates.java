package com.github.atheera.swordsoftheend.utils.datagen;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.inits.BlockInit;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, SOTE.MOD_ID, exFileHelper);
    }

    @Override
    public void registerStatesAndModels() {
        registerInfuserBlock();
        registerEnchanterBlock();
    }

    private void registerEnchanterBlock() {
        simpleBlock(BlockInit.BLOCK_ENCHANT_INFUSER.get());
    }

    private void registerInfuserBlock() {

        ResourceLocation sides = new ResourceLocation(SOTE.MOD_ID, "blocks/block_infuser_side"); // side textures
        ResourceLocation top = new ResourceLocation(SOTE.MOD_ID, "blocks/block_infuser_top"); // top textures
        BlockModelBuilder modelInfuser = models().cube // unpowered model
                ("block_infuser", top, top, new ResourceLocation(SOTE.MOD_ID, "blocks/block_infuser_off"), sides, sides, sides);
        BlockModelBuilder modelInfuserPowered = models().cube // powered model
                ("block_infuser_on", top, top, new ResourceLocation(SOTE.MOD_ID, "blocks/block_infuser_on"), sides, sides, sides);
        orientedBlock(BlockInit.BLOCK_ENCHANT_INFUSER_GENERATOR.get(), state -> {
            if(!state.getValue(BlockStateProperties.POWERED)) {
                return modelInfuser;
            } else {
                return modelInfuserPowered;
            }
        });
    }

    private void orientedBlock(Block block, Function<BlockState, ModelFile> modelFunc) {
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(BlockStateProperties.FACING);
                return ConfiguredModel.builder()
                    .modelFile(modelFunc.apply(state))
                    .rotationX(dir.getAxis() == Direction.Axis.Y ? dir.getAxisDirection().getStep() * -90 : 0)
                    .rotationY(dir.getAxis() != Direction.Axis.Y ? ((dir.get2DDataValue() + 2) % 4) * 90 : 0)
                    .build();
            });
    }

}