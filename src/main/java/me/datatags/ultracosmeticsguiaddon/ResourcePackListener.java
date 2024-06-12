package me.datatags.ultracosmeticsguiaddon;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ResourcePackListener implements Listener {
    public static final String PACK_URL = "https://github.com/dennishzg/uc-gui/releases/download/v1.1.0/UC-GUI-v1.1.0.zip";
    public static final byte[] PACK_HASH = hexStringToByteArray("20D7DAFA7152EA5B75DA3113CB23D0C6D5C7EEE0");
    private final UltraCosmeticsGUIAddon plugin;
    public ResourcePackListener(UltraCosmeticsGUIAddon plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        //Bukkit.getScheduler().runTaskLater(plugin, () -> event.getPlayer().setResourcePack(PACK_URL, PACK_HASH), 20);
        event.getPlayer().setResourcePack(PACK_URL, PACK_HASH);
    }

    // https://stackoverflow.com/a/140861
    /* s must be an even-length string. */
    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
