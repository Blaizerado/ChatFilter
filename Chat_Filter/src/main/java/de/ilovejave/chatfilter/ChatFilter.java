package de.ilovejave.chatfilter;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.lang.StringEscapeUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import de.ilovejava.command.Chat;
import de.ilovejava.events.ChatEvent;
import de.ilovejava.mysql.MySQL;
import de.ilovejava.words.LoadWords;

public class ChatFilter extends JavaPlugin{
	public static Integer PORT;
	public static String HOST;
	public static String DATABASE;
	public static String USER;
	public static String PASSWORD;
	public static MySQL MY;
	public static ArrayList<String>DENY_WORDS = new ArrayList<String>();
	@Override
	public void onEnable() {
		sendConsol("§cChatFilter wurde gestartet!");
		loadMyConfig(this);
		loadInstance(this);
		LoadMySQL();
	}

	@Override
	public void onDisable() {
		sendConsol("§cChatFilter wurde geschlossen!");
	}
	
	private void LoadMySQL() {
		if(!DATABASE.equalsIgnoreCase("default") || !USER.equalsIgnoreCase("default")) {
			MY = new MySQL(HOST, DATABASE, USER, PASSWORD,PORT);
			MY.update("CREATE TABLE IF NOT EXISTS DenyWords(text varchar(120));");
			LoadWords l = new LoadWords();
			l.start();
		}else {sendConsol("§cAchtung, es wurden keine MySQL Daten eingetragen!");}
	}
	
	private void loadMyConfig(ChatFilter chatFilter) {
		File f = new File("plugins/ChatFilter", "MySQL.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(f);
		if(!f.exists()) {
			cfg.set("Port", "3306");
			cfg.set("Host", "localhost");
			cfg.set("Database", "default");
			cfg.set("User", "default");
			cfg.set("Password", "default");
			sendConsol("§cAchtung, es wurden keinen MySQL Daten eingetragen!");
			try {cfg.save(f);}catch(Exception e){}
		}else {
			PORT = cfg.getInt("Port");
			HOST = cfg.getString("Host");
			DATABASE = cfg.getString("Database");
			USER = cfg.getString("User");
			PASSWORD = cfg.getString("Password");
		}
	}

	private void loadInstance(ChatFilter chatFilter) {
		new Chat("Chat",this);
		getServer().getPluginManager().registerEvents(new ChatEvent(), this);
	}
	
	public static void sendConsol(String msg) {
		Bukkit.getConsoleSender().sendMessage(msg);
	}
}
