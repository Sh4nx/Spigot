package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class grief implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("grief")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {

                    Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "xTurtle joined the game.");

                    p.getInventory().clear();

                    ItemStack lavaBucket = new ItemStack(Material.LAVA_BUCKET, 16);
                    ItemStack flintandsteel = new ItemStack(Material.FLINT_AND_STEEL, 1);
                    ItemStack bedrock = new ItemStack(Material.BEDROCK, 128);
                    ItemStack woodenaxe = new ItemStack(Material.WOOD_AXE, 1);
                    ItemStack tnt = new ItemStack(Material.TNT, 64);
                    p.getInventory().addItem(lavaBucket);
                    p.getInventory().addItem(flintandsteel);
                    p.getInventory().addItem(bedrock);
                    p.getInventory().addItem(woodenaxe);
                    p.getInventory().addItem(tnt);

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
