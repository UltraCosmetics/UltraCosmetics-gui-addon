package me.datatags.ultracosmeticsguiaddon;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.UltraCosmeticsData;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class UltraCosmeticsGUIAddon extends JavaPlugin {
    public static final int MIN_MAJOR_VERSION = 3;
    public static final int MIN_MINOR_VERSION = 6;
    @Override
    public void onEnable() {
        UltraCosmetics ultraCosmetics = UltraCosmeticsData.get().getPlugin();
        String[] parts = ultraCosmetics.getDescription().getVersion().split("-")[0].split("\\.");
        int major = Integer.parseInt(parts[0]);
        int minor = Integer.parseInt(parts[1]);
        if (major < MIN_MAJOR_VERSION || (major == MIN_MAJOR_VERSION && minor < MIN_MINOR_VERSION)) {
            String minVersion = MIN_MAJOR_VERSION + "." + MIN_MINOR_VERSION;
            throw new IllegalStateException("This addon requires UltraCosmetics " + minVersion + " or higher!");
        }
        // Registers itself in order to avoid assuming the existence of UCAddon at runtime
        new GUIAddon(ultraCosmetics, this);
        new Metrics(this, 20962);
    }
}
