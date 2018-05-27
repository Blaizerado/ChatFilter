package de.ilovejava.stringuitl;

public class UpperCase {
	
	
	public static boolean isToBig(String text) {
		Integer i = text.length() / 2;
		if(getStringChance(text) > i) {
			return true;
		}
		return false;
	}
	
	public static Integer getStringChance(String text) {
		Integer words = 0;
		char[] tt = text.toCharArray();
		for(int i = 0; i<tt.length; i++) {
			if(Character.isUpperCase(tt[i])) {
				words ++;
			}
		}
		return words;
	}
}
