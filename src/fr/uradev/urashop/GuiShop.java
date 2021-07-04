package fr.uradev.urashop;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;


public class GuiShop implements Listener {

    private UraShop shop;

    public GuiShop(UraShop shop) {
        this.shop = shop;
    }

    @EventHandler
    public void onInventoryInteraction(InventoryClickEvent e) {

        Inventory inventory = e.getInventory();

        if (e.getSlot() > -1 && e.getWhoClicked() instanceof Player) {

            ItemStack item_stack = e.getCurrentItem();
            Player player = (Player) e.getWhoClicked();

            if (shop.isUraShopInventory(inventory)) {
                if (item_stack.equals(shop.customItemStack(Material.ARROW, ChatColor.RED + "Back"))) {
                    if (shop.isUraShopCategorys(inventory)) {
                        Inventory main = shop.fullInventory(5, "UraShop");

                        int pos[];
                        if (shop.categorys.size() % 2 == 0) {
                            pos = new int[]{21, 23, 19, 25, 20, 24};
                        } else {
                            pos = new int[]{22, 20, 24, 21, 23, 25, 19};
                        }
                        int i = 0;
                        for (ItemStack category : shop.categorys) {
                            main.setItem(pos[i], category);
                            i++;
                        }
                        player.openInventory(main);
                    }
                } else if (shop.isCategory(item_stack)) {
                    Inventory category = shop.basicInventory(5, "UraShop - " + item_stack.getItemMeta().getDisplayName());

                    FileConfiguration data = YamlConfiguration.loadConfiguration(new File(shop.getDataFolder(), "config.yml"));
                    List<String> content = data.getStringList("categorys_content." + shop.getCategory(item_stack));
                    int i = 10;
                    for (String item_raw_data : content) {
                        HashMap<String, String> item_data = shop.convertItemData(item_raw_data, 5);
                        ItemStack item = shop.customItemStack(Material.getMaterial(item_data.get("type")), ChatColor.valueOf(data.getString("categorys_parameters." + shop.getCategory(item_stack) + ".color")) + item_data.get("name"),Byte.parseByte(item_data.get("meta")), Arrays.asList(ChatColor.GRAY + "Prix d'achat à l'unité : " + item_data.get("buy_price") + "$", ChatColor.GRAY + "Prix de vente à l'unité : " + item_data.get("sell_price") + "$"));
                        if (i > 9 && i < inventory.getSize() - 9 && i % 9 != 0 && i % 9 != 8) {
                            category.setItem(i, item);
                        } else {
                            i = i + 2;
                            category.setItem(i, item);
                        }
                        i++;
                    }
                    player.openInventory(category);
                } else if (shop.getItemCategory(item_stack) != -1) {
                    Inventory item = shop.sellInventory( "UraShop - " + item_stack.getItemMeta().getDisplayName(),1);
                    ItemStack sell_item = new ItemStack(item_stack.getType());
                    ItemMeta sell_item_meta = sell_item.getItemMeta();
                    sell_item_meta.setDisplayName(item_stack.getItemMeta().getDisplayName() + " x1");
                    sell_item.setItemMeta(sell_item_meta);
                    item.setItem(22,sell_item);
                    player.openInventory(item);
                }else if(shop.getItemActionId(item_stack) != -1){
                   // Inventory item = shop.sellInventory()
                }
            }
        }

        if (shop.isUraShopInventory(inventory))
            e.setCancelled(true);
    }

    @EventHandler
    public void onCommandeShop(PlayerCommandPreprocessEvent e) {

        Player p = e.getPlayer();
        String msg = e.getMessage();
        String[] args = msg.split(" ");

        if (args[0].equalsIgnoreCase("/shop")) {
            Inventory main = shop.fullInventory(5, "UraShop"); //(int) Math.ceil(shop.categorys.size() / 7)

            int pos[];
            if (shop.categorys.size() % 2 == 0) {
                pos = new int[]{21, 23, 19, 25, 20, 24};
            } else {
                pos = new int[]{22, 20, 24, 21, 23, 25, 19};
            }
            int i = 0;
            for (ItemStack category : shop.categorys) {
                main.setItem(pos[i], category);
                i++;
            }
            p.openInventory(main);
        }
    }

}