package mc.Sh4nx.staffparty.commands;


import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class alltrolls implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("alltrolls")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("sp.fun")) {

                    String cp = ChatColor.GREEN + "";
                    
                    if(args.length == 0) {
                    	
                    	 p.sendMessage(ChatColor.GREEN + "GREEN " + ChatColor.GRAY + "commands mean the command is fully usable. " + ChatColor.GOLD + "GOLD " + ChatColor.GRAY + "commands are a work in progress and may or may not always work. " + ChatColor.RED + "RED " + ChatColor.GRAY + "command mean the command is a testing command for developers.");
                         p.sendMessage(cp + "/alltrolls - List all of the trolls");
                         p.sendMessage(cp + "/birthday - Spawn a cake and torches!");
                         p.sendMessage(cp + "/chargedcreeper - Spawn some charged creeps.");
                         p.sendMessage(cp + "/chickenplz - Give everyone some chickens!");
                         p.sendMessage(cp + "/iwantdiamonds - Free diamonds!!!");
                         p.sendMessage(cp + "/grief - Hehehehe!");
                         p.sendMessage(ChatColor.GRAY + "Do /alltrolls 2 to see next page.");
                    	
                    }else if(args.length == 1) {
                    	
                    	if(args[0].equalsIgnoreCase("1")) {
                    		
                    		p.sendMessage(ChatColor.GREEN + "GREEN " + ChatColor.GRAY + "commands mean the command is fully usable. " + ChatColor.GOLD + "GOLD " + ChatColor.GRAY + "commands are a work in progress and may or may not always work. " + ChatColor.RED + "RED " + ChatColor.GRAY + "command mean the command is a testing command for developers.");
                            p.sendMessage(cp + "/alltrolls - List all of the trolls");
                            p.sendMessage(cp + "/birthday - Spawn a cake and torches!");
                            p.sendMessage(cp + "/chargedcreeper - Spawn some charged creeps.");
                            p.sendMessage(cp + "/chickenplz - Give everyone some chickens!");
                            p.sendMessage(cp + "/iwantdiamonds - Free diamonds!!!");
                            p.sendMessage(cp + "/grief - Hehehehe!");
                            p.sendMessage(ChatColor.GRAY + "Do /alltrolls 2 to see next page.");

   
                    		
                    	}else if(args[0].equalsIgnoreCase("2")) {
                    		
                            p.sendMessage(cp + "/kaboom - Generate a random explosion radius at the executer.");
                            p.sendMessage(cp + "/keepmealive - Stop those dirty normies from almost killing you!");
                            p.sendMessage(ChatColor.GOLD + "/randomitem - Get any item in the game.");
                            p.sendMessage(cp + "/randomjoke - Broadcast funny jokes by Sh4nx!");
                    		p.sendMessage(cp + "/spam - Spam join messages.");
                            p.sendMessage(cp + "/superjump - Jump so high you make a boom!");
                    		p.sendMessage(cp + "/oof - OOf Somebody!");
                            p.sendMessage(cp + "/tomanyfish - To many fish for u!");
                            p.sendMessage(ChatColor.GRAY + "Do /alltrolls 3 to see next page.");
                    		
                    	}else if(args[0].equalsIgnoreCase("3")){
                    		
                            p.sendMessage(cp + "/explosivediamond - Make a diamond go boom on a player!");
                            p.sendMessage(cp + "/nuke - Create a massive explosion!");
                            p.sendMessage(cp + "/eggtroll - Eggs are now explosive.");
                            p.sendMessage(cp + "/lavatroll - All blocks that are broken will turn into lava.");
                            p.sendMessage(cp + "/starve - Starve a player.");
                            p.sendMessage(cp + "/burn - Burn a player.");
                            p.sendMessage(cp + "/scare - Scare a player by playing a sound");
                            p.sendMessage(ChatColor.RED + "/testblockreplace - Developer testing command.");
                            p.sendMessage(ChatColor.RED + "/testuuid - Developer testing command.");
                            
                    		
                    		
                    	}else {
                    		p.sendMessage(ChatColor.RED + "Currently do not have that help page!");
                    	}
                    }else {
                    	p.sendMessage(ChatColor.RED + "Currently do not have that help page!");
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
