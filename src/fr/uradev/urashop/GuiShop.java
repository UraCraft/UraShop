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
        Inventory inventory = e.getClickedInventory();
        Player player;

        if (e.getWhoClicked() instanceof Player)
            player = (Player) e.getWhoClicked();

        if (shop.isUraShopInventory(inventory)) {
            if (!shop.isPannel(item_stack)) {
                if (shop.isCategory(item_stack)) {
                    Inventory category = shop.basicInventory(5,"UraShop - " + item_stack.getItemMeta().getDisplayName());
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
            Inventory main = shop.basicInventory(3, "UraShop"); //(int) Math.ceil(shop.categorys.size() / 7)

            int pos[];
            if(shop.categorys.size() % 2 == 0){
                pos = new int[]{12,14,10,16,11,15};
            }else{
                pos = new int[]{13,11,15,12,14,16,10};
            }
            int i = 0;
            for (ItemStack category : shop.categorys) {
                main.setItem(pos[i],category);
                i ++;
            }
            p.openInventory(main);
        }
    }

}