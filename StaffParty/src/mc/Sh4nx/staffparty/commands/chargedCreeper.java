package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;

public class chargedCreeper implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("chargedcreeper")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {

                    p.getWorld().spawn(p.getLocation(), Creeper.class);
                    p.getWorld().spawn(p.getLocation(), Creeper.class);
                    p.getWorld().spawn(p.getLocation(), Creeper.class);
                    p.getWorld().spawn(p.getLocation(), Creeper.class);
                    p.getWorld().spawn(p.getLocation(), Creeper.class);
                    p.getWorld().spawn(p.getLocation(), Creeper.class);
                    p.getWorld().spawn(p.getLocation(), Creeper.class);
                    p.getWorld().spawn(p.getLocation(), Creeper.class);
                    p.getWorld().spawn(p.getLocation(), Creeper.class);
                    p.getWorld().spawn(p.getLocation(), LightningStrike.class);


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
