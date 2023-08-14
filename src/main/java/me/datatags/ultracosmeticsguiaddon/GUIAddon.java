package me.datatags.ultracosmeticsguiaddon;

import be.isach.ultracosmetics.UCAddon;
import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.menu.Menus;
import me.datatags.ultracosmeticsguiaddon.menus.TexturedMainMenu;
import me.datatags.ultracosmeticsguiaddon.menus.TexturedMenuPurchase;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;

public class GUIAddon implements UCAddon {
    private final UltraCosmeticsGUIAddon plugin;
    public GUIAddon(UltraCosmetics ultraCosmetics, UltraCosmeticsGUIAddon plugin) {
        this.plugin = plugin;
        ultraCosmetics.registerAddon(this);
        reload(ultraCosmetics);
    }
    @Override
    public void reload(UltraCosmetics ultraCosmetics) {
        HandlerList.unregisterAll(plugin);
        plugin.saveDefaultConfig();
        if (plugin.getConfig().getBoolean("Send pack to players", true)) {
            Bukkit.getPluginManager().registerEvents(new ResourcePackListener(plugin), plugin);
        }
        plugin.getLogger().info("Loading menus");
        Menus menus = ultraCosmetics.getMenus();
        menus.setMainMenu(new TexturedMainMenu(ultraCosmetics));
        menus.setMenuPurchaseFactory(TexturedMenuPurchase::new);
    }
}
