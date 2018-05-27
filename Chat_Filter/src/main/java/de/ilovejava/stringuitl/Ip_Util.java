package de.ilovejava.stringuitl;

public class Ip_Util {
	public static Boolean getStringIP(String Text) {
		char[] c = Text.toCharArray();
		Integer ii = 0;
		for(int i = 0; i<c.length; i++) {
			if(String.valueOf(c[i]).equalsIgnoreCase(".") || String.valueOf(c[i]).equalsIgnoreCase("-") || String.valueOf(c[i]).equalsIgnoreCase("|") || 
			   String.valueOf(c[i]).equalsIgnoreCase(",") || String.valueOf(c[i]).equalsIgnoreCase("*") || String.valueOf(c[i]).equalsIgnoreCase("/")) {
				ii++;
			}
		}
		
		if(ii > 2) {
			return true;
		}
		return false;
	}
}
