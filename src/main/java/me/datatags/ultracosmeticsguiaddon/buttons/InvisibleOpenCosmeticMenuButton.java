package me.datatags.ultracosmeticsguiaddon.buttons;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.config.MessageManager;
import be.isach.ultracosmetics.cosmetics.Category;
import be.isach.ultracosmetics.menu.ClickData;
import be.isach.ultracosmetics.menu.buttons.OpenCosmeticMenuButton;
import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;

public class InvisibleOpenCosmeticMenuButton extends InvisibleButtonWrapper {
    private final Category category;
    private final String disabledLore = MessageManager.getLegacyMessage("Menu.Disabled-Button");
    public InvisibleOpenCosmeticMenuButton(UltraCosmetics ultraCosmetics, Category category) {
        super(new OpenCosmeticMenuButton(ultraCosmetics, category));
        this.category = category;
    }

    @Override
    public ItemStack getDisplayItem(UltraPlayer ultraPlayer) {
        ItemStack stack = super.getDisplayItem(ultraPlayer);
        if (!category.isEnabled()) {
            ItemMeta meta = stack.getItemMeta();
            meta.setLore(Arrays.asList("", disabledLore));
            stack.setItemMeta(meta);
        }
        return stack;
    }

    @Override
    public void onClick(ClickData clickData) {
        if (category.isEnabled()) {
            super.onClick(clickData);
        }
    }
}
