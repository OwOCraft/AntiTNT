package com.logzinga.antitnt;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.EventListener;

public final class AntiTNT extends JavaPlugin implements EventListener {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
      Block block = e.getBlock();
      Player player = e.getPlayer();
      Material getBlockType = block.getType();
      if (getBlockType == Material.TNT) {
          e.setCancelled(true);
          player.kickPlayer("TNT Placed");
      }
    }

}
