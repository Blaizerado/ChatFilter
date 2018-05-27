package de.ilovejava.utils;

import org.bukkit.entity.Player;

import de.ilovejave.main.ChatFilter;

public class Utils_Remove extends Thread{
	String word;
	Player p;
	public Utils_Remove(String w, Player t) {
		word = w;
		p = t;
	}
	
	@Override
	public void run() {
		try {
			if(ChatFilter.DENY_WORDS.contains(word)) {
				ChatFilter.MY.update("DELETE FROM denywords WHERE text='"+word+"'");
				ChatFilter.DENY_WORDS.remove(word);
				p.sendMessage("§aDas Wort §e§l" + word + "§a wurde von der Datenbank gelöscht!");
			}else {p.sendMessage("§cAchtung, das Wort wurde nicht in der Datenbank gefunden!"); Thread.sleep(100); return;}
		}catch(Exception e) {}
	}
}
