package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		
		//creo il libretto
		Libretto lib= new Libretto();
		
		//metto dei voti a piacere
		lib.add(new Voto("Analisi 1", 29, LocalDate.of(2021, 02, 15)));
		lib.add(new Voto("Fisica 2", 26, LocalDate.of(2022, 06, 10)));
		lib.add(new Voto("Fisica 1", 25, LocalDate.of(2021, 07, 8)));
		

		lib.StampaPuntiUguali(25);
		
		Voto v= lib.CercaVotoPerNome("Analisi 2");
		System.out.println(v);
		
		Voto albis= new Voto("Analisi 1", 29, LocalDate.of(2025,10,3));
		Voto alter= new Voto("Analisi 1", 30, LocalDate.of(2025,10,3));
		
		System.out.println(albis +" è duplicato "+ lib.esisteVotoDuplicato(albis));
		System.out.println(alter +" è duplicato "+ lib.esisteVotoDuplicato(alter));
		
		try {
			lib.add(new Voto("Informatica", 25, LocalDate.of(2023, 7, 10)));
		}catch(IllegalArgumentException e) {
			System.out.println("Errore nell'inserimento voto.");
			System.out.println(e.getMessage());
			
		}
		
		Libretto migliore= lib.librettoMigliorato();
		System.out.println("Libretto migliorato");
		migliore.Stampa();
		
		
		
	}
	

}
