package de.ilovejava.utils;

import org.bukkit.entity.Player;

import de.ilovejave.chatfilter.ChatFilter;

public class Utils_Add extends Thread{
	String word;
	Player p;
	public Utils_Add(String w, Player t) {
		word = w;
		p = t;
	}
	
	@Override
	public void run() {
		try {
			if(!ChatFilter.DENY_WORDS.contains(word)) {
				ChatFilter.MY.update("INSERT INTO denywords(text) VALUES('"+word+"')");
				ChatFilter.DENY_WORDS.add(word);
				p.sendMessage("§aDas Wort §e§l" + word + "§a wurde in die Datenbank gesetzt!");
			}else {p.sendMessage("§cAchtung, das Wort ist bereits in der Datenbank!"); Thread.sleep(100); return;}
		}catch(Exception e) {}
	}
}
