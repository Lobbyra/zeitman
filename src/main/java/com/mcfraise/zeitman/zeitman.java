package com.mcfraise.zeitman;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class zeitman extends JavaPlugin {
	@Override
	public void onEnable()
	{
		int cycle_lenght = 45; // In minutes
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm"); // Assign hour format
		BukkitScheduler scheduler = getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run () {
				LocalDateTime now = LocalDateTime.now();
				String msg = ChatColor.DARK_GREEN + "Zeitman" + ChatColor.WHITE + " : It's " + dtf.format(now);
				Bukkit.broadcastMessage(msg);
			}
		}, 0L, (cycle_lenght * (60 * 20L)));
	}

	@Override
	public void onDisable() {
		getLogger().info("onDisable done !");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("zeit")) {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
			String msg = ChatColor.DARK_GREEN + "Zeitman" + ChatColor.WHITE + " : Il est " + dtf.format(now);
			Bukkit.broadcastMessage(msg);
			return true;
		}
		return false;
	}
}
