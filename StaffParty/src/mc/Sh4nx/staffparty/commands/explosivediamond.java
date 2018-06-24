package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;


import org.bukkit.Bukkit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class explosivediamond implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("explosivediamond")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {

                	if(args.length == 0) {
                		
                		p.sendMessage(ChatColor.RED + "Use /explosivediamond <player>");
                		
                	}else if(args.length == 1) {
                		
                		Player target = Bukkit.getPlayerExact(args[0]);
    					
    					if(target == null) {
    						
    						p.sendMessage(ChatColor.RED + "The player " + args[0].toString() + " is not online!");
    						
    					}else {
    						//TODO: Event
    						
    						double x = target.getLocation().getX();
    	                    double y = target.getLocation().getY() - 1;
    	                    double z = target.getLocation().getZ();
    	                    World w = target.getWorld();
    	                    Location diaoreloc = new Location(w, x, y, z);
    	                    diaoreloc.getBlock().setType(Material.DIAMOND_ORE);
    	                    target.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 300, 1));
    	                    
    						
    					}
                		
                	}else {
                		p.sendMessage(ChatColor.RED + "Use /explosivediamond <player>");
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
