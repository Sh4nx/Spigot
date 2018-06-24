package mc.sh4nx.xpcore.main;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Animals;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import mc.sh4nx.xpcore.utils.PlayerLevelManager;


/* GitHub Push
 * @Author
 * Jacob Luvisi
 * Minecraft IGN: Sh4nx
 * With Love <3
 * 
 */

public class Main extends JavaPlugin implements Listener {
	
	boolean scoreBoardEnabled = this.getConfig().getBoolean("scoreboard");

    private HashMap<UUID, PlayerLevelManager> levelManagerHashMap;

    @Override
    public void onEnable() {
        this.levelManagerHashMap = new HashMap<>();
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        
        getCommand("myxp");
        getCommand("xpcore");
        getCommand("xpinfo");
        getCommand("xplist");
        getCommand("adminlevel");
    }

    @Override
    public void onDisable() {
        this.levelManagerHashMap.clear();
    }

    @EventHandler
    public void join(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage("");

        if (!player.hasPlayedBefore()) {
            player.sendMessage("§bWelcome, your level is §a0");

            this.levelManagerHashMap.put(player.getUniqueId(), new PlayerLevelManager(0, 0));
            this.getConfig().set("PlayerLevels." + player.getUniqueId() + ".level", 0);
            this.getConfig().set("PlayerLevels." + player.getUniqueId() + ".xp", 0);
            this.saveConfig();

            this.setscore(player, 0, 0);
        } else {
            int level = this.getConfig().getInt("PlayerLevels." + player.getUniqueId() + ".level");
            int xp = this.getConfig().getInt("PlayerLevels." + player.getUniqueId() + ".xp");
            levelManagerHashMap.put(player.getUniqueId(), new PlayerLevelManager(level, xp));
            setscore(player, level, xp);
        }
    }

    @EventHandler
    public void quit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        PlayerLevelManager playerLevelManager = this.levelManagerHashMap.get(player.getUniqueId());

