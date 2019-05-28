package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{
	public static void menu()
	{
		String scelta = "";
		int anno;
		int mese;
		int giorno;
		LocalDate dataInizio;
		LocalDate dataFine = LocalDate.of(0, 1, 1);
		String descrizione;
		
		while(!scelta.equals("9"))
		{
				
			
			
			switch(scelta)
			{					
			
				case "0":	//crea in automatico 6 voci
							esempio();
							scelta = "";
							break;
							
				case "1": 	//Aggiungere nuove voci con gli attributi comuni
							System.out.println("Inserisci i dati per la data in cui hai iniziato questa voce");
							
							anno = setYear();
							mese = setMonth();
							giorno = setDay(mese);
							dataInizio = LocalDate.of(anno, mese, giorno);
							
							while(dataFine.isBefore(dataInizio)) //la data di fine voce deve essere ovviamente posteriore alla data di inizio
							{
								System.out.println("Inserisci i dati per la data in cui hai finito questa voce");	
								
								anno = setYear();
								mese = setMonth();
								giorno = setDay(mese);
								dataFine = LocalDate.of(anno, mese, giorno);
							}
							
							System.out.println("Inserisci una breve descrizione di questa voce");
							descrizione = sc.nextLine();
							
							System.out.println("\n1)Esperienza lavorativa\n2)Studio effettuato\nIn caso si avesse sbagliato non selezionare nessuna delle due");
							scelta = sc.nextLine();
							
							switch(scelta)
							{
								case "1":
											//Aggiungi lavoro
											lav(dataInizio, dataFine, descrizione);
											scelta = "";
											dataFine = LocalDate.of(0, 1, 1);
											break;
									
								case "2":
											// Aggiungi studio
											studi(dataInizio, dataFine, descrizione);
											scelta = "";
											dataFine = LocalDate.of(0, 1, 1);
											break;
									
								default:	// ritorno al menu principale
											scelta = "";
											dataFine = LocalDate.of(0, 1, 1);
											break;
							}
							
							break;
				
				case "2": 
							//remove tramite id
							if(curriculum.getSize() == 0)
							{
								System.out.println("Curriculum vuoto");
							}
							else
							{
								remove();
							}
							
							break;
							
				case "3":	//stampa del curriculum
							curriculum.stampaCV();
							break;
					
				case "9": 	System.out.println("Arrivederci.");
							break;
					
				default:
							break;
			}
		}
		
		
	}
	
	public static int setDay(int month)
	{
		int day = 0;
		while(day == 0)
		{
			try
			{
				switch(month)
				{
					case 4: case 6: case 9: case 11:
												 	System.out.println("Inserisci il giorno tra 1 e 30 compresi");
												 	while(day<1 || day>30)
												 	{
												 		day = Integer.parseInt(sc.nextLine().replaceAll("\\D+", ""));
												 	}
												 	break;
												 	 
					case 1: case 3: case 5: case 7:
					case 8: case 10: case 12:		System.out.println("Inserisci il giorno tra 1 e 31 compresi");
												 	while(day<1 || day>31)
												 	{
												 		day = Integer.parseInt(sc.nextLine().replaceAll("\\D+", ""));
												 	}
												 	break;
												 	
					case 2: 						System.out.println("Inserisci il giorno tra 1 e 28 compresi");
												 	while(day<1 || day>28)
												 	{
												 		day = Integer.parseInt(sc.nextLine().replaceAll("\\D+", ""));
												 	}
												 	break;
				}	
			}
			catch(NumberFormatException e)
			{
				System.out.println("Inserire solo numeri grazie.");
				day = 0;
			}
		}
		return day;
	}
	
	public static int setMonth()
	{
		int month = 0;
		while(month<1 || month>12)
		{
			try
			{
				System.out.println("Inserisci il mese in numero");
				month = Integer.parseInt(sc.nextLine().replaceAll("\\D+", ""));
			}
			catch(NumberFormatException e)
			{
				System.out.println("Inserire solo numeri grazie.");
			}
			
		}
		return month;
	}
	
	public static int setYear()
	{
		int year = 0;
		while(year<((LocalDate.now().getYear())-80) || year > LocalDate.now().getYear())
		{
			try
			{
				System.out.println("Inserisci l'anno");
				year = Integer.parseInt(sc.nextLine().replaceAll("\\D+", ""));
			}
			catch(NumberFormatException e)
			{
				System.out.println("Inserire solo numeri grazie.");
			}
			
		}
		return year;
	}

	
	public static void lav(LocalDate dataInizio, LocalDate dataFine, String descrizione) //metodo per inserire una voce EsperienzaLavorativa
	{
		String nomeAz = "";
		String retribuzioneM = "";
		boolean corsiAgg;
		String tipoAggStringa = "";
		ArrayList <String> tipoAgg = new ArrayList<String>();
		
		while(nomeAz.equals("") || nomeAz.contains("  "))
		{
			System.out.println("Inserisci il nome dell'azienda");
			nomeAz = sc.nextLine().replaceAll("[^A-Z a-z]", "");
		}
		
		
		while(retribuzioneM.equals(""))
		{
			System.out.println("Inserisci l'inquadramento netto mensile");
			retribuzioneM = sc.nextLine().replaceAll("\\D+", "");
		}
		
		System.out.println("Hai svolto corsi di aggiornamento?  y/n");
		String scelta = sc.nextLine().replaceAll("[^A-Z a-z]", "");
		if(scelta.equals("y"))
		{
			System.out.println("Inserisci tutti i corsi che hai frequentato e invece lascia in bianco quando hai finito");
			
			while(tipoAggStringa.equals(""))
			{
				tipoAggStringa = sc.nextLine();
				tipoAgg.add(tipoAggStringa);
			}
			corsiAgg = true;
			curriculum.add(new EsperienzaLavorativa(dataInizio, dataFine, descrizione, nomeAz, retribuzioneM, corsiAgg, tipoAgg));
			
		}
		else
		{
			corsiAgg = false;
			curriculum.add(new EsperienzaLavorativa(dataInizio, dataFine, descrizione, nomeAz, retribuzioneM, corsiAgg, tipoAgg));
		}
	}
	
	public static void studi(LocalDate dataInizio, LocalDate dataFine, String descrizione) //metodo per inserire una voce StudioEffettuato
	{
		String nomeIst = "";
		
		while(nomeIst.equals("") || nomeIst.contains("  "))
		{
			System.out.println("Inserisci il nome dell'istituto in cui hai conseguito questi studi");
			nomeIst = sc.nextLine().replaceAll("^[a-z A-Z]", "");	
		}
		
		
		System.out.println("Hai conseguito un diploma?  y/n");
		String scelta = sc.nextLine().replaceAll("^[a-z A-Z]", "");
		if(scelta.equals("y"))
		{
			curriculum.add(new StudioEffettuato(dataInizio, dataFine, descrizione, nomeIst, diploma()));
		}
		else
		{
			curriculum.add(new StudioEffettuato(dataInizio, dataFine, descrizione, nomeIst, null));
		}
	}
	
	public static Diploma diploma() // metodo per creare il Diploma
	{
		String tipoDiploma = "";
		String durataDiploma = "";
		String votoDiploma = "";
		
		while(tipoDiploma.equals("") || tipoDiploma.contains("  "))
		{
			System.out.println("Inserisci il tipo di diploma conseguito");
			tipoDiploma = sc.nextLine().replaceAll("^[a-z A-Z]", "");
		}
		
		
		while(durataDiploma.equals(""))
		{
			System.out.println("Inserisci la durata del diploma");
			durataDiploma = sc.nextLine().replaceAll("\\D+", "");
		}
		
		while(votoDiploma.equals(""))
		{
			System.out.println("Inserisci il voto conseguito");
			votoDiploma = sc.nextLine().replaceAll("\\D+", "");
		}
		
		Diploma d = new Diploma(tipoDiploma, durataDiploma, votoDiploma);
		
		return d;
		
	}
	
	public static void remove() //metodo per rimuovere una voce
	{
		System.out.println(Voci.getListaId());
		int n = -1;
		boolean out = true;
		
		while((n<0 || n>curriculum.getSize()-1) && out)
		{
			try
			{
				System.out.println("Scegliere tra quelli disponibili.");
				n = Integer.parseInt(sc.nextLine().replaceAll("\\D+", ""));
				out = curriculum.removeVoce(n);
				System.out.println("Voce rimossa correttamente");
				
			}catch(NumberFormatException | IndexOutOfBoundsException e)
			{
				System.out.println("Inserire solo i numeri indicati prego.");
			}
		}
	}

}