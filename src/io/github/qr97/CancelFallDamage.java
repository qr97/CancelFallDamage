package io.github.qr97;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.plugin.java.JavaPlugin;

public class CancelFallDamage extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(new Listener() {
			
			@EventHandler
			public void onDamage(EntityDamageEvent event) {
				if((event.getEntity() instanceof Player) 
						&& (event.getCause().equals(DamageCause.FALL))
						&& ((Player)event.getEntity()).hasPermission("cancelfalldamage.cancel")) {
					event.setCancelled(true);
				}
			}
			
		}, this);
		
	}
	
}
