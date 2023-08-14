package me.datatags.ultracosmeticsguiaddon.menus;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.UltraCosmeticsData;
import be.isach.ultracosmetics.cosmetics.Category;
import be.isach.ultracosmetics.menu.Button;
import be.isach.ultracosmetics.menu.Menu;
import be.isach.ultracosmetics.menu.buttons.ClearCosmeticButton;
import be.isach.ultracosmetics.menu.buttons.KeysButton;
import be.isach.ultracosmetics.menu.buttons.OpenChestButton;
import be.isach.ultracosmetics.menu.buttons.OpenCosmeticMenuButton;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.shaded.adventure.text.Component;
import be.isach.ultracosmetics.shaded.adventure.text.format.NamedTextColor;
import me.datatags.ultracosmeticsguiaddon.buttons.InvisibleButtonWrapper;
import org.bukkit.inventory.Inventory;

/**
 * Main {@link be.isach.ultracosmetics.menu.Menu Menu}.
 *
 * @author iSach
 * @since 08-23-2016
 */
public class TexturedMainMenu extends Menu {
    private final Component title = Component.text(generateTitle(), NamedTextColor.WHITE);

    private static String generateTitle() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            // Dice emoji
            builder.append("\uD83C\uDFB2");
        }
        // House emoji
        return builder.append("\uD83C\uDFE0").toString();
    }

    public TexturedMainMenu(UltraCosmetics ultraCosmetics) {
        super("main", ultraCosmetics);
    }

    @Override
    public void open(UltraPlayer player) {
        if (!UltraCosmeticsData.get().areTreasureChestsEnabled() && Category.enabledSize() == 1) {
            getUltraCosmetics().getMenus().getCategoryMenu(Category.enabled().get(0)).open(player);
            return;
        }
        super.open(player);
    }

    @Override
    protected void putItems(Inventory inventory, UltraPlayer player) {
        putCategory(inventory, 2, Category.PETS, player);
        putCategory(inventory, 3, Category.GADGETS, player);
        putCategory(inventory, 4, Category.EFFECTS, player);
        putCategory(inventory, 5, Category.MOUNTS, player);
        putCategory(inventory, 6, Category.MORPHS, player);
        putCategory(inventory, 11, Category.HATS, player);
        putCategory(inventory, 12, Category.SUITS_HELMET, player);
        putCategory(inventory, 13, Category.EMOTES, player);
        putCategory(inventory, 14, Category.PROJECTILE_EFFECTS, player);
        putCategory(inventory, 15, Category.DEATH_EFFECTS, player);

        InvisibleButtonWrapper openChest = new InvisibleButtonWrapper(new OpenChestButton(ultraCosmetics));
        InvisibleButtonWrapper keys = new InvisibleButtonWrapper(new KeysButton(ultraCosmetics));
        for (int i = 30; i < 33; i++) {
            putItem(inventory, i, openChest, player);
            putItem(inventory, i + 9, keys, player);
        }
        putInvisibleItem(inventory, 43, new ClearCosmeticButton(), player);
    }

    protected void putCategory(Inventory inventory, int slot, Category category, UltraPlayer player) {
        putInvisibleItem(inventory, slot, new OpenCosmeticMenuButton(getUltraCosmetics(), category), player);
    }

    protected void putInvisibleItem(Inventory inventory, int slot, Button button, UltraPlayer player) {
        putItem(inventory, slot, new InvisibleButtonWrapper(button), player);
    }

    @Override
    protected Component getName() {
        return title;
    }

    @Override
    protected int getSize() {
        return 54;
    }

}
