package dev.krysztal.advagri.foundation.block;

import dev.krysztal.advagri.foundation.AdvAgriGameRules;
import dev.krysztal.advagri.foundation.AdvAgriSolarTerm;
import dev.krysztal.advagri.foundation.persistents.SolarTermPersistentState;
import lombok.Getter;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public abstract class AdvAgriCropBlock extends CropBlock {

  @Getter
  private AdvAgriSolarTerm rightSolarterm = AdvAgriSolarTerm.SPRING;

  public AdvAgriCropBlock(Settings settings) {
    super(settings);
  }

  public AdvAgriCropBlock(Settings settings, AdvAgriSolarTerm rightSolarTerm) {
    super(settings);
    this.rightSolarterm = rightSolarTerm;
  }

  public static VoxelShape getShapeOfAge(
    BlockState state,
    IntProperty age,
    VoxelShape[] voxelShapes
  ) {
    return voxelShapes[state.get(age)];
  }

  @Override
  public boolean canGrow(
    World world,
    Random random,
    BlockPos pos,
    BlockState state
  ) {
    // Check it allow season change.
    // If not, the crops will grow normally.
    if (
      !world.getGameRules().get(AdvAgriGameRules.ALLOW_SEASONS_CHANGE).get()
    ) return true;

    // The lenght between right term and current term.
    var stepLength = Math.abs(
      this.rightSolarterm.ordinal() -
      SolarTermPersistentState.get(world).getSeason()
    );

    // Cacl the grow chance.
    var growChance = (int) (
      ((double) stepLength / (double) AdvAgriSolarTerm.values().length) * 100
    );

    return random.nextBetweenExclusive(0, 100) <= growChance;
  }
}
