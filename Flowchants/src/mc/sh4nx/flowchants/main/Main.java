package mc.sh4nx.flowchants.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import mc.sh4nx.flowchants.commands.fenchantadd;
import mc.sh4nx.flowchants.commands.flowchants;
import mc.sh4nx.flowchants.events.LifeStealEvent;



public class Main extends JavaPlugin {
	
	public String author = "Sh4nx";
	public String spigotBuild = "spigot-1.8.8-R0.1-SNAPSHOT.jar";
	public String firstBuildDate = "6/14/18";
	public String totalUpdates = "2";
	
	public static String prefix = ChatColor.BLUE.toString() + ChatColor.BOLD.toString() + "Flowchants " + ChatColor.DARK_GRAY.toString() + ChatColor.BOLD.toString() + "// " + ChatColor.YELLOW.toString();
	
	
	PluginDescriptionFile pdf = this.getDescription();
	
	   public String version = pdf.getVersion();
	
	public void commandManager() {
		
		getCommand("flowchant").setExecutor(new flowchants());
		
		getCommand("fenchants").setExecutor(new fenchantadd());
		
	}
	
	public void eventManager() {
		Bukkit.getServer().getPluginManager().registerEvents(new LifeStealEvent(), this);
	}
	
	public void onEnable() {
		
		getServer().getLogger().info("Flowchants (1.8.8) starting up! Your version is " + version);
		getServer().getLogger().info("Flowchants Spigot Build No. | " + spigotBuild);
		getServer().getLogger().info("Flowchants total updates | " + totalUpdates);
		
		commandManager();
		eventManager();
	}
	
	public void onDisable() {
		
		getServer().getLogger().info("Flowchants (1.8.8) disabling! Your version is " + version);
		
		
	}

}
