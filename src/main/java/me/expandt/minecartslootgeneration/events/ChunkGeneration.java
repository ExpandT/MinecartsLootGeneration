package me.expandt.minecartslootgeneration.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public class ChunkGeneration implements Listener {

    @EventHandler
    public void chunkLoad(ChunkLoadEvent e) {

        if(e.isNewChunk()) {
            Entity[] entities = e.getChunk().getEntities();

            for ( int i = 0; i <= entities.length - 1; i++) {
                Entity entity = entities[i];

                if(entity instanceof StorageMinecart){
                   Inventory inventory = ((StorageMinecart) entity).getInventory();

                   inventory.forEach( item -> {
                       if(item != null && item.getType() == Material.ENCHANTED_BOOK) {

                           EnchantmentStorageMeta book = (EnchantmentStorageMeta)item.getItemMeta();

                           book.getStoredEnchants().forEach((enchantment, level) -> Bukkit.broadcastMessage("Enchant: " + ChatColor.GOLD +  enchantment.getKey()  + ChatColor.WHITE + " Level: " + ChatColor.GOLD + level));
                       } else {
                           inventory.remove(item);
                       }
                   });
                }
            }

        }
    }
}
