package mc.sh4nx.flowchants.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class flowchants implements CommandExecutor {
	
	private String ga = ChatColor.GRAY + "* ";


	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(command.getName().equalsIgnoreCase("flowchant")) {
			
			if(sender instanceof Player) { //TODO: VERIFICATION OF PLAYER
				
				Player player = (Player) sender; //TODO: CASTING
				
				if(player.hasPermission("flowchants.help")) { //TODO: SPECIFIC PERMISSION
					
					player.sendMessage(ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH.toString() + "---------------" + ChatColor.RESET.toString() + ChatColor.DARK_GRAY.toString() + ChatColor.BOLD.toString() + "[" + ChatColor.RESET.toString() + ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Flowchants" + ChatColor.RESET.toString() + ChatColor.DARK_GRAY.toString() + ChatColor.BOLD.toString() + "]" + ChatColor.RESET.toString() + ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH.toString() + "---------------");
					player.sendMessage(ChatColor.RED.toString() + ChatColor.ITALIC.toString() + "Commands " +  ChatColor.RESET.toString() + ChatColor.GRAY.toString() + ChatColor.ITALIC.toString() + ">");
					player.sendMessage(ga + ChatColor.GREEN + "/fenchants list " + ChatColor.GRAY + "| " + ChatColor.DARK_AQUA + "View a fancy GUI with all enchants and descriptions!");
					player.sendMessage(ga + ChatColor.GREEN + "/fenchants add " + ChatColor.GRAY + "| " + ChatColor.DARK_AQUA + "Add an enchant to your item in hand!");
					player.sendMessage(ga + ChatColor.GREEN + "/fenchants remove " + ChatColor.GRAY + "| " + ChatColor.DARK_AQUA + "Remove an enchant from your item in hand!");
					player.sendMessage(ga + ChatColor.GREEN + "/fenchants clear all" + ChatColor.GRAY + "| " + ChatColor.DARK_AQUA + "Remove all enchants from your item in hand!");
					player.sendMessage(ga + ChatColor.GREEN + "/fenchants desc " + ChatColor.GRAY + "| " + ChatColor.DARK_AQUA + "View the exact details of a certain enchant!");
					
				}else {
					//TODO: NO PERMS FOR /flowchants
					player.sendMessage(mc.sh4nx.flowchants.main.Main.prefix + ChatColor.RED + "No Permission!");
				}
				
			}else {
				//TODO: NOT A PLAYER
				sender.sendMessage(ChatColor.DARK_RED + "You need to be a player to do this!");
			}
		}
		return false;
	}

}
