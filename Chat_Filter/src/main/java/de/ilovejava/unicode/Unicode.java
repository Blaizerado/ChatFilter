package de.ilovejava.unicode;

import java.util.Random;

public class Unicode {
	public static char getCode() {	
		char[] c = {'\u2764','\u2714','\u2716',
					'\u2717','\u272d','\u2722',
					'\u27a4','\u2704','\u2736',
					'\u2737','\u2738','\u2749',
					'\u2739','\u273a','\u273b',
					'\u273c','\u2744','\u2745',
					'\u2687','\u267f','\u2669',
					'\u266a','\u266b','\u266c',
					'\u266d','\u266e','\u266f',
					'\u2660','\u2661','\u2657',
					'\u2662','\u2663','\u2664',
					'\u2665','\u2666','\u2667',
					'\u2654','\u2655','\u2656',
					'\u2657','\u2658','\u2659',
					'\u265a','\u265b','\u265c',
					'\u265d','\u265e','\u265f',
					'\u26aa'};
		return c[new Random().nextInt(c.length)];
	}
}
