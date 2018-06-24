package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;

public class chickenPlz implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("chickenplz")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {


                    for (Player all : p.getWorld().getPlayers()) {
                        all.getWorld().spawn(all.getLocation(), Chicken.class);
                        all.getWorld().spawn(all.getLocation(), Chicken.class);
                        all.getWorld().spawn(all.getLocation(), Chicken.class);
                        all.getWorld().spawn(all.getLocation(), Chicken.class);
                        all.getWorld().spawn(all.getLocation(), Chicken.class);
                        all.getWorld().spawn(all.getLocation(), Chicken.class);
                        all.getWorld().spawn(all.getLocation(), Chicken.class);
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
