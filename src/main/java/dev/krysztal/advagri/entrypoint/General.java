package dev.krysztal.advagri.entrypoint;

import dev.krysztal.advagri.block.AdvAgriBlocks;
import dev.krysztal.advagri.event.AdvAgriEvents;
import dev.krysztal.advagri.foundation.AdvAgriGameRules;
import dev.krysztal.advagri.foundation.AdvAgriTags;
import dev.krysztal.advagri.item.AdvAgriItems;
import dev.krysztal.advagri.loot.AdvAgriLoot;
import net.fabricmc.api.ModInitializer;

public class General implements ModInitializer {

  @Override
  public void onInitialize() {
    AdvAgriBlocks.init();
    AdvAgriItems.init();
    AdvAgriTags.init();
    AdvAgriGameRules.init();
    AdvAgriLoot.init();
    AdvAgriEvents.init();
  }
}
