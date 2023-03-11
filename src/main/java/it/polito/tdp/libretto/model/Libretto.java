package it.polito.tdp.libretto.model;
import java.util.*;

public class Libretto {

	private List<Voto> voti;

	//costruttore vuoto
	public Libretto() {
		//inizializzo gli attributi
		this.voti= new ArrayList<Voto>();
	}
	
	/**
	 * Aggiungi un nuovo voto al libretto
	 * (per ora nessun controllo)
	 * @param v il Voto da aggiungere
	 * @return true
	 */
	public boolean add(Voto v) {
		return this.voti.add(v);
	}
	
	//stampa
	public void Stampa() {
		for(Voto v: voti) {
			System.out.println(v);
		}
	}
	
	//stampa i voti PARI a 25
		public void Stampa25() {
			for(Voto v: voti) {
				if(v.getPunti()==25) //mettere delle costanti nel codice non è il massimo, quando queste potrebbero cambiare e non sono fisse
					System.out.println(v);
			}
		}
		
	//posso scriverlo così:
	//stampa i voti pari al valore passato
	public void StampaPuntiUguali(int valore) {
		for(Voto v: voti) {
			if(v.getPunti()==valore)
				System.out.println(v);
		}
	}
		
	//cerca il voto del corso passato come parametro
	public Voto CercaVotoPerNome(String corso) {
		for(Voto v: voti) {
			if(v.getCorso().compareTo(corso)==0)
			//posso usare anche if(v.getCorso().equals(corso)) A VOLTE SI PREFERISCE equals
				return v;
			}
		
		//o questo 
		return null;
		//o questo
		//throws new RuntimeException("Voto non trovato");
	}
	
	public boolean esisteVoto(Voto nuovo) {
		for(Voto v: voti ) {
		//	if(v.equalsCorsoPunti(nuovo))
				//creo un metodo equalsCorsoPunti, conviene quando scrivo la stessa condizione anche in un altro punto del codice
			//oppure
			if(v.getCorso().equals(nuovo.getCorso()) && v.getPunti()== nuovo.getPunti())
				return true;
			}
		return false;
	}
	}

