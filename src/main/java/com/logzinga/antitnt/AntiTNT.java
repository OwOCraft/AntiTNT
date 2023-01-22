package com.logzinga.antitnt;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.TNT;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.EventListener;

public final class AntiTNT extends JavaPlugin implements EventListener, Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("antitntabout")) {
            if(sender instanceof  Player) {
                Player p = (Player) sender;
                p.sendMessage("AntiTNT");
                p.sendMessage("Developed by OwOCraft (logzinga), for use in OwOCraft Servers.");
            }
        }
        return true;

    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
      Block block = e.getBlock();
      Material getBlockType = block.getType();

      if (getBlockType == Material.TNT) {
          Player player = e.getPlayer();
          block.setType(Material.DIRT);
          player.sendMessage("dont place tnt idiot");
      }
    }

}
