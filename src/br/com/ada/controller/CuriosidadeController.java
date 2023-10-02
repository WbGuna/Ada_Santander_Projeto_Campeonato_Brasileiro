package br.com.ada.controller;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.com.ada.entity.CampeonatoBasileiroFull;
import br.com.ada.service.PerguntasService;

public class CuriosidadeController {

	private PerguntasService perguntasService;

	public CuriosidadeController(PerguntasService perguntasService) {
		this.perguntasService = perguntasService;
	}

	public void createAndShowGUI() {
		JFrame frame = new JFrame("Curiosidades");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(650, 300);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);

		Map.Entry<String, Long> timeComMaisEmpates = perguntasService
				.timeQueMaisEmpatou2008("src/br/com/ada/arquivosCSV/campeonato-brasileiro-full.csv");
		textArea.append("Quantidade de partidas com empate em 2008 foram " + timeComMaisEmpates.getValue() + "\n");
		
		List<Map.Entry<String, Long>> timesComMaisVitorias = perguntasService.timesQueMaisVenceram2008("src/br/com/ada/arquivosCSV/campeonato-brasileiro-full.csv");
		Map<Object, Long> empatesDosTimesVencedores = perguntasService.empatesDosTimesVencedores2008("src/br/com/ada/arquivosCSV/campeonato-brasileiro-full.csv", timesComMaisVitorias);

		Long maxVitorias = timesComMaisVitorias.get(0).getValue();
		Long maxEmpates = Collections.max(empatesDosTimesVencedores.values());

		List<String> timesVencedores = new ArrayList<>();
		for (Map.Entry<String, Long> time : timesComMaisVitorias) {
		    Long empates = empatesDosTimesVencedores.getOrDefault(time.getKey(), 0L);
		    textArea.append("O time " + time.getKey() + " venceu " + time.getValue() + " partidas e teve " + empates + " empates em 2008.\n");
		    if (time.getValue().equals(maxVitorias) && empates.equals(maxEmpates)) {
		        timesVencedores.add(time.getKey());
		    }
		}

		if (!timesVencedores.isEmpty()) {
		    for (String time : timesVencedores) {
		        textArea.append("O time vencedor é " + time + ", com " + maxVitorias + " vitórias e com " + maxEmpates + " empates.\n");
		    }
		} else {
		    textArea.append("Não há um time vencedor com o máximo de vitórias e empates.\n");
		}
		
		Map.Entry<String, Long> estadoComMenosJogos = perguntasService
				.timeComMenosJogos("src/br/com/ada/arquivosCSV/campeonato-brasileiro-full.csv");
		textArea.append("O Estado que teve menos jogos entre 2003 e 2022 foi " + estadoComMenosJogos.getKey() + " com "
				+ estadoComMenosJogos.getValue() + " jogos.\n");

		Map.Entry<String, Long> jogadorComMaisGols = perguntasService
				.jogadorQueMaisFezGols("src/br/com/ada/arquivosCSV/campeonato-brasileiro-gols.csv");
		textArea.append("O jogador que fez mais gols é " + jogadorComMaisGols.getKey() + " com "
				+ jogadorComMaisGols.getValue() + " gols.\n");

		Map.Entry<String, Long> jogadorComMaisGolsDePenalti = perguntasService
				.jogadorQueMaisFezGolsDePenalti("src/br/com/ada/arquivosCSV/campeonato-brasileiro-gols.csv");
		textArea.append("O jogador que fez mais gols de pênalti é " + jogadorComMaisGolsDePenalti.getKey() + " com "
				+ jogadorComMaisGolsDePenalti.getValue() + " gols.\n");

		Map.Entry<String, Long> jogadorComMaisGolsContra = perguntasService
				.jogadorQueMaisFezGolsContra("src/br/com/ada/arquivosCSV/campeonato-brasileiro-gols.csv");
		textArea.append("O jogador que fez mais gols contra é " + jogadorComMaisGolsContra.getKey() + " com "
				+ jogadorComMaisGolsContra.getValue() + " gols.\n");

		Map.Entry<String, Long> jogadorComMaisCartoesAmarelos = perguntasService
				.jogadorQueMaisRecebeuCartoesAmarelos("src/br/com/ada/arquivosCSV/campeonato-brasileiro-cartoes.csv");
		textArea.append("O jogador que recebeu mais cartões amarelos é " + jogadorComMaisCartoesAmarelos.getKey()
				+ " com " + jogadorComMaisCartoesAmarelos.getValue() + " cartões.\n");

		Map.Entry<String, Long> jogadorComMaisCartoesVermelhos = perguntasService
				.jogadorQueMaisRecebeuCartoesVermelhos("src/br/com/ada/arquivosCSV/campeonato-brasileiro-cartoes.csv");
		textArea.append("O jogador que recebeu mais cartões vermelhos é " + jogadorComMaisCartoesVermelhos.getKey()
				+ " com " + jogadorComMaisCartoesVermelhos.getValue() + " cartões.\n");

		CampeonatoBasileiroFull partidaComMaisGols = perguntasService
				.partidaComMaisGols("src/br/com/ada/arquivosCSV/campeonato-brasileiro-full.csv");
		textArea.append("A partida com mais gols foi entre " + partidaComMaisGols.getMandante() + " x "
				+ partidaComMaisGols.getVisitante() + ", totalizando "
				+ (partidaComMaisGols.getMandantePlacar() + partidaComMaisGols.getVisitantePlacar())
				+ " gols. O placar foi " + partidaComMaisGols.getMandantePlacar() + " x "
				+ partidaComMaisGols.getVisitantePlacar() + ", com o " + partidaComMaisGols.getVencedor()
				+ " como vencedor.\n");

		JScrollPane scrollPane = new JScrollPane(textArea);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
