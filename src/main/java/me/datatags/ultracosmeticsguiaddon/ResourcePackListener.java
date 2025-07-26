package me.datatags.ultracosmeticsguiaddon;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class ResourcePackListener implements Listener {
    public static final String PACK_URL = "https://github.com/UltraCosmetics/uc-gui/releases/download/v1.2.0/UC-GUI-v1.2.0.zip";
    public static final byte[] PACK_HASH = hexStringToByteArray("5D3CFAF864B993D3AB07D81B88B7CE3C84365110");
    public static final UUID PACK_UUID = UUID.nameUUIDFromBytes(PACK_URL.getBytes()); // value is arbitrary as long as it's constant

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        try {
            event.getPlayer().addResourcePack(PACK_UUID, PACK_URL, PACK_HASH, null, false);
        } catch (NoSuchMethodError err) {
            event.getPlayer().setResourcePack(PACK_URL, PACK_HASH);
        }
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
