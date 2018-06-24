package mc.Sh4nx.staffparty.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class explosiveEggThrowEvent implements Listener {
	
	@EventHandler
	public void eggThrow(ProjectileHitEvent event) {
		
		if(mc.Sh4nx.staffparty.commands.eggtroll.eggTroll == true) {
			
			
			if(event.getEntity() instanceof Egg) {
				Entity egg = event.getEntity();
				Location loc = egg.getLocation();
				World world = event.getEntity().getWorld();
				world.createExplosion(loc, 2.25F);
				
		}
		
		
		}
	}

}
