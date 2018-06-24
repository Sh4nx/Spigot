package mc.Sh4nx.staffparty.commands;

import net.md_5.bungee.api.ChatColor;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class randomblocks implements CommandExecutor {

    @SuppressWarnings("unused")
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("randomitem")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {

                    int max = 408;
                    int min = 1;

                    Random randomizer = new Random();
                    int randomItem = min + randomizer.nextInt(max);
                    
                    if(randomItem > 408 || randomItem < 0 || randomItem == 0) {
                    	p.sendMessage("Item value greater then 408! This is a known bug with this plugin we are sorry for the inconvience. You may /randomitem again.");
                    }else {

                    
                    Location playerLoc = p.getLocation();
                    
                    try {
                    @SuppressWarnings("deprecation")
					ItemStack randomItem1 = new ItemStack(Material.getMaterial(randomItem), 16);
                    
                    ItemStack nullException = new ItemStack(Material.STONE, 1);
                    if(randomItem1 == null) {
                    	p.sendMessage("Item value greater then 408! This is a known bug with this plugin we are sorry for the inconvience. You may /randomitem again.");
                    }else if(randomItem1 == nullException) {
                    	p.sendMessage("Item value greater then 408! This is a known bug with this plugin we are sorry for the inconvience. You may /randomitem again.");
                    }else {
                    	p.getWorld().dropItem(playerLoc, randomItem1);
                    }
                    
                    }catch(Exception e){
                    	p.sendMessage(ChatColor.RED + "Error >> No item entity found with " + randomItem);
                    	p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.ITALIC.toString() + "This is a common exception in this command. It is not an unusual bug and is being fixed soon hopefully! :) Have a nice day - Sh4nx");
                    }
                    
                    	
                    }

                } else {
                    p.sendMessage(ChatColor.RED + "You must be admin or higher!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You must be a player!");
            }
        }
        return false;
    }

}
