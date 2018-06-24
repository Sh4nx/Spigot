package mc.Sh4nx.staffparty.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class Nuke implements CommandExecutor {
	
	

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (command.getName().equalsIgnoreCase("nuke")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {

                    Bukkit.getServer().broadcastMessage(ChatColor.RED + "Nuke detonated.");

                    		Location playerLoc = p.getLocation();
                    		
                            p.getWorld().createExplosion(playerLoc, 12F);
                            p.getWorld().createExplosion(playerLoc, 14F);
                            p.getWorld().createExplosion(playerLoc, 16F);
                            p.getWorld().createExplosion(playerLoc, 18F);
                            p.getWorld().createExplosion(playerLoc, 20F);
                            p.getWorld().createExplosion(playerLoc, 22F);


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
