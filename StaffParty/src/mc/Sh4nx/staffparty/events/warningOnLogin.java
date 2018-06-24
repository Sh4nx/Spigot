package mc.Sh4nx.staffparty.events;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;



import net.md_5.bungee.api.ChatColor;

public class warningOnLogin implements Listener {
	
	@EventHandler
	public void playerLoginEvent(PlayerJoinEvent e) {
		
		Player player = e.getPlayer();
		if(Bukkit.getServer().getPluginManager().isPluginEnabled("ViaVersion")) {
		if(e.getPlayer().hasPermission("sp.fun") || e.getPlayer().isOp() == true) {
			player.sendMessage(ChatColor.RED + "Warning! Using StaffParty with ViaVersion is known to cause some slight errors with certain commands. The plugin will still function as intended,");
		}
		}
		
	}

}
