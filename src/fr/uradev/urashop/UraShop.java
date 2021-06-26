package fr.uradev.urashop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UraShop extends JavaPlugin {

    public List<ItemStack> categorys = new ArrayList<>();


    @Override
    public void onEnable() {
        getLogger().log(Level.INFO, "UraStonks !");
        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.registerEvents(new GuiShop(this), this);

        try {
            this.loadConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "UraAntiStonks !");
    }

    private void loadConfig() throws IOException {
        File config = new File(getDataFolder(), "config.yml");

        if (!config.exists()) {
            getDataFolder().mkdirs();
            if (!config.createNewFile())
                getLogger().log(Level.SEVERE, "Unable to create config.yml");
        }

        if (config.exists()) {
            FileReader config_reader = new FileReader(config.getPath());

            if (config_reader.read() == -1) {
                Bukkit.getConsoleSender().sendMessage("[UraShop]" + ChatColor.RED + "Configuration config.yml is empty");

                Bukkit.getServer().shutdown();
            }

            FileConfiguration data = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "config.yml"));


            for (String category : data.getStringList("categorys")) {
                String path = "categorys_parameters." + category;
                HashMap<String, String> item_data = covertItemData(data.getString(path + ".item"));
                ItemStack stack = new ItemStack(Material.getMaterial(item_data.get("type")));
                ItemMeta meta = stack.getItemMeta();
                meta.setDisplayName(ChatColor.valueOf(item_data.get("color")) + item_data.get("name"));
                stack.setItemMeta(meta);
                this.categorys.add(stack);

            }


        } else {
            getLogger().log(Level.SEVERE, "Unable to load config.yml");
        }

    }

    public HashMap<String, String> covertItemData(String data) {
        HashMap<String, String> hash = new HashMap<>();
        int pointers[] = new int[4];

        for (int i = 0; i <= 2; i++) {
            int next_index = i == 0 ? 0 : pointers[i - 1] + 1;
            int index_end = data.indexOf("=", next_index);
            pointers[i] = data.indexOf(",", next_index);
            hash.put(data.substring(next_index, index_end), data.substring(index_end + 1, i == 2 ? data.length() : pointers[i]));
        }

        return hash;
    }

    public boolean isCategory(ItemStack item) {
        Material item_material = item.getType();
        return categorys.contains(item);
    }

    public boolean isPannel(ItemStack item) {
        Material item_material = item.getType();
        return item_material == Material.STAINED_GLASS_PANE && item.getDurability() == 7;
    }

    public boolean isUraShopInventory(Inventory inventory) {
        return inventory.getName().contains("UraShop");
    }

    public Inventory basicInventory(int rows, String title) {
        Inventory inventory = Bukkit.createInventory(null, rows * 9, title);
        ItemStack pannel = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 7);
        ItemMeta meta = pannel.getItemMeta();

        meta.setDisplayName(" ");
        pannel.setItemMeta(meta);

        for (int i = 0; i < inventory.getSize(); i++) {
            if (i < 9 || i > inventory.getSize() - 9 || i % 9 == 0 || i % 9 == 8) {
                inventory.setItem(i, pannel);
            }
        }
        return inventory;
    }
}

/*
012345678
9       17

 */
