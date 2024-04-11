package net.swofty.types.generic.event.actions.player;

import net.minestom.server.coordinate.Point;
import net.minestom.server.event.Event;
import net.minestom.server.event.player.PlayerBlockBreakEvent;
import net.minestom.server.instance.Instance;
import net.swofty.types.generic.event.EventNodes;
import net.swofty.types.generic.event.EventParameters;
import net.swofty.types.generic.event.SkyBlockEvent;
import net.swofty.types.generic.item.ChestImpl;
import net.swofty.types.generic.user.SkyBlockPlayer;

@EventParameters(description = "Handles destroying Chest",
        node = EventNodes.PLAYER,
        requireDataLoaded = true)
public class ActionChestDestroy extends SkyBlockEvent {
    @Override
    public Class<? extends Event> getEvent() {
        return PlayerBlockBreakEvent.class;
    }

    @Override
    public void run(Event tempEvent) {
        PlayerBlockBreakEvent event = (PlayerBlockBreakEvent) tempEvent;

        SkyBlockPlayer player = (SkyBlockPlayer) event.getPlayer();

        if (!event.getBlock().name().equals("minecraft:chest")) return;

        Instance instance = event.getInstance();
        Point position = event.getBlockPosition();

        ChestImpl chest = new ChestImpl(instance, position);

        chest.getItemsList().forEach(player::addAndUpdateItem);


    }
}
