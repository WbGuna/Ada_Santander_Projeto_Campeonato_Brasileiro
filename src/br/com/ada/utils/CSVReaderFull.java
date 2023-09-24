package br.com.ada.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.ada.entity.CampeonatoBasileiroFull;

public class CSVReaderFull {

	public static List<CampeonatoBasileiroFull> readCSV(String filePath) {
		List<CampeonatoBasileiroFull> partidas = new ArrayList<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine(); // Ignora a primeira linha (cabeçalho do CSV)
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				CampeonatoBasileiroFull partida = new CampeonatoBasileiroFull(Integer.parseInt(values[0]), // ID
						Integer.parseInt(values[1]), // rodada
						LocalDate.parse(values[2], DateTimeFormatter.ofPattern("d/M/yyyy")), // data
						LocalTime.parse(values[3], DateTimeFormatter.ofPattern("H:mm")), // hora
						values[4], // mandante
						values[5], // visitante
						values[6], // formacaoMandante
						values[7], // formacaoVisitante
						values[8], // tecnicoMandante
						values[9], // tecnicoVisitante
						values[10], // vencedor
						values[11], // arena
						Integer.parseInt(values[12]), // mandantePlacar
						Integer.parseInt(values[13]), // visitantePlacar
						values[14], // mandanteEstado
						values[15] // visitanteEstado
				);
				partidas.add(partida);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return partidas;
	}
}
