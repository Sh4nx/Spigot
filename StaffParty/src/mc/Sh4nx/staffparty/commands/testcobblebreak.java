package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class testcobblebreak implements CommandExecutor {
	
	public static boolean blocktest = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("testblockreplace")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {
                	
                	if(blocktest == false) {
                    p.sendMessage(ChatColor.YELLOW + "Block replace testing enabled!");
                    blocktest = true;
                	}else {
                		p.sendMessage(ChatColor.YELLOW + "Block replace testing disabled!");
                		blocktest = false;
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
