package me.datatags.ultracosmeticsguiaddon;

import be.isach.ultracosmetics.UCAddon;
import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.UltraCosmeticsData;
import be.isach.ultracosmetics.menu.Menus;
import me.datatags.ultracosmeticsguiaddon.menus.TexturedMainMenu;
import me.datatags.ultracosmeticsguiaddon.menus.TexturedMenuPurchase;
import org.bukkit.Material;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class UltraCosmeticsGUIAddon extends JavaPlugin {
    @Override
    public void onEnable() {
        UltraCosmetics ultraCosmetics = UltraCosmeticsData.get().getPlugin();
        String version = ultraCosmetics.getDescription().getVersion().split("-")[0];
        if (Double.parseDouble(version) < 3.4) {
            throw new IllegalStateException("This addon requires UltraCosmetics 3.4 or higher!");
        }
        // Registers itself in order to avoid assuming the existence of UCAddon at runtime
        new GUIAddon(ultraCosmetics, this);
    }
}
