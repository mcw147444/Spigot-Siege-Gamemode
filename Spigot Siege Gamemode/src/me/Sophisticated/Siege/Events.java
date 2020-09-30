package me.Sophisticated.Siege;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.PlayerInventory;

public class Events implements Listener {

	static Main plugin;
	public Events(Main instance) {
		plugin = instance;
	}
	
	@EventHandler()
	public void gameSettingOnClick(PlayerInteractEvent event) {
		Player player = (Player) event.getPlayer();
		if (player.getInventory().getItemInMainHand().getType().equals(Material.NETHER_STAR))
			if (player.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				//Right click
				if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					player.openInventory(plugin.gameSettingGUI);
					return;
				}
			}
		return;
	}
	
	@EventHandler()
	public void gameSettingGUI(InventoryClickEvent event) {
		
		if (!event.getInventory().equals(plugin.gameSettingGUI)) return;
		if (event.getCurrentItem() == null) return;
		if (event.getCurrentItem().getItemMeta() == null) return;
		if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		
		Player player = (Player) event.getWhoClicked();
		
		event.setCancelled(true);
		
		if (event.getSlot() == 3 && event.getCurrentItem().getType() == Material.WHITE_WOOL) {
			player.openInventory(plugin.chooseTeamGUI);
			return;
		}
		if (event.getSlot() == 5 && event.getCurrentItem().getType() == Material.SHIELD) {
			player.openInventory(plugin.chooseClassGUI);
			return;
		}
		
		
		return;
		
	}
	
	@EventHandler()
	public void pickClassGUI(InventoryClickEvent event) {
		
		if (!event.getInventory().equals(plugin.chooseClassGUI)) return;
		if (event.getCurrentItem() == null) return;
		if (event.getCurrentItem().getItemMeta() == null) return;
		if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		
		Player player = (Player) event.getWhoClicked();
		
		event.setCancelled(true);
		
		if (event.getSlot() == 0 && event.getCurrentItem().getType() == Material.SHIELD) {
			plugin.sat.chooseClass(plugin.classes.classNames, "warrior", player);
			return;
		}
		if (event.getSlot() == 1 && event.getCurrentItem().getType() == Material.IRON_PICKAXE) {
			plugin.sat.chooseClass(plugin.classes.classNames, "builder", player);
			return;
		}
		if (event.getSlot() == 2 && event.getCurrentItem().getType() == Material.BOW) {
			plugin.sat.chooseClass(plugin.classes.classNames, "hunter", player);
			return;
		}
		if (event.getSlot() == 3 && event.getCurrentItem().getType() == Material.TNT) {
			plugin.sat.chooseClass(plugin.classes.classNames, "demolitionist", player);
			return;
		}
		if (event.getSlot() == 4 && event.getCurrentItem().getType() == Material.DIAMOND_AXE) {
			plugin.sat.chooseClass(plugin.classes.classNames, "heavy", player);
			return;
		}
		if (event.getSlot() == 5 && event.getCurrentItem().getType() == Material.BLAZE_ROD) {
			plugin.sat.chooseClass(plugin.classes.classNames, "mage", player);
			return;
		}
		if (event.getSlot() == 6 && event.getCurrentItem().getType() == Material.SPLASH_POTION) {
			plugin.sat.chooseClass(plugin.classes.classNames, "medic", player);
			return;
		}
		if (event.getSlot() == 8 && event.getCurrentItem().getType() == Material.BARRIER) {
			player.openInventory(plugin.gameSettingGUI);
			return;
		}
		
		return;
		
	}
	
	@EventHandler()
	public void chooseTeamGUI(InventoryClickEvent event) {
		
		if (!event.getInventory().equals(plugin.chooseTeamGUI)) return;
		if (event.getCurrentItem() == null) return;
		if (event.getCurrentItem().getItemMeta() == null) return;
		if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		
		Player player = (Player) event.getWhoClicked();
		
		event.setCancelled(true);
		
		if (event.getSlot() == 2 && event.getCurrentItem().getType() == Material.BLUE_WOOL) {
			plugin.sat.addToTeam("defense", player);
			return;
		}
		if (event.getSlot() == 6 && event.getCurrentItem().getType() == Material.RED_WOOL) {
			plugin.sat.addToTeam("offense", player);
			return;
		}
		if (event.getSlot() == 4 && event.getCurrentItem().getType() == Material.BARRIER) {
			player.openInventory(plugin.gameSettingGUI);
			return;
		}
		
		return;
		
	}
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		for (Player online : Bukkit.getOnlinePlayers()) {
			plugin.sat.createHubBoard(plugin.classes.classNames, online);
		}
		PlayerInventory inv = player.getInventory();
		inv.clear();
		player.getInventory().addItem(plugin.gameItems.getGameSettings());
		
		
	}
	
	
}
