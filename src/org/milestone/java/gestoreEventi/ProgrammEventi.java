package org.milestone.java.gestoreEventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammEventi {
	private String titolo;
	private List<Evento> eventi;
	
	public ProgrammEventi(String titolo) {
		this.titolo = titolo;
		this.eventi = new ArrayList<Evento>();
	}

//		METODI
	public void aggiungiEvento(Evento evento) {
		eventi.add(evento);
	}
	
	public void eventiInData(LocalDate dataRichiesta) {
		System.out.println("=====\nEventi presenti in data: " + dataRichiesta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		for (Evento evento : eventi) {
			if (evento.data.equals(dataRichiesta)) {
				System.out.println("- " + evento.titolo);
			}
		}
	}
	
	public int nEventi() {
		return eventi.size();
	}
	
	public void svuotaLista() {
		this.eventi = new ArrayList<Evento>();
		System.out.println("La lista è stata svuotata con successo.");
	}
	
	public void stampaLista() {
		Collections.sort(eventi, (a,b)->a.data.compareTo(b.data));
		int index = 1;
		for (Evento evento : eventi) {
			System.out.println(index + ". " + evento.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " " + evento.getTitolo());
			index++;
		}
	}
//		GETTER E SETTER
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
}
