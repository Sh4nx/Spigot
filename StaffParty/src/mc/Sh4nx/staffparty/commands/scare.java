package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;


import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;



public class scare implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("scare")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {

                	if(args.length == 0) {
                		
                		p.sendMessage(ChatColor.RED + "Use /scare <player>");
                		
                	}else if(args.length == 1) {
                		
                		Player target = Bukkit.getPlayerExact(args[0]);
    					
    					if(target == null) {
    						
    						p.sendMessage(ChatColor.RED + "The player " + args[0].toString() + " is not online!");
    						
    					}else {
    						//TODO: Event
    						
    						p.sendMessage(ChatColor.GREEN + "Scaring " + target.getName());
    						target.playSound(target.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 1);
    						
    	                    
    						
    					}
                		
                	}else {
                		p.sendMessage(ChatColor.RED + "Use /scare <player>");
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
