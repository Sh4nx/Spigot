package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class lavatroll implements CommandExecutor {
	
	public static boolean lavaTroll = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("lavatroll")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {
                	
                	if(lavaTroll == false) {
                    p.sendMessage(ChatColor.YELLOW + "All blocks when broken will now turn into lava. Do /lavatroll to disable.");
                    lavaTroll = true;
                	}else {
                		p.sendMessage(ChatColor.YELLOW + "All blocks when broken will no longer turn into lava. Do /lavatroll to enable.");
                		lavaTroll = false;
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
