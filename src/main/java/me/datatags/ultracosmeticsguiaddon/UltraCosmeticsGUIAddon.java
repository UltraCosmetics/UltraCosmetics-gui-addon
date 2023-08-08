package me.datatags.ultracosmeticsguiaddon;

import org.bukkit.plugin.java.JavaPlugin;

public class UltraCosmeticsGUIAddon extends JavaPlugin {
    public static final String PACK_URL = "https://github.com/dennishzg/uc-gui/releases/download/v1.0.0/UC-GUI-v1.0.0.zip";
    public static final byte[] PACK_HASH = hexStringToByteArray("69e2f55fed03602a0f220d8524fa00771456343b");
    @Override
    public void onEnable() {
        be.isach.ultracosmetics.UltraCosmeticsData.get();
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
