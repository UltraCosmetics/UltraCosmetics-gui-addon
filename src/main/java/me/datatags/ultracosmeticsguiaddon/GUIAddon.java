package me.datatags.ultracosmeticsguiaddon;

import be.isach.ultracosmetics.UCAddon;
import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.menu.Menus;
import me.datatags.ultracosmeticsguiaddon.menus.TexturedMainMenu;
import me.datatags.ultracosmeticsguiaddon.menus.TexturedMenuPurchase;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        ItemStack treasureKeyBaseItem = new ItemStack(Material.BRICK);
        ItemMeta meta = treasureKeyBaseItem.getItemMeta();
        meta.setItemModel(NamespacedKey.fromString("ucgui:uc_items/key"));
        treasureKeyBaseItem.setItemMeta(meta);
        menus.setTreasureKeyBaseItem(treasureKeyBaseItem);
    }
}
