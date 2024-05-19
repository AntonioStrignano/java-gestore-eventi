package org.milestone.java.gestoreEventi;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
	private LocalDate ora;
	private double prezzo;

	public Concerto(String titolo, LocalDate data, int nPostiMax, LocalDate ora, double prezzo) {
		super(titolo, data, nPostiMax);
		this.ora = ora;
		this.prezzo = prezzo;
	}

	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	@Override
	public String toString() {
		return this.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")) + "\nTitolo: " + this.titolo + "\nCosto: " + formatter.format(prezzo);
	}
	
	
//		GETTER E SETTER
	public String getOra() {
		return ora.format(DateTimeFormatter.ofPattern("hh:mm"));
	}

	public void setOra(LocalDate ora) {
		this.ora = ora;
	}

	public String getPrezzo() {
		return formatter.format(prezzo);
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
//		/GETTER E SETTER
}
