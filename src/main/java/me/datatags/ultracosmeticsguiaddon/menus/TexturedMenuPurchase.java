package me.datatags.ultracosmeticsguiaddon.menus;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.menu.MenuPurchase;
import be.isach.ultracosmetics.menu.PurchaseData;
import be.isach.ultracosmetics.menu.buttons.PurchaseCancelButton;
import be.isach.ultracosmetics.menu.buttons.PurchaseConfirmButton;
import be.isach.ultracosmetics.menu.buttons.PurchaseShowcaseButton;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.shaded.kyori.adventure.text.Component;
import be.isach.ultracosmetics.shaded.kyori.adventure.text.format.NamedTextColor;
import me.datatags.ultracosmeticsguiaddon.buttons.InvisibleButtonWrapper;
import org.bukkit.inventory.Inventory;

public class TexturedMenuPurchase extends MenuPurchase {
    public TexturedMenuPurchase(UltraCosmetics ultraCosmetics, Component name, PurchaseData purchaseData) {
        super(ultraCosmetics, Component.text(generateTitle(), NamedTextColor.WHITE), purchaseData);
    }

    private static String generateTitle() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            // Dice emoji
            builder.append("\uD83C\uDFB2");
        }
        // Coin emoji
        return builder.append("\uD83E\uDE99").toString();
    }

    @Override
    protected void putItems(Inventory inventory, UltraPlayer ultraPlayer) {
        putItem(inventory, 4, new PurchaseShowcaseButton(purchaseData), ultraPlayer);
        PurchaseConfirmButton confirmButton = new PurchaseConfirmButton(purchaseData, ultraCosmetics.getEconomyHandler());
        PurchaseCancelButton cancelButton = new PurchaseCancelButton(purchaseData);
        InvisibleButtonWrapper confirmWrapped = new InvisibleButtonWrapper(confirmButton);
        InvisibleButtonWrapper cancelWrapped = new InvisibleButtonWrapper(cancelButton);
        for (int i = 21; i < 24; i++) {
            putItem(inventory, i, confirmWrapped, ultraPlayer);
            putItem(inventory, i + 18, cancelWrapped, ultraPlayer);
        }
    }
}
