package com.pl.maciej.prog;


public class Osoba {
	
	private String imie;
	private	String nazwisko;
	private	KolekcjaPlyt plyty = new KolekcjaPlyt();
	
	public Osoba(String par_imie, String par_nazwisko, KolekcjaPlyt par_plyty) {
		imie 		= par_imie;
		nazwisko 	= par_nazwisko;
		if ( par_plyty != null )
			plyty 	= par_plyty;
	}
	
	public void dodajPlyte(String pWykonawca, String pTytul, PlytaGatunek pGatunek, int pRok) {
		plyty.dodajPlyte(pWykonawca, pTytul, pGatunek, pRok);
	}
	
	public void usunPlyte( int pNumerPlyty ) {
		plyty.usunPlyte( pNumerPlyty );
	}
	
	public void usunPlyte( String pWykonawca, String pTytul, PlytaGatunek pGatunek, int pRok ) {
		plyty.usunPlyte(pWykonawca, pTytul, pGatunek, pRok );
	}
	
	public int wyszukajPlyte( String pWykonawca, String pTytul, PlytaGatunek pGatunek, int pRok ) {
		return plyty.wyszukajPlyte( pWykonawca, pTytul, pGatunek, pRok );
	}
	
	public void edytujPlyte( int pNumerPlyty, String nowyWyk, String nowyTyt, PlytaGatunek nowyGat, int nowyRok ) {
		plyty.edytujPlyte( pNumerPlyty, nowyWyk, nowyTyt, nowyGat, nowyRok );
	}
	
	public void edytujPlyte( String pWykonawca, String pTytul, PlytaGatunek pGatunek, int pRok,
			 String nowyWyk, String nowyTyt, PlytaGatunek nowyGat, int nowyRok ) {
		plyty.edytujPlyte( pWykonawca, pTytul, pGatunek, pRok, nowyWyk, nowyTyt, nowyGat, nowyRok );
	}
	
	public void wyswietlPlyty()
	{
		System.out.println("\nPLYTY W POSIADANIU OSOBY: " + imie + " " + nazwisko);
		Plyta robPlyty;
		for (int i = 0; i< plyty.liczbaPlyt(); i++ ) {
			robPlyty = plyty.dajPlyte(i);
			robPlyty.wyswietlPlyte();
		}
	}

	public void ustawImie( String nImie ) {
		imie = nImie;
	}
	
	public void ustawNazwisko( String nNazwisko ) {
		imie = nNazwisko;
	}
	
	public String dajImie() {
		return imie;
	}
	
	public String dajNazwisko() {
		return nazwisko;
	}
	
	public int	liczbaPlyt() {
		return	plyty.liczbaPlyt();
	}
	
}
