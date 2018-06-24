package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class keepmealive implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("keepmealive")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {

                    p.getActivePotionEffects().clear();
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999, 3));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 9999, 3));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 9999, 3));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 9999, 3));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 9999, 3));
                    
                    p.sendMessage(ChatColor.RED + "You have been buffed!");

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
