package mc.sh4nx.flowchants.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_8_R3.Material;


public class fenchantadd implements CommandExecutor {

//TODO: /fenchants add <ENCHANT>e
	public static String LifeSteal = ChatColor.GRAY + "LifeSteal";
	public static String LifeSteal1 = ChatColor.GRAY + "LifeSteal I";
	public static String LifeSteal2 = ChatColor.GRAY + "LifeSteal II";
	public static String LifeSteal3 = ChatColor.GRAY + "LifeSteal III";
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("fenchants")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("flowchants.add")) {
					if(args.length < 1) {
						
						player.sendMessage(mc.sh4nx.flowchants.main.Main.prefix + ChatColor.RED + "Incorrect syntax! Please use: /fenchants add <enchant>");
						
					}else if(args.length == 1) {
						
						player.sendMessage(mc.sh4nx.flowchants.main.Main.prefix + ChatColor.RED + "Incorrect syntax! Please use: /fenchants add <enchant>");
						
					}else if(args.length == 2) {//TODO: SYNTAX CORRECT
						
						if(args[0].equalsIgnoreCase("add")) {
							
							
							if(player.getItemInHand() != null || player.getItemInHand().getItemMeta() != Material.AIR) {
								
							if(args[1].equalsIgnoreCase("LifeSteal1")) {
								
								
									
									ItemStack iteminhand = player.getItemInHand();
									ItemMeta meta = iteminhand.getItemMeta();
									ArrayList<String> lore = new ArrayList<String>();
									
									lore.add(LifeSteal1);
									
									meta.setLore(lore);
									iteminhand.setItemMeta(meta);
									
								}else if(args[1].equalsIgnoreCase("LifeSteal2")) {
									
									ItemStack iteminhand = player.getItemInHand();
									ItemMeta meta = iteminhand.getItemMeta();
									ArrayList<String> lore = new ArrayList<String>();
									
									lore.add(LifeSteal2);
									
									meta.setLore(lore);
									iteminhand.setItemMeta(meta);
									
								}else if(args[1].equalsIgnoreCase("LifeSteal3")) {
									
									ItemStack iteminhand = player.getItemInHand();
									ItemMeta meta = iteminhand.getItemMeta();
									ArrayList<String> lore = new ArrayList<String>();
									
									lore.add(LifeSteal3);
									
									meta.setLore(lore);
									iteminhand.setItemMeta(meta);
									
								}else {
									player.sendMessage(mc.sh4nx.flowchants.main.Main.prefix + ChatColor.RED + "Error! Could not find that enchant!");
								}
									
								}else {
									player.sendMessage(mc.sh4nx.flowchants.main.Main.prefix + ChatColor.RED + "You must have an item in hand!");
								}
								
								
						    
							
						}else if(args[0].equalsIgnoreCase("remove")) {
							//TODO: Remove enchant
							if(args[1].equalsIgnoreCase("LifeSteal")) {
								
									
									ItemStack iteminhand = player.getItemInHand();
									ItemMeta meta = iteminhand.getItemMeta();
									ArrayList<String> lore = new ArrayList<String>();

										if(iteminhand.getItemMeta().getLore().contains(LifeSteal1)) {
											lore.remove(LifeSteal1);
											meta.setLore(lore);
											iteminhand.setItemMeta(meta);
										}else if(iteminhand.getItemMeta().getLore().contains(LifeSteal2)) {
											lore.remove(LifeSteal2);
											meta.setLore(lore);
											iteminhand.setItemMeta(meta);
										}else if(iteminhand.getItemMeta().getLore().contains(LifeSteal3)) {
											lore.remove(LifeSteal3);
											meta.setLore(lore);
											iteminhand.setItemMeta(meta);
										}else {
											player.sendMessage(mc.sh4nx.flowchants.main.Main.prefix + ChatColor.RED + "Item does not have that enchant!");
										}
									
							}else {
								player.sendMessage(mc.sh4nx.flowchants.main.Main.prefix + ChatColor.RED + "Could not find that enchant!");
							}
							
							}else if(args[0].equalsIgnoreCase("clear")) {
							//TODO: clear all enchants
							
							ItemStack iteminhand = player.getItemInHand();
							ItemMeta meta = iteminhand.getItemMeta();
							ArrayList<String> lore = new ArrayList<String>();
							if(iteminhand.getItemMeta().hasLore()) {
							lore.clear();
							meta.setLore(lore);
							iteminhand.setItemMeta(meta);
							player.sendMessage(mc.sh4nx.flowchants.main.Main.prefix + "Cleared all custom enchants from " + player.getItemInHand());
							}else {
								player.sendMessage(mc.sh4nx.flowchants.main.Main.prefix + "Nothing to clear!");
							}
							
							
						}else if(args[0].equalsIgnoreCase("desc")) {
							//TODO: Get description of enchant
							if(args[1].equalsIgnoreCase("Lifesteal")) {
								player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD.toString() + "LifeSteal (I-III)" + ChatColor.DARK_GRAY + "| " + ChatColor.YELLOW + "Have a 10%/20%/30% chance to gain 1 heart everytime you hit something!");
								
							}else {
								player.sendMessage(mc.sh4nx.flowchants.main.Main.prefix + ChatColor.RED + "Enchant not found!");
							}
							
							
						}else if(args[0].equalsIgnoreCase("test")) {
							
							ItemStack iteminhand = player.getItemInHand();
							ItemMeta meta = iteminhand.getItemMeta();
							ArrayList<String> lore = new ArrayList<String>();
							lore.add(ChatColor.GRAY + "This is a test lore on line1");
							lore.add(ChatColor.GRAY + "This is the second line of the test!");
							meta.setLore(lore);
							iteminhand.setItemMeta(meta);
							
							player.sendMessage(ChatColor.RED + "Test ran! Item lore added to " + player.getItemInHand());
							
						}else {
							player.sendMessage(mc.sh4nx.flowchants.main.Main.prefix + ChatColor.RED + "Could not find this argument! Try add|remove|clear|desc");
						}
						
					}else if(args.length > 2) {
						
						player.sendMessage(mc.sh4nx.flowchants.main.Main.prefix + ChatColor.RED + "Incorrect syntax! Please use: /fenchants add <enchant>");
						
					}else {
						player.sendMessage(mc.sh4nx.flowchants.main.Main.prefix + ChatColor.RED + "Incorrect syntax! Please use: /fenchants add <enchant>");
					}
				}else {
					player.sendMessage(mc.sh4nx.flowchants.main.Main.prefix + ChatColor.RED + "No Permission!");
				}
			}else{
				sender.sendMessage(ChatColor.DARK_RED + "You need to be a player to do this!");
			}
		}

	

	
		return false;
	}
}
