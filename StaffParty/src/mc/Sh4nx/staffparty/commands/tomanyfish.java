package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class tomanyfish implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("tomanyfish")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {

                    ItemStack gimmeDias = new ItemStack(Material.RAW_FISH, 4600);
                    ItemMeta meta = gimmeDias.getItemMeta();
                    meta.setDisplayName(ChatColor.GRAY.toString() + ChatColor.BOLD.toString() + "WHY DID U DO THIS!");
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
