package dev.krysztal.advagri.block.impls.crops;

import dev.krysztal.advagri.foundation.AdvAgriSolarTerm;
import dev.krysztal.advagri.foundation.block.AdvAgriCropBlock;
import dev.krysztal.advagri.item.AdvAgriItems;
import lombok.Getter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.shape.VoxelShape;

public class LettuceBlock extends AdvAgriCropBlock {

  private static final IntProperty AGE = Properties.AGE_3;

  @Getter
  private static final VoxelShape[] voxelShapes = new VoxelShape[] {
    Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), // Age 0, 播种
    Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D), // Age 1, 出苗
    Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), // Age 2, 拔高至半格，成熟
    Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D), // Age 3, 接种
  };

  @Override
  public IntProperty getAgeProperty() {
    return AGE;
  }

  @Override
  protected void appendProperties(
    StateManager.Builder<Block, BlockState> builder
  ) {
    builder.add(AGE);
  }

  @Override
  public int getMaxAge() {
    return AGE.field_37656;
  }

  @Override
  protected ItemConvertible getSeedsItem() {
    return AdvAgriItems.GARLIC;
  }

  public LettuceBlock(Settings settings) {
    super(settings, AdvAgriSolarTerm.SPRING);
  }
}
