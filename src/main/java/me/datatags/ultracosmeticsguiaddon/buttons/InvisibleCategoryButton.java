package me.datatags.ultracosmeticsguiaddon.buttons;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.config.MessageManager;
import be.isach.ultracosmetics.cosmetics.Category;
import be.isach.ultracosmetics.menu.buttons.OpenCosmeticMenuButton;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.shaded.adventure.text.Component;
import be.isach.ultracosmetics.shaded.adventure.text.minimessage.tag.resolver.TagResolver;
import be.isach.ultracosmetics.util.LazyTag;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.sql.rowset.BaseRowSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvisibleCategoryButton extends OpenCosmeticMenuButton {
    private final ItemStack baseStack;
    public InvisibleCategoryButton(UltraCosmetics ultraCosmetics, Category category) {
        super(ultraCosmetics, category);
        baseStack = new ItemStack(Material.MAP);
        ItemMeta meta = baseStack.getItemMeta();
        meta.setCustomModelData(1010);
        baseStack.setItemMeta(meta);
    }

    @Override
    public ItemStack getDisplayItem(UltraPlayer ultraPlayer) {
        ItemStack stack = baseStack.clone();
        String lore = MessageManager.getLegacyMessage("Menu." + category.getConfigPath() + ".Button.Lore",
                TagResolver.resolver("unlocked", new LazyTag(() -> Component.text(calculateUnlocked(ultraPlayer.getBukkitPlayer()))))
        );
        List<String> loreList = new ArrayList<>();
        loreList.add("");
        loreList.addAll(Arrays.asList(lore.split("\n")));
        ItemMeta meta = stack.getItemMeta();
        meta.setLore(loreList);
        stack.setItemMeta(meta);
        return stack;
    }
}
