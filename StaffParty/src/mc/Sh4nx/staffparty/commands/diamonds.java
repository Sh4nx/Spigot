package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class diamonds implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("IWANTDIAMONDS")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {

                    ItemStack gimmeDias = new ItemStack(Material.DIAMOND, 256);
                    ItemMeta meta = gimmeDias.getItemMeta();
                    meta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD.toString() + "DIAMONDSSSS");
                    gimmeDias.setItemMeta(meta);


                    p.getWorld().dropItem(p.getLocation(), gimmeDias);


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
