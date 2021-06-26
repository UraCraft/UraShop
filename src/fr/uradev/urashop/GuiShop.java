package fr.uradev.urashop;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Level;

public class GuiShop implements Listener {

    private UraShop shop;

    public GuiShop(UraShop shop) {
        this.shop = shop;
    }

    @EventHandler
    public void onInventoryInteraction(InventoryClickEvent e) {

        ItemStack item_stack = e.getCurrentItem();
        Inventory inventory = e.getInventory();
        Player player;

        if (e.getWhoClicked() instanceof Player)
            player = (Player) e.getWhoClicked();

        if (shop.isUraShopInventory(inventory)) {
            if (!shop.isPannel(item_stack)) {
                if (shop.isCategory(item_stack)) {

                }
            }
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onCommandeShop(PlayerCommandPreprocessEvent e) {

        Player p = e.getPlayer();
        String msg = e.getMessage();
        String[] args = msg.split(" ");

        if (args[0].equalsIgnoreCase("/shop")) {
            p.openInventory(shop.basicInventory(6, "UraShop"));
        }
    }

}