package dev.krysztal.advagri.entrypoint.datagen;

import dev.krysztal.advagri.entrypoint.datagen.loottables.LootTablesGenerator;
import dev.krysztal.advagri.entrypoint.datagen.models.CropModelsGenerator;
import dev.krysztal.advagri.entrypoint.datagen.models.ModelsGenerator;
import dev.krysztal.advagri.entrypoint.datagen.recipes.FurnaceGenerator;
import dev.krysztal.advagri.entrypoint.datagen.tags.MineLevelGenerator;
import dev.krysztal.advagri.entrypoint.datagen.tags.MineableGenerator;
import dev.krysztal.advagri.entrypoint.datagen.tags.MiscTagGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class AdvAgriDataGen implements DataGeneratorEntrypoint {

  @Override
  public void onInitializeDataGenerator(
    FabricDataGenerator fabricDataGenerator
  ) {
    fabricDataGenerator.addProvider(ModelsGenerator::new);
    fabricDataGenerator.addProvider(CropModelsGenerator::new);

    fabricDataGenerator.addProvider(LootTablesGenerator::new);

    fabricDataGenerator.addProvider(MineLevelGenerator::new);
    fabricDataGenerator.addProvider(MineableGenerator::new);
    fabricDataGenerator.addProvider(MiscTagGenerator::new);

    fabricDataGenerator.addProvider(FurnaceGenerator::new);
  }
}
