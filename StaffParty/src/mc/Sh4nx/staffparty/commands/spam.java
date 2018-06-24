package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spam implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("spam")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {

                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "viperboy10 joined the game.");
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Bikuta_Kun joined the game.");
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "_OutdatedPixel joined the game.");
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "DieCuzImFly joined the game.");
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "mi5tic joined the game.");
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Crqfting joined the game.");
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "GRAMCR4CKER joined the game.");
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Mantis joined the game.");
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "SSundee joined the game.");
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Gapl3 joined the game.");
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Sh4nx joined the game.");
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Sped joined the game.");
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "KrizzDawg joined the game.");
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "CaprisunProphet joined the game.");
                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "bestinworld910 joined the game.");

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
