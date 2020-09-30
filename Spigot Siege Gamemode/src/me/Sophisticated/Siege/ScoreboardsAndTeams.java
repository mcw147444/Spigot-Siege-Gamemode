package me.Sophisticated.Siege;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class ScoreboardsAndTeams {

	public final List<String> teams = new ArrayList<String>
		(Arrays.asList("defense","offense"));
	
	public final int maxTeamPlayers = 10;
	public ScoreboardManager manager = Bukkit.getScoreboardManager();
	public Scoreboard hubBoard = manager.getNewScoreboard();
	public Objective obj = hubBoard.registerNewObjective("Siege Teams", "dummy", ChatColor.GOLD + "" + ChatColor.BOLD + "Siege Teams");
	
	
	
	
	
	public void createHubBoard(List<String> classes, Player player) {
		
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Score detail = obj.getScore(ChatColor.WHITE + "=======================");
		detail.setScore(30);
		
		//Warrior
		Team warrior = hubBoard.registerNewTeam(classes.get(0));
		warrior.setPrefix("[Warrior]");
		warrior.setDisplayName("Warrior");
		
		//Builder
		Team builder = hubBoard.registerNewTeam(classes.get(1));
		builder.setPrefix("[Builder]");
		builder.setDisplayName("Builder");
		
		//Hunter
		Team hunter = hubBoard.registerNewTeam(classes.get(2));
		hunter.setPrefix("[Hunter]");
		hunter.setDisplayName("Hunter");
		
		//Demo
		Team demolitionist = hubBoard.registerNewTeam(classes.get(3));
		demolitionist.setPrefix("[Demolitionist]");
		demolitionist.setDisplayName("Demolitionist");
		
		//Heavy
		Team heavy = hubBoard.registerNewTeam(classes.get(4));
		heavy.setPrefix("[Heavy]");
		heavy.setDisplayName("Heavy");
		
		//Mage
		Team mage = hubBoard.registerNewTeam(classes.get(5));
		mage.setPrefix("[Mage]");
		mage.setDisplayName("Mage");
		
		//Medic
		Team medic = hubBoard.registerNewTeam(classes.get(6));
		medic.setPrefix("[Medic]");
		medic.setDisplayName("Medic");
		
		//onlineTeam
		Score online = obj.getScore(ChatColor.WHITE + "Players Online");
		online.setScore(29);
		
		Team onlineCounter = hubBoard.registerNewTeam("onlineCounter");
		onlineCounter.addEntry(ChatColor.WHITE + " Online");
		
		
		if (Bukkit.getOnlinePlayers().size() == 0) {
			onlineCounter.setPrefix(ChatColor.WHITE + "0/" + Bukkit.getMaxPlayers());
		} else {
			onlineCounter.setPrefix("" + ChatColor.WHITE + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
		}
		Score sc = obj.getScore(ChatColor.WHITE + onlineCounter.getPrefix().toString());
		sc.setScore(28);
		
		Score detail2 = obj.getScore(ChatColor.WHITE + "=-=-=-=-=-=-=-=-=-=-=-=");
		detail2.setScore(27);
		
		//DefenseTeam
		
		Team defenseCounter = hubBoard.registerNewTeam(teams.get(0));
		defenseCounter.setColor(ChatColor.BLUE);
		defenseCounter.setDisplayName("Defense");
		
		Score blue = obj.getScore(ChatColor.BLUE + "" + defenseCounter.getSize() + "/" + maxTeamPlayers + ChatColor.AQUA + " Players on Defense:");
		blue.setScore(26);
		
		int x = 25;
		if (defenseCounter.getSize() != 0) {	
			for (String i : defenseCounter.getEntries()) {
				Score team = obj.getScore(ChatColor.BLUE + "" + i);
				team.setScore(x);
				x--;
			}
		}

		Score detail3 = obj.getScore(ChatColor.WHITE + "-----------------------");
		detail3.setScore(15);
		
		//OffenseTeam
		Team offenseCounter = hubBoard.registerNewTeam(teams.get(1));
		offenseCounter.setColor(ChatColor.DARK_RED);
		offenseCounter.setDisplayName("Offense");
		
		Score red = obj.getScore(ChatColor.DARK_RED + "" + offenseCounter.getSize() + "/" + maxTeamPlayers + ChatColor.RED + " Players on Offense:");
		red.setScore(14);

		x = 13;
		if (offenseCounter.getSize() != 0) {
			for (String i : offenseCounter.getEntries()) {
				Score team = obj.getScore(ChatColor.DARK_RED + "" + i);
				team.setScore(x);
				x--;
			}
		}
		
		player.setScoreboard(hubBoard);
	}

	
	
	
	
	public void addToTeam(String teamName, Player player) {
		
		int blueSize = hubBoard.getTeam(teams.get(0)).getSize();
		int redSize = hubBoard.getTeam(teams.get(1)).getSize();
		
		for (String i : teams) {
			if (hubBoard.getTeam(i).hasEntry(player.getDisplayName()) && i.equals(teamName)) {
				return;
			} else if (hubBoard.getTeam(i).hasEntry(player.getDisplayName()) && !i.equalsIgnoreCase(teamName)) {
				hubBoard.resetScores(hubBoard.getTeam(i).getColor() + "" + player.getDisplayName());
				hubBoard.getTeam(i).removeEntry(player.getDisplayName());
			}
		}
		
		hubBoard.getTeam(teamName).addEntry(player.getName());
		
		int x = 26;
		
		hubBoard.resetScores(ChatColor.BLUE + "" + blueSize + "/" + maxTeamPlayers + ChatColor.AQUA + " Players on Defense:");
		obj.getScore(ChatColor.BLUE + "" + hubBoard.getTeam("defense").getSize() + "/" + maxTeamPlayers + ChatColor.AQUA + " Players on Defense:").setScore(x);;
		x--;
		
		for (String i : hubBoard.getTeam("defense").getEntries()) {
			if (hubBoard.getEntries().contains(i) && hubBoard.getTeam("defense").hasEntry(i)) {
				obj.getScore(i).setScore(x);
				x--;
			} else {
				Score newMember = obj.getScore(ChatColor.BLUE + "" + i);
				newMember.setScore(x);
				x--;
			}
		}
	
		x = 14;
			
		hubBoard.resetScores(ChatColor.DARK_RED + "" + redSize + "/" + maxTeamPlayers + ChatColor.RED + " Players on Offense:");
		obj.getScore(ChatColor.DARK_RED + "" + hubBoard.getTeam("offense").getSize() + "/" + maxTeamPlayers + ChatColor.RED + " Players on Offense:").setScore(x);;
		x--;
		
		for (String i : hubBoard.getTeam("offense").getEntries()) {
			if (hubBoard.getEntries().contains(i) && hubBoard.getTeam("offense").hasEntry(i)) {
				obj.getScore(i).setScore(x);
				x--;
			} else {
				Score newMember = obj.getScore(ChatColor.DARK_RED + "" + i);
				newMember.setScore(x);
				x--;
			}
		}
		
		for (Player online : Bukkit.getOnlinePlayers()) {
			online.setScoreboard(hubBoard);
		}
		
		ChatColor color = hubBoard.getTeam(teamName).getColor();
		player.sendMessage(color + "You have joined " + hubBoard.getTeam(teamName).getDisplayName() + "!");
		
	}
	
	
	
	
	
	public void chooseClass (List<String> classes, String className, Player player) {
		
		for (String i : classes) {
			if (hubBoard.getTeam(i).hasEntry(player.getDisplayName()) && i.equalsIgnoreCase(className)) {
				return;
			} else if (hubBoard.getTeam(i).hasEntry(player.getDisplayName()) && !i.equalsIgnoreCase(className)) {
				for (String a : teams) {
					if (hubBoard.getTeam(a).hasEntry(player.getDisplayName())) {
						hubBoard.resetScores(hubBoard.getTeam(a).getColor() + "" + player.getDisplayName());
						hubBoard.getTeam(i).removeEntry(player.getDisplayName()); 
					}	
				}
			}
		}
		
		hubBoard.getTeam(className).addEntry(player.getDisplayName());
		
		int blueSize = hubBoard.getTeam(teams.get(0)).getSize();
		int redSize = hubBoard.getTeam(teams.get(1)).getSize();
		
		int x = 26;
		
		hubBoard.resetScores(ChatColor.BLUE + "" + blueSize + "/" + maxTeamPlayers + ChatColor.AQUA + " Players on Defense:");
		obj.getScore(ChatColor.BLUE + "" + hubBoard.getTeam("defense").getSize() + "/" + maxTeamPlayers + ChatColor.AQUA + " Players on Defense:").setScore(x);;
		x--;
		
		for (String i : hubBoard.getTeam("defense").getEntries()) {
			if (hubBoard.getEntries().contains(i) && hubBoard.getTeam("defense").hasEntry(i)) {
				obj.getScore(i).setScore(x);
				x--;
			} else {
				Score newMember = obj.getScore(ChatColor.BLUE + "" + i);
				newMember.setScore(x);
				x--;
			}
		}
	
		x = 14;
			
		hubBoard.resetScores(ChatColor.DARK_RED + "" + redSize + "/" + maxTeamPlayers + ChatColor.RED + " Players on Offense:");
		obj.getScore(ChatColor.DARK_RED + "" + hubBoard.getTeam("offense").getSize() + "/" + maxTeamPlayers + ChatColor.RED + " Players on Offense:").setScore(x);;
		x--;
		
		for (String i : hubBoard.getTeam("offense").getEntries()) {
			if (hubBoard.getEntries().contains(i) && hubBoard.getTeam("offense").hasEntry(i)) {
				obj.getScore(i).setScore(x);
				x--;
			} else {
				Score newMember = obj.getScore(ChatColor.DARK_RED + "" + i);
				newMember.setScore(x);
				x--;
			}
		}
		
		for (Player online : Bukkit.getOnlinePlayers()) {
			online.setScoreboard(hubBoard);
		}
		
		player.sendMessage(ChatColor.LIGHT_PURPLE + "You have chosen the " + hubBoard.getTeam(className).getDisplayName() + " class!");
		
	}
	
}
