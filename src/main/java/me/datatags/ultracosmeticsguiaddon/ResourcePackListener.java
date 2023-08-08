package me.datatags.ultracosmeticsguiaddon;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ResourcePackListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setResourcePack(UltraCosmeticsGUIAddon.PACK_URL, UltraCosmeticsGUIAddon.PACK_HASH);
    }
}