        if (this.levelManagerHashMap.containsKey(player.getUniqueId())) {
            this.getConfig().set("PlayerLevels." + player.getUniqueId() + ".level", playerLevelManager.getLevel());
            this.getConfig().set("PlayerLevels." + player.getUniqueId() + ".xp", playerLevelManager.getXp());
            this.saveConfig();
            this.levelManagerHashMap.remove(player.getUniqueId());
        }
    }

    @EventHandler
    public void blockbreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        PlayerLevelManager playerLevelManager = this.levelManagerHashMap.get(player.getUniqueId());
        Block block = event.getBlock();

        if (block.getType() == Material.EMERALD_ORE) {
        	
            playerLevelManager.setXp(playerLevelManager.getXp() + 350);
            player.sendMessage("§9+350 Experience");
            xpcheck(player, playerLevelManager);
            setscore(player, playerLevelManager.getLevel(), playerLevelManager.getXp());

        }else if(block.getType() == Material.DIAMOND_ORE) {
        	
        	playerLevelManager.setXp(playerLevelManager.getXp() + 250);
            player.sendMessage("§9+250 Experience");
            xpcheck(player, playerLevelManager);
            setscore(player, playerLevelManager.getLevel(), playerLevelManager.getXp());
        	
        }else if(block.getType() == Material.REDSTONE_ORE || block.getType() == Material.LAPIS_ORE || block.getType() == Material.IRON_ORE || block.getType() == Material.GOLD_ORE){
        	
        	playerLevelManager.setXp(playerLevelManager.getXp() + 100);
            player.sendMessage("§9+100 Experience");
            xpcheck(player, playerLevelManager);
            setscore(player, playerLevelManager.getLevel(), playerLevelManager.getXp());
        	
        }else if(block.getType() == Material.COAL_ORE){
        	
        	playerLevelManager.setXp(playerLevelManager.getXp() + 25);
            player.sendMessage("§9+25 Experience");
            xpcheck(player, playerLevelManager);
            setscore(player, playerLevelManager.getLevel(), playerLevelManager.getXp());
        	
        }else {
        	
        	playerLevelManager.setXp(playerLevelManager.getXp() + 3);
            player.sendMessage("§7§o+3 Experience");
            xpcheck(player, playerLevelManager);
            setscore(player, playerLevelManager.getLevel(), playerLevelManager.getXp());
        }
    }
    
    @EventHandler
    public void playerDeath(PlayerDeathEvent e) {
    	if(e.getEntity() instanceof Player) {
    		Player killedPlayer = e.getEntity().getPlayer();
    		
    		PlayerLevelManager playerLevelManager = this.levelManagerHashMap.get(killedPlayer.getUniqueId());
    		
    		if(playerLevelManager.getXp() < 4500) {
    			playerLevelManager.setXp(0);

    			killedPlayer.sendMessage("§cYou died and have lost all of your XP!");
    			setscore(killedPlayer, playerLevelManager.getLevel(), playerLevelManager.getXp());
    		}else {
    			playerLevelManager.setXp(playerLevelManager.getXp() - 4500);
    			killedPlayer.sendMessage("§cYou died and have lost 4500XP!");
    			setscore(killedPlayer, playerLevelManager.getLevel(), playerLevelManager.getXp());
    		}
    		
    		
    	}
    }
    
    @EventHandler
    public void playerDeathRewardForKiller(PlayerDeathEvent e) {
    	if(e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player) {
    		Player killer = e.getEntity().getKiller().getPlayer();
    		
    		PlayerLevelManager playerLevelManager = this.levelManagerHashMap.get(killer.getUniqueId());
    		
    		playerLevelManager.setXp(playerLevelManager.getXp() + 1000);
            killer.sendMessage("§9§l+1000 Experience");
            xpcheck(killer, playerLevelManager);
            setscore(killer, playerLevelManager.getLevel(), playerLevelManager.getXp());
    		
    	}
    }
    
    @EventHandler
    public void playerKillAnimal(EntityDeathEvent e) {
    	if(e.getEntity() instanceof LivingEntity) {
    		if(e.getEntity() instanceof Monster || e.getEntity() instanceof Animals) {
    			
    			if(e.getEntity().getKiller() instanceof Player) {
    				Player p = e.getEntity().getKiller();
    				
    				PlayerLevelManager playerLevelManager = this.levelManagerHashMap.get(p.getUniqueId());
    				
    				playerLevelManager.setXp(playerLevelManager.getXp() + 15);
    	            p.sendMessage("§9+15 Experience");
    	            xpcheck(p, playerLevelManager);
    	            setscore(p, playerLevelManager.getLevel(), playerLevelManager.getXp());
    			}
    		}
    	}
    }

    private void xpcheck(Player player, PlayerLevelManager playerLevelManager) {
        int xpneeded = this.getConfig().getInt("Levels.1.xp");
        
        int xp = playerLevelManager.getXp();

        
        	
        	if (xp  >= ((xpneeded * 2) * playerLevelManager.getLevel()) * 2) {
                player.sendMessage("§eLeveled UP!");
                playerLevelManager.setLevel(playerLevelManager.getLevel() + 1);
                playerLevelManager.setXp(0);

        	}
    }

    private void setscore(Player player, int level, int xp) {
        Scoreboard scoreboard = this.getServer().getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("test", "dummy");

        objective.setDisplayName("§a§lXP Core §8| §cScoreboard");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score lvl = objective.getScore("§3Level: §a" + level);
        lvl.setScore(1);
        
        
        
        Score exp = objective.getScore("§3XP: §a" + xp);
        exp.setScore(0);

        if(scoreBoardEnabled == true) {
        player.setScoreboard(scoreboard);
        }
    }
    
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("myxp")) {
			if(sender instanceof Player) {
				
				Player p = (Player) sender;
				
				PlayerLevelManager playerLevelManager = this.levelManagerHashMap.get(p.getUniqueId());
				
				p.sendMessage("§aLevel §8|§b " + playerLevelManager.getLevel());
				p.sendMessage("§aXP §8|§3 " + playerLevelManager.getXp());
			}else {
				sender.sendMessage("§cYou must be a player!");
			}
		}else if(command.getName().equalsIgnoreCase("xpcore")) {
			if(sender instanceof Player) {
				
				Player p = (Player) sender;
				
				p.sendMessage("§a§lXP Core §8| §aMade by Sh4nx");
				p.sendMessage("§a/myxp §8- §cView your current level and xp!");
				p.sendMessage("§a/adminlevel give|remove|set §8- §cChange someones level.");
				p.sendMessage("§a/xplist §8- §cView all gains/looses for xp!");
				p.sendMessage("§a/xpinfo §8- §cGet a full book describing xp.");
			}else {
				sender.sendMessage("You must be a player!");
			}
		}else if(command.getName().equalsIgnoreCase("xplist")) {
			
			if(sender instanceof Player) {
				
				Player p = (Player) sender;
				
				p.sendMessage("§a§lXP Core §8| §aMade by Sh4nx");
				p.sendMessage("§aXP LIST:");
				p.sendMessage("§eMINING:");
				p.sendMessage("§3EMERALD_ORE: §e+350XP");
				p.sendMessage("§3DIAMOND_ORE: §e+250XP");
				p.sendMessage("§3REDSTONE_ORE, LAPIS_ORE, IRON_ORE, GOLD_ORE: §e+100XP");
				p.sendMessage("§3COAL_ORE: §e+25XP");
				p.sendMessage("§3OTHER BLOCKS: §e+3XP");
				p.sendMessage("§eKILLING:");
				p.sendMessage("§3PLAYER_KILL: §e+1000XP");
				p.sendMessage("§3ENTITY_KILL: §e+15XP");
				p.sendMessage("§eDYING:");
				p.sendMessage("§31_DEATH: §c-4,500XP");

				
			}else {
				sender.sendMessage("You must be a player!");
			}
			
		}else if(command.getName().equalsIgnoreCase("xpinfo")) {
			
			if(sender instanceof Player) {
				
				Player p = (Player) sender;

				p.sendMessage("§aBook obtained!");
				
				ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
				BookMeta bm = (BookMeta) book.getItemMeta();
				bm.setAuthor("§e§lSh4nx");
				
				bm.addPage("§2§lWhat is XP Core? §0§l| §3XP Core is a plugin developed by Sh4nx. XP Core is an RPG based plugin where you can mine blocks and kill mobs to gain xp. If you gain enough xp you can level up to the next level. Each time you level up you gain 1 credit.");
				bm.addPage("§3You can check your credits with §c/myxp§3. You can also check how much xp you gain/loose for certain tasks by doing §c/xplist§3. §3Credits can be used in §c/upgrades§3 to upgrade your total damage done, armor resistance, health, or give potion effects.");
				bm.addPage("§3Everything you purchase from §c/upgrades§3 is permanent except potion effects. If you die with potion effects they are removed, but as long as you don't die they stay. So get kills and mining to gain as much xp as possible!");
				bm.addPage("§4- Please report any bugs to Sh4nx. Thanks for taking your time to read this! :)");
				bm.setTitle("§aXP CORE REVIEW");
				book.setItemMeta(bm); 
				
				p.getInventory().addItem(book);
				
			}else {
				sender.sendMessage("You must be a player!");
			}
		
	}else if(command.getName().equalsIgnoreCase("adminlevel")) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("xpcore.adminlevel")) { //TODO: /adminlevel give|remove|set <player> <integer>
				
				if(args.length == 0) {
					
					p.sendMessage("§cUse /adminlevel give|remove|set <player> <amount>");
					
				}else if(args.length == 1) {
					
					p.sendMessage("§cUse /adminlevel give|remove|set <player> <amount>");
					
				}else if(args.length == 2) {
					
					p.sendMessage("§cUse /adminlevel give|remove|set <player> <amount>");
					
				}else if(args.length == 3) {
					
					if(args[0].equalsIgnoreCase("give")) {
						
						Player target = Bukkit.getPlayerExact(args[1]);
    					
    					if(target == null) {
    						
    						p.sendMessage(ChatColor.RED + "The player " + args[1].toString() + " is not online!");
    						
    					}else {
    						
    						try {
    							
    						int amount = Integer.parseInt(args[2]);
    						
    						PlayerLevelManager playerLevelManager = this.levelManagerHashMap.get(target.getUniqueId());
    						
    						try {
    						playerLevelManager.setLevel(playerLevelManager.getLevel() + amount);
    						}catch(Exception e){
    							p.sendMessage("§cThere was an error. Are you sure the player has enough levels and you are not using negative numbers?");
    						}
    						
    						}catch(Exception e) {
    							p.sendMessage("§cPlease use a number for XP!");
    						}
    						
    					}
						
					}else if(args[0].equalsIgnoreCase("remove")) {
						
						Player target = Bukkit.getPlayerExact(args[1]);
    					
    					if(target == null) {
    						
    						p.sendMessage(ChatColor.RED + "The player " + args[1].toString() + " is not online!");
    						
    					}else {
    						
    						try {
    							
    						int amount = Integer.parseInt(args[2]);
    						
    						PlayerLevelManager playerLevelManager = this.levelManagerHashMap.get(target.getUniqueId());
    						
    						try {
    							
    						playerLevelManager.setLevel(playerLevelManager.getLevel() - amount);
    						
    						}catch(Exception e){
    							p.sendMessage("§cThere was an error. Are you sure the player has enough levels and you are not using negative numbers?");
    						}
    						
    						}catch(Exception e) {
    							p.sendMessage("§cPlease use a number for XP!");
    						}
    						
    					}
						
						
						
					}else if(args[0].equalsIgnoreCase("set")) {
						
						Player target = Bukkit.getPlayerExact(args[1]);
    					
    					if(target == null) {
    						
    						p.sendMessage(ChatColor.RED + "The player " + args[1].toString() + " is not online!");
    						
    					}else {
    						
    						try {
    							
    						int amount = Integer.parseInt(args[2]);
    						
    						PlayerLevelManager playerLevelManager = this.levelManagerHashMap.get(target.getUniqueId());
    						
    						try {
    						playerLevelManager.setLevel(amount);
    						}catch(Exception e){
    							p.sendMessage("§cThere was an error. Are you sure the player has enough levels and you are not using negative numbers?");
    						}
    						
    						
    						}catch(Exception e) {
    							p.sendMessage("§cPlease use a number for XP!");
    						}
    						
    					}
						
						
						
						
					}else {
						p.sendMessage("§cUse /adminlevel give|remove|set <player> <amount>");
					}
					
				}else {
					p.sendMessage("§cUse /adminlevel give|remove|set <player> <amount>");
				}
				
			}else {
				p.sendMessage("§cYou are not allowed to do this!");
			}

			
		}else {
			sender.sendMessage("You must be a player!");
		}
		
	}
		return false;
    
    
    }

}
