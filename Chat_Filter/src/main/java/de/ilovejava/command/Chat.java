package de.ilovejava.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import de.ilovejava.stringuitl.UpperCase;
import de.ilovejava.utils.Utils_Add;
import de.ilovejava.utils.Utils_Remove;
import de.ilovejave.main.ChatFilter;

public class Chat extends AbstarctCommand{

	public Chat(String commandName, Plugin pl) {
		super(commandName, pl);
	}

	@Override
	public boolean command(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				if(p.hasPermission("Chat.info")) {
					p.sendMessage("§3/Chat words §8:§c§l Zeigt eine List mit den Wörtern der Datenbank an!");
					p.sendMessage("§3/Chat words add [Word] §8:§c§l Erstellt ein Wort in der Datenbank mit dem Name @Name!");
					p.sendMessage("§3/Chat words remove [Word] §8:§c§l Löscht ein Wort in der Datenbank mit dem Name @Name!");
				}else {p.sendMessage("§cAchtung, du hast leider kein Recht dazu!");}
			}else if(args.length == 1) {
				if(args[0].equalsIgnoreCase("words")) {
					if(p.hasPermission("Chat.words")) {
						if(ChatFilter.DENY_WORDS.size() != 0) {
							p.sendMessage("§eDiese Wörter sind eingetragen!");
							for(String s : ChatFilter.DENY_WORDS) {
								p.sendMessage("§3" + s);
							}
						}else {p.sendMessage("§cAchtung, es wurde keine Wörter eingetragen!");}
					}else {p.sendMessage("§cAchtung, du hast leider kein Recht dazu!");}
				}else {p.sendMessage("§cDieser Command ist uns leider nicht bekannt!");}
			}else if(args.length == 2) {
				if(args[0].equalsIgnoreCase("words")) {
					if(args[1].equalsIgnoreCase("add")) {
						if(p.hasPermission("Chat.add")) {
							p.sendMessage("§3/Chat words add [Word] §8:§c§l Erstellt ein Wort in der Datenbank mit dem Name @Name!");
						}else {p.sendMessage("§cAchtung, du hast leider kein Recht dazu!");}
					}else if(args[1].equalsIgnoreCase("remove")) {
						if(p.hasPermission("Chat.remove")) {
							p.sendMessage("§3/Chat words remove [Word] §8:§c§l Löscht ein Wort in der Datenbank mit dem Name @Name!");
						}else {p.sendMessage("§cAchtung, du hast leider kein Recht dazu!");}
					}
				}else {p.sendMessage("§cDieser Command ist uns leider nicht bekannt!");}
			}else if(args.length == 3) {
				if(args[0].equalsIgnoreCase("words")) {
					if(args[1].equalsIgnoreCase("add")) {
						if(p.hasPermission("Chat.add")) {
							Utils_Add u = new Utils_Add(args[2], p);
							u.start();
						}else {p.sendMessage("§cAchtung, du hast leider kein Recht dazu!");}
					}else if(args[1].equalsIgnoreCase("remove")) {
						if(p.hasPermission("Chat.remove")) {
							Utils_Remove u = new Utils_Remove(args[2], p);
							u.start();
						}else {p.sendMessage("§cAchtung, du hast leider kein Recht dazu!");}
					}
				}else {p.sendMessage("§cDieser Command ist uns leider nicht bekannt!");}
			}
		}
		return true;
	}
}
