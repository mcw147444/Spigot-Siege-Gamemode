package me.Sophisticated.Siege;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class GUIs {
	
	ItemStack item;
	ItemMeta meta;
	List<String> lore = new ArrayList<String>();
	
	public Inventory createClassGUI() {
		
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Choose Class");
		
		//warrior
		item.setType(Material.SHIELD);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE + "Warrior");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(0, item);
		
		//builder
		item.setType(Material.IRON_PICKAXE);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE + "Builder");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(1, item);
		
		//hunter
		item.setType(Material.BOW);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE + "Hunter");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(2, item);
		
		//demo
		item.setType(Material.TNT);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE + "Demolitionist");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(3, item);
		
		//heavy
		item.setType(Material.DIAMOND_AXE);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE + "Heavy");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(4, item);
		
		//mage
		item.setType(Material.BLAZE_ROD);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE + "Mage");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(5, item);
		
		//medic
		item.setType(Material.SPLASH_POTION);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE + "Medic");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(6, item);
		
		//back button
		item.setType(Material.BARRIER);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(8, item);
		
		return inv;
		
	}
	
	public Inventory createTeamGUI() {
		
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "" + ChatColor.BOLD + "Choose Team");
		
		//defense
		item.setType(Material.BLUE_WOOL);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.BLUE + "Defense");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(2, item);
		
		
		//exit
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "Back");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(4, item);
		
		
		//offense
		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.RED + "Offense");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(6, item);
		
		return inv;
		
	}
	
	
	public Inventory createGameSettingGUI() {
		
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "" + ChatColor.BOLD + "Game Setttings");
		
		//Vote Next Map button
		item = new ItemStack(Material.COMPASS);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Vote next map");
		lore.add(ChatColor.GRAY + "Click to vote for the next map");
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(1, item);
		
		
		//Team Select button
		item.setType(Material.WHITE_WOOL);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE + "Choose team");
		lore.clear();
		lore.add(ChatColor.GRAY + "Click to choose a team");
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(3, item);
		
		
		//Class Select button
		item.setType(Material.SHIELD);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Choose class");
		lore.clear();
		lore.add(ChatColor.GRAY + "Click to choose a class");
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(5, item);
		
		
		//Exit Button
		item.setType(Material.BARRIER);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_RED + "Exit");
		lore.clear();
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		inv.setItem(7, item);
		
		return inv;
		
	}
	
	
}
