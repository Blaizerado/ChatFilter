package de.ilovejava.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.ilovejava.stringuitl.Ip_Util;
import de.ilovejava.stringuitl.UpperCase;
import de.ilovejava.unicode.Unicode;
import de.ilovejave.main.ChatFilter;

public class ChatEvent implements Listener {
	@EventHandler
	public void Chat(AsyncPlayerChatEvent e) {
		String[] words = e.getMessage().split(" ");
		String StringFormat = "";
		for(String w : words) {
			if(!ChatFilter.DENY_WORDS.contains(w.toLowerCase())) {
				StringFormat = StringFormat + " " + w;
			}else {if(!e.getPlayer().hasPermission("Chat.team")) {StringFormat = StringFormat + " §c" + Unicode.getCode() +"§f";}}
		}
		if(!UpperCase.isToBig(StringFormat)) {
			if(!Ip_Util.getStringIP(StringFormat)) {
				System.out.println(Ip_Util.getStringIP(StringFormat));
				e.setMessage(StringFormat);
			}else {e.getPlayer().sendMessage("§cBitte entferne die IP aus deiner Nachricht!"); e.setCancelled(true);}
		}else {e.getPlayer().sendMessage("§cAchtung, bitte verwende kein Caps in deinen Nachrichten!"); e.setCancelled(true);}
	}
}
