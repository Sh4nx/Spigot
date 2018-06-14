package mc.sh4nx.flowchants.events;


import java.util.Random;

import org.bukkit.entity.Animals;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import net.md_5.bungee.api.ChatColor;


public class LifeStealEvent implements Listener {
	
	boolean isTesting = true;

	@EventHandler
	public void onPlayerAttack(EntityDamageByEntityEvent event)
	{
	  if(event.getEntity() instanceof Player || event.getEntity() instanceof Animals && event.getDamager() instanceof Player)
	    {
	      
		  int max = 10;
		  int min = 1;
		  
		  Random chanceOfHeart = new Random();
		  int eventDidOccur = min + chanceOfHeart.nextInt(max);
		  
		  
		  Player player = (Player) event.getDamager();
		  
		  if(isTesting == true) {
			  player.sendMessage(ChatColor.RED + "Number is " + ChatColor.GOLD + eventDidOccur);
		  }
		  
		  double playerHealth = player.getHealth();
		  
		  if(player.getItemInHand().getItemMeta().getLore().contains(mc.sh4nx.flowchants.commands.fenchantadd.LifeSteal1)) {
			  
			  if(eventDidOccur == 5) {
				  
				  player.setHealth(playerHealth + 2);
				  
				  
			  }
			  
		  }else if(player.getItemInHand().getItemMeta().getLore().contains(mc.sh4nx.flowchants.commands.fenchantadd.LifeSteal2)) {
			  
			  if(eventDidOccur == 5 || eventDidOccur == 6) {
				  player.setHealth(playerHealth + 2);
				  
				  
			  }
			  
		  }else if(player.getItemInHand().getItemMeta().getLore().contains(mc.sh4nx.flowchants.commands.fenchantadd.LifeSteal3)) {
			  
			  if(eventDidOccur == 4 || eventDidOccur == 5 || eventDidOccur == 6) {
				  player.setHealth(playerHealth + 2);
				  
				  
			  }
			  
		  }
		  
	    }
	}

}
