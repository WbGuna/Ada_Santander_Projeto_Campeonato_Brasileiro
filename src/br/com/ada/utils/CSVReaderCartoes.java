package br.com.ada.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ada.entity.CampeonatoBrasileiroCartoes;

public class CSVReaderCartoes {

	public static List<CampeonatoBrasileiroCartoes> readCSV(String filePath) {
		List<CampeonatoBrasileiroCartoes> cartoes = new ArrayList<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine(); // Ignora a primeira linha (cabeçalho do CSV)
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				CampeonatoBrasileiroCartoes cartao = new CampeonatoBrasileiroCartoes(Integer.parseInt(values[0]), // partida_id
						Integer.parseInt(values[1]), // rodada
						values[2], // clube
						values[3], // cartao
						values[4], // atleta
						Integer.parseInt(values[5]), // num_camisa
						values[6], // posicao
						Integer.parseInt(values[7]) // minuto
				);
				cartoes.add(cartao);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cartoes;
	}
}
