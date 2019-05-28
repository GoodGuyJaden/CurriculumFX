package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class EsperienzaLavorativa extends Voci 
{
	private String nomeAz;
	private String retribuzioneM;
	private boolean corsiAgg;
	private ArrayList<String> tipiCorsi = new ArrayList<String>();
	
	public EsperienzaLavorativa(LocalDate dataInizio, LocalDate dataFine, String descrizione, String nomeAz, String retribuzioneM, boolean corsiAgg, ArrayList<String> tipiCorsi)
	{
		super(dataInizio, dataFine, descrizione);
		this.nomeAz = nomeAz;
		this.retribuzioneM = retribuzioneM;
		this.corsiAgg = corsiAgg;
		this.tipiCorsi = tipiCorsi;
	}

	@Override
	public String toString()
	{
		return super.toString() + "\nLavorato presso: " + nomeAz + "\nInquadramento mensile netto: " + retribuzioneM + 
				"€\nPartecipazione corsi aggiornamento: " + corsiAgg + "\nTipo di corso: " + tipiCorsi + "\n//\n";
		
	}
}
