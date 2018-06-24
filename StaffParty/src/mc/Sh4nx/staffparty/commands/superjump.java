package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class superjump implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("superjump")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {

                    p.sendMessage(ChatColor.GREEN + "Jump!");


                    Location playerLoc = p.getLocation();
                    p.getWorld().createExplosion(playerLoc, 2F);


                    double x = p.getLocation().getX();
                    double y = p.getLocation().getY();
                    double z = p.getLocation().getZ();
                    World w = p.getWorld();
                    float generalPreviousFacingDirectionOfYaw = p.getLocation().getYaw();
                    float generalPreviousFacingDirectionOfPitch = p.getLocation().getPitch();
                    Location finalTeleport = new Location(w, x, y + 20, z);
                    finalTeleport.setPitch(generalPreviousFacingDirectionOfPitch);
                    finalTeleport.setYaw(generalPreviousFacingDirectionOfYaw);
                    



                    p.teleport(finalTeleport);

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
