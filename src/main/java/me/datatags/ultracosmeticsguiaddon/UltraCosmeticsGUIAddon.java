package me.datatags.ultracosmeticsguiaddon;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.UltraCosmeticsData;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class UltraCosmeticsGUIAddon extends JavaPlugin {
    @Override
    public void onEnable() {
        UltraCosmetics ultraCosmetics = UltraCosmeticsData.get().getPlugin();
        String version = ultraCosmetics.getDescription().getVersion().split("-")[0];
        String minor = version.substring(2);
        // If there's more than two components to the version, strip it down to 2 so we can parse it as a number
        if (minor.contains(".")) {
            version = version.substring(0, 2) + minor.substring(0, minor.indexOf('.'));
        }
        if (Double.parseDouble(version) < 3.4) {
            throw new IllegalStateException("This addon requires UltraCosmetics 3.4 or higher!");
        }
        // Registers itself in order to avoid assuming the existence of UCAddon at runtime
        new GUIAddon(ultraCosmetics, this);
        new Metrics(this, 20962);
    }
}
