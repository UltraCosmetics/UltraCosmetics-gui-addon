package me.datatags.ultracosmeticsguiaddon.buttons;

import be.isach.ultracosmetics.menu.Button;
import be.isach.ultracosmetics.menu.ClickData;
import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InvisibleButtonWrapper implements Button {
    protected final Button wrapped;
    public InvisibleButtonWrapper(Button wrapped) {
        this.wrapped = wrapped;
    }
    @Override
    public ItemStack getDisplayItem(UltraPlayer ultraPlayer) {
        ItemStack stack = wrapped.getDisplayItem(ultraPlayer).clone();
        stack.setType(Material.BRICK);
        ItemMeta meta = stack.getItemMeta();
        meta.setItemModel(NamespacedKey.fromString("ucgui:guis/invisibleitem"));
        stack.setItemMeta(meta);
        return stack;
    }

    @Override
    public void onClick(ClickData clickData) {
        wrapped.onClick(clickData);
    }
}
