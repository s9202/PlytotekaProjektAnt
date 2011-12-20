package com.pl.maciej.prog;


public class MojWyjatek extends Exception {

	private static final long serialVersionUID = 1L;

	private String kom;
	
	public MojWyjatek (String komunikat) {
		super(komunikat);
		kom = komunikat;
	}
	
	public String toString() {
		return kom;
	}

}
