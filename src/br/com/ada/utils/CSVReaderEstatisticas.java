package br.com.ada.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ada.entity.CampeonatoBrasileiroEstatisticaFull;

public class CSVReaderEstatisticas {

	public static List<CampeonatoBrasileiroEstatisticaFull> readCSV(String filePath) {
		List<CampeonatoBrasileiroEstatisticaFull> estatisticas = new ArrayList<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine(); // Ignora a primeira linha (cabeçalho do CSV)
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				CampeonatoBrasileiroEstatisticaFull estatistica = new CampeonatoBrasileiroEstatisticaFull(
						Integer.parseInt(values[0]), // partida_id
						Integer.parseInt(values[1]), // rodada
						values[2], // clube
						Integer.parseInt(values[3]), // chutes
						Integer.parseInt(values[4]), // chutes_no_alvo
						values[5], // posse_de_bola
						Integer.parseInt(values[6]), // passes
						values[7], // precisao_passes
						Integer.parseInt(values[8]), // faltas
						Integer.parseInt(values[9]), // cartao_amarelo
						Integer.parseInt(values[10]), // cartao_vermelho
						Integer.parseInt(values[11]), // impedimentos
						Integer.parseInt(values[12]) // escanteios
				);
				estatisticas.add(estatistica);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return estatisticas;
	}
}
