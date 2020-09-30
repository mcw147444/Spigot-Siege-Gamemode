package me.Sophisticated.Siege;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GameItems {

	public ItemStack getGameSettings() {
		
		ItemStack gameSettings = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = gameSettings.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Game Settings");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "Right Click to Adjust Game Settings");
		lore.add("");
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		gameSettings.setItemMeta(meta);
		
		return gameSettings;
	}
	
}
