package dev.krysztal.advagri.api.event.server;

import java.util.Arrays;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;

public class DayChangeEvent {

  public static Event<DayChange> AFTER = EventFactory.createArrayBacked(
    DayChange.class,
    listeners ->
      (minecraftServer, serverWorld) ->
        Arrays
          .stream(listeners)
          .forEach($ -> $.interact(minecraftServer, serverWorld))
  );

  public static Event<DayChange> BEFORE = EventFactory.createArrayBacked(
    DayChange.class,
    listeners ->
      (minecraftServer, serverWorld) ->
        Arrays
          .stream(listeners)
          .forEach($ -> $.interact(minecraftServer, serverWorld))
  );

  @FunctionalInterface
  public interface DayChange {
    public void interact(
      MinecraftServer minecraftServer,
      ServerWorld serverWorld
    );
  }
}
