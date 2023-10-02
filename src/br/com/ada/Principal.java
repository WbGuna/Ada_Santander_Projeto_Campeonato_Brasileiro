package br.com.ada;

import java.util.List;
import java.util.Map;

import br.com.ada.entity.CampeonatoBasileiroFull;
import br.com.ada.repository.CampeonatoBasileiroFullRepository;
import br.com.ada.repository.CampeonatoBrasileiroCartoesRepository;
import br.com.ada.repository.CampeonatoBrasileiroEstatisticaFullRepository;
import br.com.ada.repository.CampeonatoBrasileiroGolsRepository;
import br.com.ada.service.CampeonatoBasileiroFullService;
import br.com.ada.service.CampeonatoBrasileiroCartoesService;
import br.com.ada.service.CampeonatoBrasileiroEstatisticaFullService;
import br.com.ada.service.CampeonatoBrasileiroGolsService;
import br.com.ada.service.PerguntasService;

public class Principal {

	public static void main(String[] args) {
		
		CampeonatoBrasileiroGolsRepository golsRepository = new CampeonatoBrasileiroGolsRepository();
		CampeonatoBasileiroFullRepository partidasRepository = new CampeonatoBasileiroFullRepository();
		CampeonatoBrasileiroEstatisticaFullRepository estatisticasRepository = new CampeonatoBrasileiroEstatisticaFullRepository();
		CampeonatoBrasileiroCartoesRepository cartoesRepository = new CampeonatoBrasileiroCartoesRepository();

		
		golsRepository.loadData("src/br/com/ada/arquivosCSV/campeonato-brasileiro-gols.csv");
		partidasRepository.loadData("src/br/com/ada/arquivosCSV/campeonato-brasileiro-full.csv");
		estatisticasRepository.loadData("src/br/com/ada/arquivosCSV/campeonato-brasileiro-estatisticas-full.csv");
		cartoesRepository.loadData("src/br/com/ada/arquivosCSV/campeonato-brasileiro-cartoes.csv");

		
		CampeonatoBrasileiroGolsService golsService = new CampeonatoBrasileiroGolsService(golsRepository);
		CampeonatoBasileiroFullService fullService = new CampeonatoBasileiroFullService(partidasRepository);
		CampeonatoBrasileiroEstatisticaFullService estatisticaService = new CampeonatoBrasileiroEstatisticaFullService(
				estatisticasRepository);
		CampeonatoBrasileiroCartoesService cartoesService = new CampeonatoBrasileiroCartoesService(cartoesRepository);

		
		PerguntasService perguntasService = new PerguntasService(golsService, cartoesService, fullService,
				estatisticaService);

		Map.Entry<String, Long> timeComMaisVitorias = perguntasService
				.timeQueMaisEmpatou2008("src/br/com/ada/arquivosCSV/campeonato-brasileiro-full.csv");
		System.out.println("O time que mais venceu em 2008 foi " + timeComMaisVitorias.getKey() + " com "
				+ timeComMaisVitorias.getValue() + " vitórias.");
		
		List<Map.Entry<String, Long>> segundoTimeComMaisVitorias = perguntasService.timesQueMaisVenceram2008("src/br/com/ada/arquivosCSV/campeonato-brasileiro-full.csv");
		if (!segundoTimeComMaisVitorias.isEmpty()) {
			List<Map.Entry<String, Long>> timesComMaisVitorias = segundoTimeComMaisVitorias;
			for (Map.Entry<String, Long> time : timesComMaisVitorias) {
				System.out.println("O time " + time.getKey() + " venceu " + time.getValue() + " partidas em 2008.");
			}
		} else {
		    System.out.println("Não houve vencedores em 2008.");
		}

		Map.Entry<String, Long> estadoComMenosJogos = perguntasService
				.timeComMenosJogos("src/br/com/ada/arquivosCSV/campeonato-brasileiro-full.csv");
		System.out.println("O Estado que teve menos jogos entre 2003 e 2022 foi " + estadoComMenosJogos.getKey()
				+ " com " + estadoComMenosJogos.getValue() + " jogos.");

		Map.Entry<String, Long> jogadorComMaisGols = perguntasService
				.jogadorQueMaisFezGols("src/br/com/ada/arquivosCSV/campeonato-brasileiro-gols.csv");
		System.out.println("O jogador que fez mais gols é " + jogadorComMaisGols.getKey() + " com "
				+ jogadorComMaisGols.getValue() + " gols.");

		Map.Entry<String, Long> jogadorComMaisGolsDePenalti = perguntasService
				.jogadorQueMaisFezGolsDePenalti("src/br/com/ada/arquivosCSV/campeonato-brasileiro-gols.csv");
		System.out.println("O jogador que fez mais gols de pênalti é " + jogadorComMaisGolsDePenalti.getKey() + " com "
				+ jogadorComMaisGolsDePenalti.getValue() + " gols.");

		Map.Entry<String, Long> jogadorComMaisGolsContra = perguntasService
				.jogadorQueMaisFezGolsContra("src/br/com/ada/arquivosCSV/campeonato-brasileiro-gols.csv");
		System.out.println("O jogador que fez mais gols contra é " + jogadorComMaisGolsContra.getKey() + " com "
				+ jogadorComMaisGolsContra.getValue() + " gols.");

		Map.Entry<String, Long> jogadorComMaisCartoesAmarelos = perguntasService
				.jogadorQueMaisRecebeuCartoesAmarelos("src/br/com/ada/arquivosCSV/campeonato-brasileiro-cartoes.csv");
		System.out.println("O jogador que recebeu mais cartões amarelos é " + jogadorComMaisCartoesAmarelos.getKey()
				+ " com " + jogadorComMaisCartoesAmarelos.getValue() + " cartões.");

		Map.Entry<String, Long> jogadorComMaisCartoesVermelhos = perguntasService
				.jogadorQueMaisRecebeuCartoesVermelhos("src/br/com/ada/arquivosCSV/campeonato-brasileiro-cartoes.csv");
		System.out.println("O jogador que recebeu mais cartões vermelhos é " + jogadorComMaisCartoesVermelhos.getKey()
				+ " com " + jogadorComMaisCartoesVermelhos.getValue() + " cartões.");

		CampeonatoBasileiroFull partidaComMaisGols = perguntasService
				.partidaComMaisGols("src/br/com/ada/arquivosCSV/campeonato-brasileiro-full.csv");
		System.out.println("A partida com mais gols foi entre " + partidaComMaisGols.getMandante() + " x "
				+ partidaComMaisGols.getVisitante() + " e o total de gols foi "
				+ (partidaComMaisGols.getMandantePlacar() + partidaComMaisGols.getVisitantePlacar()) + ", com o placar "
				+ partidaComMaisGols.getMandantePlacar() + " x " + partidaComMaisGols.getVisitantePlacar() + " com o "
				+ partidaComMaisGols.getVencedor() + " como vencedor .");

	}
}
