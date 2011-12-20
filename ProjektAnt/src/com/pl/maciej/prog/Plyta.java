package com.pl.maciej.prog;


public class Plyta {
	
	private String wykonawca;
	private String tytul;
	private PlytaGatunek gatunek;
	private int rok;
	
	
	
	public Plyta(String par_wykonawca, String par_tytul, PlytaGatunek par_gatunek, int par_rok)
	{
		wykonawca = par_wykonawca;
		tytul = par_tytul;
		gatunek = par_gatunek;
		rok = par_rok;
	}
	
	void wyswietlPlyte() {
		System.out.println("Wykonawca: " + wykonawca + "\nTytul: " + tytul + "\nGatunek: " + gatunek + "\nRok: " + rok);
	}
	
	public	String	tytul() {
		return	tytul;
	}
	
	public	String	wykonawca() {
		return	wykonawca;
	}
	
	public	PlytaGatunek	gatunek() {
		return	gatunek;
	}
	
	public	int		rok() {
		return	rok;
	}
	
	public	String	plyta() {
		return	"Wykonawca-" + wykonawca + " Tytu³-" + tytul + " Gtunek-" + gatunek + " Rok wydania-" + rok;
	}
}
