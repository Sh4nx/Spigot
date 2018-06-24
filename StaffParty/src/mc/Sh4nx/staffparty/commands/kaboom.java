package mc.Sh4nx.staffparty.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class kaboom implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("kaboom")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {

                    Bukkit.getServer().broadcastMessage(ChatColor.GOLD.toString() + ChatColor.BOLD.toString() + ChatColor.ITALIC.toString() + "KABOOM!");


                    int max = 8;
                    int min = 1;

                    Random randomizer = new Random();
                    int explosionRadius = min + randomizer.nextInt(max);

                    Location playerLoc = p.getLocation();
                    p.getWorld().createExplosion(playerLoc, explosionRadius);

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
