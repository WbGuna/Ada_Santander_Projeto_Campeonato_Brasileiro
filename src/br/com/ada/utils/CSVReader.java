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
import br.com.ada.entity.CampeonatoBrasileiroCartoes;
import br.com.ada.entity.CampeonatoBrasileiroEstatisticaFull;
import br.com.ada.entity.CampeonatoBrasileiroGols;

public class CSVReader {

	public static List<CampeonatoBrasileiroGols> readGolsCSV(String filePath) {
		List<CampeonatoBrasileiroGols> gols = new ArrayList<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine(); // Ignora a primeira linha (cabeçalho do CSV)
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				CampeonatoBrasileiroGols gol = new CampeonatoBrasileiroGols(
						Integer.parseInt(values[0].replace("\"", "")), // partida_id
						Integer.parseInt(values[1].replace("\"", "")), // rodada
						values[2].replace("\"", ""), // clube
						values[3].replace("\"", ""), // atleta
						values[4].replace("\"", ""), // minutos
						values[5].replace("\"", "") // tipoDeGol
				);
				gols.add(gol);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gols;
	}

	public static List<CampeonatoBasileiroFull> readPartidasCSV(String filePath) {
		List<CampeonatoBasileiroFull> partidas = new ArrayList<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine(); // Ignora a primeira linha (cabeçalho do CSV)
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				CampeonatoBasileiroFull partida = new CampeonatoBasileiroFull(
						Integer.parseInt(values[0].replace("\"", "")), // ID
						Integer.parseInt(values[1].replace("\"", "")), // rodada
						LocalDate.parse(values[2].replace("\"", ""), DateTimeFormatter.ofPattern("d/M/yyyy")), // data
						LocalTime.parse(values[3].replace("\"", ""), DateTimeFormatter.ofPattern("H:mm")), // hora
						values[4].replace("\"", ""), // mandante
						values[5].replace("\"", ""), // visitante
						values[6].replace("\"", ""), // formacaoMandante
						values[7].replace("\"", ""), // formacaoVisitante
						values[8].replace("\"", ""), // tecnicoMandante
						values[9].replace("\"", ""), // tecnicoVisitante
						values[10].replace("\"", ""), // vencedor
						values[11].replace("\"", ""), // arena
						Integer.parseInt(values[12].replace("\"", "")), // mandantePlacar
						Integer.parseInt(values[13].replace("\"", "")), // visitantePlacar
						values[14].replace("\"", ""), // mandanteEstado
						values[15].replace("\"", "") // visitanteEstado
				);
				partidas.add(partida);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return partidas;
	}

	public static List<CampeonatoBrasileiroEstatisticaFull> readEstatisticasCSV(String filePath) {
		List<CampeonatoBrasileiroEstatisticaFull> estatisticas = new ArrayList<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine(); // Ignora a primeira linha (cabeçalho do CSV)
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				CampeonatoBrasileiroEstatisticaFull estatistica = new CampeonatoBrasileiroEstatisticaFull(
						Integer.parseInt(values[0].replace("\"", "")), // partida_id
						Integer.parseInt(values[1].replace("\"", "")), // rodada
						values[2].replace("\"", ""), // clube
						Integer.parseInt(values[3].replace("\"", "")), // chutes
						Integer.parseInt(values[4].replace("\"", "")), // chutes_no_alvo
						values[5].replace("\"", ""), // posse_de_bola
						Integer.parseInt(values[6].replace("\"", "")), // passes
						values[7].replace("\"", ""), // precisao_passes
						Integer.parseInt(values[8].replace("\"", "")), // faltas
						Integer.parseInt(values[9].replace("\"", "")), // cartao_amarelo
						Integer.parseInt(values[10].replace("\"", "")), // cartao_vermelho
						Integer.parseInt(values[11].replace("\"", "")), // impedimentos
						Integer.parseInt(values[12].replace("\"", "")) // escanteios
				);
				estatisticas.add(estatistica);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return estatisticas;
	}

	public static List<CampeonatoBrasileiroCartoes> readCartoesCSV(String filePath) {
		List<CampeonatoBrasileiroCartoes> cartoes = new ArrayList<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine(); // Ignora a primeira linha (cabeçalho do CSV)
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				String value = values[7].replace("\"", "");
				int minuto;
				if (value.contains("+")) {
					String[] parts = value.split("\\+");
					minuto = Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
				} else {
					minuto = Integer.parseInt(value.isEmpty() ? "0" : value);
				}
				CampeonatoBrasileiroCartoes cartao = new CampeonatoBrasileiroCartoes(
						Integer.parseInt(values[0].replace("\"", "").isEmpty() ? "0" : values[0].replace("\"", "")), // partida_id
						Integer.parseInt(values[1].replace("\"", "").isEmpty() ? "0" : values[1].replace("\"", "")), // rodada
						values[2].replace("\"", ""), // clube
						values[3].replace("\"", ""), // cartao
						values[4].replace("\"", ""), // atleta
						Integer.parseInt(values[5].replace("\"", "").isEmpty() ? "0" : values[5].replace("\"", "")), // num_camisa
						values[6].replace("\"", ""), // posicao
						minuto // minuto
				);
				cartoes.add(cartao);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cartoes;
	}
}
