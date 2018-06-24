package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class birthday implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("birthday")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {

                    double x = p.getLocation().getX() + 3;
                    double y = p.getLocation().getY();
                    double z = p.getLocation().getZ();
                    World w = p.getWorld();
                    Location cakeLoc = new Location(w, x, y, z);
                    cakeLoc.getBlock().setType(Material.CAKE_BLOCK);

                    Location torch1 = new Location(w, x + 1, y, z);
                    torch1.getBlock().setType(Material.TORCH);

                    Location torch2 = new Location(w, x, y, z - 1);
                    torch2.getBlock().setType(Material.TORCH);

                    Location torch3 = new Location(w, x, y, z + 1);
                    torch3.getBlock().setType(Material.TORCH);

                    Location torch4 = new Location(w, x - 1, y, z);
                    torch4.getBlock().setType(Material.TORCH);

                    ItemStack gimmeDias = new ItemStack(Material.DIAMOND, 16);
                    ItemMeta meta = gimmeDias.getItemMeta();
                    meta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD.toString() + "DIAMONDSSSS");
                    gimmeDias.setItemMeta(meta);

                    Location diamonds = new Location(w, x, y, z);
                    p.getWorld().dropItem(diamonds, gimmeDias);


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
