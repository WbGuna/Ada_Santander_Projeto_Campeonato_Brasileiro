package br.com.ada.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ada.entity.CampeonatoBrasileiroGols;

public class CSVReaderGols {

	public static List<CampeonatoBrasileiroGols> readCSV(String filePath) {
		List<CampeonatoBrasileiroGols> gols = new ArrayList<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine(); // Ignora a primeira linha (cabeçalho do CSV)
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				CampeonatoBrasileiroGols gol = new CampeonatoBrasileiroGols(Integer.parseInt(values[0]), // partida_id
						Integer.parseInt(values[1]), // rodada
						values[2], // clube
						values[3], // atleta
						values[4], // minutos
						values[5] // tipoDeGol
				);
				gols.add(gol);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gols;
	}
}
