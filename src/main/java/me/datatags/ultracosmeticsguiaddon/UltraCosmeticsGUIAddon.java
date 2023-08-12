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

public class UltraCosmeticsGUIAddon extends JavaPlugin implements UCAddon {
    @Override
    public void onEnable() {
        UltraCosmetics ultraCosmetics = UltraCosmeticsData.get().getPlugin();
        ultraCosmetics.registerAddon(this);
        reload(ultraCosmetics);
    }

    @Override
    public void reload(UltraCosmetics ultraCosmetics) {
        HandlerList.unregisterAll(this);
        saveDefaultConfig();
        if (getConfig().getBoolean("Send pack to players", true)) {
            getServer().getPluginManager().registerEvents(new ResourcePackListener(this), this);
        }
        getLogger().info("Loading menus");
        Menus menus = ultraCosmetics.getMenus();
        menus.setMainMenu(new TexturedMainMenu(ultraCosmetics));
        menus.setMenuPurchaseFactory(TexturedMenuPurchase::new);
    }
}
