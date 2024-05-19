package org.milestone.java.gestoreEventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
//		MAIN
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Evento nuovoEvento;

		int menu;
		menu = ui();
		while(menu != 0) {
			switch(menu) {
//		1. CREA UN NUOVO EVENTO
			case 1:
		//titolo
				System.out.println("Titolo evento: ");
				String titoloEvento = scanner.nextLine();
		
		//data
				LocalDate dataEvento = inputData();
		
		//validaz data
				while(dataEvento.compareTo(LocalDate.now())<0) {
					System.out.println("Per cortesia, inserire un giorno futuro.");
					dataEvento = inputData();
				}
		
		//nPostiMax
				System.out.println("Numero posti totale (inserisci un numero): ");
				int postiTotali = scanner.nextInt();
				scanner.nextLine();
		
		//validaz posti max
				while(postiTotali<=0) {
					System.out.println("Devi inserire un numero di posti totali positivo. Riprova.");
					postiTotali = scanner.nextInt();
					scanner.nextLine();
				}
		//Concerto?
				System.out.println("E' un concerto? "
						+ "\nY. Si"
						+ "\nN. No");
				String isConcerto = scanner.nextLine();
		//validaz input
				while(!"Y".equals(isConcerto) && !"N".equals(isConcerto)) {
					System.out.println("Valore non valido.");
					System.out.println("Vuoi prenotare dei posti? "
							+ "\nY. Si"
							+ "\nN. No");
					isConcerto = scanner.nextLine();
				}
				if(isConcerto.equals("Y")) { 
					//orario concerto		
				System.out.println("Orario concerto\nInserisci l'ora (hh): ");
				int oraConc = scanner.nextInt();
				scanner.nextLine();
		//validaz ora
				while(oraConc>24) {
					System.out.println("Valore non valido. Inserisci un valore minore di 24");
					oraConc = scanner.nextInt();
					scanner.nextLine();
				}
				System.out.println("Inserisci i minuti (mm): ");
				int minConc = scanner.nextInt();
				scanner.nextLine();
		//validaz minuti
				while(minConc > 60) {
					System.out.println("Valore non valido. Inserisci un valore minore di 60");
					minConc = scanner.nextInt();
					scanner.nextLine();
				}
				LocalTime orarioConc = LocalTime.of(oraConc, minConc);
		//prezzo		
				System.out.println("Prezzo concerto: ");
				double prezzoConc = scanner.nextDouble();
				scanner.nextLine();
		//costruz concerto		
				nuovoEvento = new Concerto(titoloEvento, dataEvento, postiTotali, orarioConc, prezzoConc);
				
				} else {
					
		//Costruzione evento !concerto	
				nuovoEvento = new Evento(titoloEvento, dataEvento, postiTotali);
				}
				
		//prenotaz posti
				System.out.println("Vuoi prenotare dei posti? "
						+ "\nY. Si"
						+ "\nN. No");
				String prenotaz = scanner.nextLine();

		//validazione input prenotaz		
				while(!"Y".equals(prenotaz) && !"N".equals(prenotaz)) {
					System.out.println("Valore non valido.");
					System.out.println("Vuoi prenotare dei posti? "
							+ "\nY. Si"
							+ "\nN. No");
					prenotaz = scanner.nextLine();
				}
		//prenotazione		
				if(prenotaz.equals("Y")) {
					System.out.println("Quanti posti vuoi prenotare? (Inserisci un numero) ");
					int postiDaPrenot = scanner.nextInt();
					scanner.nextLine();
					while(postiDaPrenot > nuovoEvento.getnPostiMax() || postiDaPrenot < 0) {
							System.out.println("Valore non valido.\nIl numero massimo di posti prenotabili e' "
									+ nuovoEvento.getnPostiMax() + ".\nInserisci un altro numero.");
							postiDaPrenot = scanner.nextInt();
							scanner.nextLine();
					}
					nuovoEvento.setnPostiPrenotati(postiDaPrenot);
				}
				System.out.println("Posti prenotati: " + nuovoEvento.getnPostiPrenotati()
						+ "\nPosti ancora disponibili: " + (nuovoEvento.getnPostiMax() - nuovoEvento.getnPostiPrenotati()));
			if(nuovoEvento.getnPostiPrenotati() != 0) {
				System.out.println("Vuoi disdire delle prenotazioni? "
						+ "\nY. Si"
						+ "\nN. No");
				String disdetta = scanner.nextLine();
				
		//validazione input disdetta		
				while(!"Y".equals(disdetta) && !"N".equals(disdetta)) {
					System.out.println("Valore non valido.");
					System.out.println("Vuoi disdire delle prenotazioni? "
							+ "\nY. Si"
							+ "\nN. No");
					disdetta = scanner.nextLine();
				}
		//disdetta posti
				if(disdetta.equals("Y")) {
					System.out.println("Quanti posti vuoi disdire? (Inserisci un numero) ");
					int postiDaDisdire = scanner.nextInt();
					scanner.nextLine();
					while(postiDaDisdire > nuovoEvento.getnPostiPrenotati() || postiDaDisdire < 0){
						System.out.println("Valore non valido." + "\nPosti prenotati: "
					+ nuovoEvento.getnPostiPrenotati() + "\nPosti totali: " + nuovoEvento.getnPostiMax() + "\nInserisci un altro numero:");
						postiDaDisdire = scanner.nextInt();
						scanner.nextLine();
					}
					nuovoEvento.setnPostiPrenotati(nuovoEvento.getnPostiPrenotati() - postiDaDisdire);
				}
				System.out.println("Posti prenotati: " + nuovoEvento.getnPostiPrenotati()
				+ "\nPosti ancora disponibili: " + (nuovoEvento.getnPostiMax() + nuovoEvento.getnPostiPrenotati()));
			}
			
			System.out.println("=====\n" + nuovoEvento.toString());
				
			default: 
				System.out.println("=====\nfine codice");
				System.out.println("Valore non valido.");
				menu = ui();
			}
		}
		System.out.println("Arrivederci!");
	}
