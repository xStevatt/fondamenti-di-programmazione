package it.unibs.fp.morracinese;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilFile
{
	public static void scriviSulFile(String nomeGiocatore, int vittorieGiocatore, int vittorieComputer)
	{
		PrintWriter writer = null;
		File file = null;

		try
		{
			file = new File("stats.txt");

			if (file.createNewFile())
				System.out.println("File statistiche creato");

			try
			{
				writer = new PrintWriter(file);

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));

				writer.append(dtf.format(now) + " - Vittore giocatore" + "'" + nomeGiocatore + "':" + vittorieGiocatore
						+ "\n Vittorie computer: " + vittorieComputer);
			}
			catch (IOException e)
			{
				System.out.println("Errore nella scrittura del file.");
				e.printStackTrace();
			}

		}
		catch (IOException e)
		{
			System.out.println("Errore nell'apertura del file!");
			e.printStackTrace();

		}
		finally
		{
			if (writer != null)
				writer.close();
		}
	}
}
