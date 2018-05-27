package de.ilovejava.words;

import java.sql.ResultSet;

import de.ilovejave.chatfilter.ChatFilter;

public class LoadWords extends Thread{
	public LoadWords() {}
	
	@Override
	public void run() {
		try {
			ResultSet rs = ChatFilter.MY.query("SELECT * FROM denywords");
			while (rs.next()) {
				if(!ChatFilter.DENY_WORDS.contains(rs.getString("text"))) {
					ChatFilter.DENY_WORDS.add(rs.getString("text"));
				}
			}
			ChatFilter.sendConsol("§cEs wurden " + ChatFilter.DENY_WORDS.size() + " Wort/Wörter geladen");
		}catch(Exception e) {e.printStackTrace();}
	}
	
}
