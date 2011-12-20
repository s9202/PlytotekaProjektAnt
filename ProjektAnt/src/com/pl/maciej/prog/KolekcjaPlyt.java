package com.pl.maciej.prog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class KolekcjaPlyt {

	List<Plyta> plyty 				= new ArrayList<Plyta>();
	private static Logger logger	= Logger.getLogger(KolekcjaPlyt.class);

	
	void	addToList( Plyta pPlyta ) throws MojWyjatek {
		
		PropertyConfigurator.configure("Log4J.properties");
		Calendar kalendarz = Calendar.getInstance(); 		// ustalanie bie¿¹cego roku wewn¹trz metody dodawania p³yty
		int rokBiezacy = kalendarz.get( Calendar.YEAR ); 	// umo¿liwia poprawn¹ reakcjê na wejœcie w nowy rok (z 31.12 na 01.01) 
		
		if ( plyty == null )
			throw new MojWyjatek("Lista jest niezainicjowana");
		if ( pPlyta.rok() > rokBiezacy)
			throw new MojWyjatek("BLAD: Podany rok jest pozniejszy niz obecny. Wpis bledny: "
					+ pPlyta.wykonawca() + " | " + pPlyta.tytul() + " | " + pPlyta.gatunek() + " | " + pPlyta.rok() );
		if ( pPlyta.rok() < 1885)
			throw new MojWyjatek("Pierwsze plyty nagrano w 1885, podano zbyt wczesny rok. Wpis bledny: "
					+ pPlyta.wykonawca() + " | " + pPlyta.tytul() + " | " + pPlyta.gatunek() + " | " + pPlyta.rok() );
		
		int 	pozycja 	= wyszukajPlyte( pPlyta.tytul(), pPlyta.wykonawca(), pPlyta.gatunek(), pPlyta.rok() );

		if (pozycja >= 0) 
			throw new MojWyjatek("Taka p³yta ju¿ istnieje na liscie. Wpis bledny: "
					+ pPlyta.wykonawca() + " | " + pPlyta.tytul() + " | " + pPlyta.gatunek() + " | " + pPlyta.rok() );
		
		plyty.add( pPlyta );
		logger.info( "Dodano p³ytê do kolekcji: Wykonawca-" + pPlyta.plyta() );
	}
	
	
	
	
	public void	dodajPlyte( String pWykonawca, String pTytul, PlytaGatunek pGatunek, int pRok ) {
		PropertyConfigurator.configure("Log4J.properties");
		try {
			addToList( new Plyta( pWykonawca, pTytul, pGatunek, pRok ) );
		}
		catch (MojWyjatek e) {
			logger.error(e);
			logger.fatal(e);
			logger.info(e);
			logger.warn(e);
			//System.out.println( e );
		}
	}
	
	/*-----------------------------------------------------------------------------------
	 * "wyszukajPlyte" przeszukuje kolekcjê zawart¹ w polu "plyty" w celu znalezienia takiej,  
	 * której pola: "wykonawca", "tytul", "gatunek", rok" bêd¹ mia³y takie same wartoœci,
	 * jak odpowiadaj¹ce im parametry wywo³ania metody: "pWykonawca", "pTytul", "pGatunek", 
	 * "pRok".
	 * 
	 * Metoda zwraca:
	 * pozycjê (indeks) znalezionego obiektu albo
	 * -1, gdy obiekt nie zostanie znaleziony.
	 * ----------------------------------------------------------------------------------
	 */
	public int wyszukajPlyte( String pWykonawca, String pTytul, PlytaGatunek pGatunek, int pRok ) {
		
		int 	pozycja = plyty.size()-1;
		boolean	jest	= false;
		
		while (!jest && pozycja >= 0 ) {
			if( plyty.get(pozycja).tytul().equals(pTytul ) && plyty.get(pozycja).wykonawca().equals( pWykonawca ) && plyty.get(pozycja).gatunek().equals( pGatunek ) && ( plyty.get(pozycja).rok() == pRok ) )
				jest = true;
			else
				pozycja--;
		}
		
		return pozycja;
	}
	
	
	public void edytujPlyte( String pWykonawca, String pTytul, PlytaGatunek pGatunek, int pRok,
							 String nowyWyk, String nowyTyt, PlytaGatunek nowyGat, int nowyRok ) {
		
		int nrPlyty = wyszukajPlyte( pWykonawca, pTytul, pGatunek, pRok );
		edytujPlyte( nrPlyty, nowyWyk, nowyTyt, nowyGat, nowyRok );
	}

	
	public void edytujPlyte( int pNumerPlyty, String nowyWyk, String nowyTyt, PlytaGatunek nowyGat, int nowyRok ) {
		
		Plyta plyta = new Plyta( nowyWyk, nowyTyt, nowyGat, nowyRok );
		plyty.set( pNumerPlyty , plyta );
	}
	
	
	public void usunPlyte( String pWykonawca, String pTytul, PlytaGatunek pGatunek, int pRok ) {
		
		int nrPlyty = wyszukajPlyte( pWykonawca, pTytul, pGatunek, pRok );
		usunPlyte( nrPlyty );
	}
	
	
	public void usunPlyte( int pNumerPlyty ) {
		plyty.remove( pNumerPlyty );
	}
	

	public int liczbaPlyt() {
		return plyty.size();
	}


	public Plyta dajPlyte(int nrPlyty) {
		return plyty.get(nrPlyty);
	}
	
	
}
