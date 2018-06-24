package mc.Sh4nx.staffparty.events;


import org.bukkit.Material;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;



public class blockBreakLavaChange implements Listener {
	

	@EventHandler
	public void blockBreak(BlockBreakEvent event) {
		
		if(mc.Sh4nx.staffparty.commands.lavatroll.lavaTroll == true) {
			
			event.setCancelled(true);
			event.getBlock().setType(Material.LAVA);
				
		}else if(mc.Sh4nx.staffparty.commands.testcobblebreak.blocktest == true) {
			
			if(event.getBlock().getType() == Material.SMOOTH_BRICK) { //TODO: If the block being broke is this
				event.setCancelled(true); //TODO: Dont let the block get broken. 
				event.getBlock().setType(Material.GRAVEL); //TODO: Replace the cancelled block with a new block
				Player p = event.getPlayer(); //TODO: Get the player
				ItemStack stack = new ItemStack(Material.FLINT, 1);
				p.getInventory().addItem(stack); //TODO: Give the player an item from the block break.
			}
		}
		
		
		}
	}


