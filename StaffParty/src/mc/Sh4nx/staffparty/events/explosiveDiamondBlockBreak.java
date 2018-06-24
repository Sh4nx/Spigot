package mc.Sh4nx.staffparty.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.potion.PotionEffectType;

public class explosiveDiamondBlockBreak implements Listener {
	
	@EventHandler
	public void blockBreak(BlockBreakEvent event) {
		
		if(event.getBlock().getType() == Material.DIAMOND_ORE) {
			Player p = event.getPlayer();
			if(p.hasPotionEffect(PotionEffectType.SATURATION)) {
				p.getWorld().createExplosion(p.getLocation(), 3.5F);
			}
		}
		
	}

}