//		/MAIN

//		USER INTERFACE/MENU
	public static int ui() {
		Scanner scanner = new Scanner(System.in);
		//inizializzo una variabile di transito anziche' utilizzare lo scanner come return per necessita' di inserire
		//uno scanner nextLine per il problema dell'invio sullo scanner nextInt
		int menu;
		System.out.println("\nChe cosa vuoi fare?"
				+ "\n1. Crea nuovo evento"
				+ "\n0. Esci");
		menu = scanner.nextInt();
		scanner.nextLine();
		return menu;
	}
	
//		INPUT DATA
	public static LocalDate inputData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Anno evento: ");
		int anno = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Mese evento (in numero): ");
		int mese = scanner.nextInt();
		scanner.nextLine();
		while(mese>12) {
			System.out.println("Mese non valido, riprova.");
			mese = scanner.nextInt();
			scanner.nextLine();
		}
		System.out.println("Giorno evento: ");
		int giorno = scanner.nextInt();
		scanner.nextLine();
		 if(mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8 || mese == 10 || mese == 12) {
			 while(giorno>31) {
				 System.out.println("Giorno inesistente, riprova.");
				 giorno = scanner.nextInt();
				 scanner.nextLine();
			 }
		 } else if(mese == 2 &&  anno%4==0) {
			 while(giorno>29) {
			 System.out.println("Giorno inesistente, riprova.");
			 giorno = scanner.nextInt();
			 scanner.nextLine();
		 }
		 } else if (mese == 2 && anno%4!=0){
			 while(giorno>28) {
				 System.out.println("Giorno inesistente, riprova.");
				 giorno = scanner.nextInt();
				 scanner.nextLine();
			 }
		 }else {
			 while(giorno>30) {
				 System.out.println("Giorno inesistente, riprova.");
				 giorno = scanner.nextInt();
				 scanner.nextLine();
			 }
		 }
		return LocalDate.of(anno, mese, giorno);
	}
//		/ INPUT DATA
}

