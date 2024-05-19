package org.milestone.java.gestoreEventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
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
//		MAIN
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int menu;
		menu = ui();
		while(menu != 0) {
			switch(menu) {
//		1. CREA UN NUOVO EVENTO
			case 1:
				System.out.println("Titolo evento: ");
				String titoloEvento = scanner.nextLine();
				LocalDate dataEvento = inputData();
				System.out.println("Numero posti totale (inserisci un numero): ");
				int postiTotali = scanner.nextInt();
				scanner.nextLine();
				
				Evento nuovoEvento = new Evento(titoloEvento, dataEvento, postiTotali);
				System.out.println("Vuoi prenotare dei posti? "
						+ "\nY. Si"
						+ "\nN. No");
				String prenotaz = scanner.nextLine();
				
				while(!"Y".equals(prenotaz) || !"N".equals(prenotaz)) {
					System.out.println("Valore non valido.");
					System.out.println("Vuoi prenotare dei posti? "
							+ "\nY. Si"
							+ "\nN. No");
					prenotaz = scanner.nextLine();
				}//menu prenotaz
				
				if(prenotaz.equals("Y")) {
					System.out.println("Quanti posti vuoi prenotare? (Inserisci un numero) ");
					int postiDaPrenot = scanner.nextInt();
					scanner.nextLine();
					while(postiDaPrenot <= nuovoEvento.getnPostiMax()) {
						if(postiDaPrenot > nuovoEvento.getnPostiMax()) {
							System.out.println("Il numero massimo di posti prenotabili e' "
									+ nuovoEvento.getnPostiMax() + ".\nInserisci un altro numero.");
							postiDaPrenot = scanner.nextInt();
							scanner.nextLine();
						}//if
					}//while
				}//prenotaz Y
				
			}
		}
	}
//		/MAIN

	
//		VALIDAZIONE DATA
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
		LocalDate data = LocalDate.of(anno, mese, giorno);
		return data;
	}
}

