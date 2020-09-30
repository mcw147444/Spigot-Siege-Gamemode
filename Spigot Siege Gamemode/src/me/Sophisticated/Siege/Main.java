package me.Sophisticated.Siege;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {

	public Player player;
	public GameItems gameItems = new GameItems();
	public GUIs guis = new GUIs();
	public Inventory gameSettingGUI = guis.createGameSettingGUI();
	public Inventory chooseTeamGUI = guis.createTeamGUI();
	public Inventory chooseClassGUI = guis.createClassGUI();
	public ScoreboardsAndTeams sat = new ScoreboardsAndTeams();
	public Classes classes = new Classes();

	
	
	@Override
	public void onEnable() {
		
		this.getServer().getPluginManager().registerEvents(new Events(this), this);
		
		//if false, the server will go through all the players online, when the server is enabled, and create the hub scoreboard
		
		if (!Bukkit.getOnlinePlayers().isEmpty())
			for (Player online : Bukkit.getOnlinePlayers()) {
				sat.createHubBoard(classes.classNames, online);
			}

	}
	
	@Override
	public void onDisable() {
		
		
	}
	
	//for admin use only to test and debug the gamemode
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		
		
		return false;
	
	}
	
}
