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
		if(this.esisteVotoDuplicato(v) || this.esisteVotoConflitto(v)) {
			//non aggiungere voto
			//posso farlo lanciando un eccezione
			throw new IllegalArgumentException("Voto errato: "+v);
			//o ritorno false
		}
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
	//stampa i voti pari al valore passato come parametro
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
	
	public boolean esisteVotoDuplicato(Voto nuovo) {
/*		for(Voto v: voti ) {
		//	if(v.equalsCorsoPunti(nuovo))
				//creo un metodo equalsCorsoPunti, conviene quando scrivo la stessa condizione anche in un altro punto del codice
			//oppure
			if(v.getCorso().equals(nuovo.getCorso()) && v.getPunti()== nuovo.getPunti())
				return true;
			}
		return false;  */
		
		//oppure
		for(Voto v: this.voti) {
			if(v.isDuplicato(nuovo))
				return true;
		}
		return false;
	}
	
	public boolean esisteVotoConflitto(Voto nuovo) {
	/*	for(Voto v: this.voti ) {
			if(v.getCorso().equals(nuovo.getCorso()) && v.getPunti() != nuovo.getPunti())
				return true;
		}
		return false;  */
		
		//oppure
		for(Voto v: this.voti) {
			if(v.isConflitto(nuovo))
				return true;
		}
		return false;
	}
	
	/**
	 * Metodo 'factory' per creare un nuovo libretto
	 * con i voti migliorati.
	 * 
	 * @return
	 */
	
	public Libretto librettoMigliorato() {
		Libretto migliore= new Libretto();
		migliore.voti= new ArrayList<>();
		for(Voto v: this.voti) {
			migliore.voti.add(v.clone());
		}
		for(Voto v: migliore.voti) {
			v.setPunti(v.getPunti()+2);
		}
		return migliore;
	}
	
	public void cancellaVotiInferiori(int punti) {
		List<Voto> daCancellare= new ArrayList<Voto>();
		for(Voto v: this.voti) { //non modifico la lista voti
			if(v.getPunti()<punti) {
				daCancellare.add(v);
			}
		}
		
		for(Voto vl: daCancellare) {
			this.voti.remove(vl);
		}
		//il for precedente posso sostituirlo con
		//this.voti.removeAll(daCancellare);
		//e sarebbe meglio
	}
	
	//ordine alfabetico e descrescente per voto
	public class ComparatoreAlfEVoto implements Comparator<Voto>{
		public int compare(Voto v1, Voto v2) {
			if(v1.getCorso().compareTo(v2.getCorso())==0)
				return - (v1.getPunti()-v2.getPunti());
			return v1.getCorso().compareTo(v2.getCorso());
		}
	}
	
	//lavora  in maniera simile al metodo libretto migliorato
	public Libretto librettoOrdinatoAlfabeticamente() {
		Libretto ordinato= new Libretto();
		ordinato.voti= new ArrayList<>(this.voti);
		Collections.sort(ordinato.voti, new ComparatoreAlfEVoto()); // posso anche scriverlo come ordinato.voti.sort(new NomeComparatore());
		return ordinato;
	}
	
	public Libretto librettoOrdinatoPerVoto() {
		Libretto ordinato= new Libretto();
		ordinato.voti= new ArrayList<>(this.voti);
		ordinato.voti.sort(new Comparator<Voto>() { //() del costruttore della classe anonima
		//{} specifica i metodi che uso, la classe la implemento qui dentro
			public int compare(Voto o1, Voto o2) {
				return o2.getPunti()-o1.getPunti();
			}
		} );
		
		return ordinato;
	}
	
}

