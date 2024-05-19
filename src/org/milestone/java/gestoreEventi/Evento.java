package org.milestone.java.gestoreEventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	protected String titolo;
	protected LocalDate data;
	private int nPostiMax;
	private int nPostiPrenotati;
	
	public Evento(String titolo, LocalDate data, int nPostiMax) {
		this.titolo = titolo;
		this.data = data;
		this.nPostiMax = nPostiMax;
		nPostiPrenotati = 0;
		}

//		METODI
	public void prenota() {
		if(data.isBefore(LocalDate.now())){
			System.out.println("Mi spiace, l'evento è  gia passato.");
		} else if(nPostiMax == nPostiPrenotati) {
			System.out.println("Mi spiace, non ci sono posti liberi.");
		} else nPostiPrenotati++;
		System.out.println("Il tuo posto è stato prenotato con successo per l'evento " + this.toString());
	}
	
	public void disdici() {
		if(data.isBefore(LocalDate.now())){
			System.out.println("Mi spiace, l'evento è  gia passato.");
		} else if(nPostiPrenotati == 0) {
			System.out.println("Mi spiace, non ci sono posti gia' prenotati da disdire.");
		} else  nPostiPrenotati--;
		System.out.println("Il tuo posto è stato disdetto con successo per l'evento " + this.toString());
	}

	@Override
	public String toString() {
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " " + titolo;
	}

//		GETTER E SETTER
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getnPostiMax() {
		return nPostiMax;
	}

	public int getnPostiPrenotati() {
		return nPostiPrenotati;
	}

	public void setnPostiPrenotati(int nPostiPrenotati) {
		this.nPostiPrenotati = nPostiPrenotati;
	}
//		/GETTER E SETTER
}