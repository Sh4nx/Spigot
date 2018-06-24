package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class eggtroll implements CommandExecutor {
	
	public static boolean eggTroll = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("eggtroll")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {
                	
                	if(eggTroll == false) {
                    p.sendMessage(ChatColor.YELLOW + "All eggs are now explosive on throw. Do /eggtroll again to disable.");
                    eggTroll = true;
                	}else {
                		p.sendMessage(ChatColor.YELLOW + "All eggs are no longer explosive. Do /eggtroll again to enable.");
                		eggTroll = false;
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
