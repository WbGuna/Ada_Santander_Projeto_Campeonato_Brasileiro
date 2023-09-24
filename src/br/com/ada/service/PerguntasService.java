package br.com.ada.service;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.ada.entity.CampeonatoBasileiroFull;
import br.com.ada.entity.CampeonatoBrasileiroCartoes;
import br.com.ada.entity.CampeonatoBrasileiroGols;
import br.com.ada.enums.Estado;

public class PerguntasService {

	private CampeonatoBrasileiroGolsService golsService;
	private CampeonatoBrasileiroCartoesService cartoesService;
	private CampeonatoBasileiroFullService fullService;
	@SuppressWarnings("unused")
	private CampeonatoBrasileiroEstatisticaFullService estatisticaService;

	public PerguntasService(CampeonatoBrasileiroGolsService golsService,
			CampeonatoBrasileiroCartoesService cartoesService, CampeonatoBasileiroFullService fullService,
			CampeonatoBrasileiroEstatisticaFullService estatisticaService) {
		this.golsService = golsService;
		this.cartoesService = cartoesService;
		this.fullService = fullService;
		this.estatisticaService = estatisticaService;
	}

	public Map.Entry<String, Long> jogadorQueMaisFezGols(String filePath) {
		List<CampeonatoBrasileiroGols> gols = golsService.loadData(filePath);
		return gols.stream().collect(Collectors.groupingBy(CampeonatoBrasileiroGols::getAtleta, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
	}

	public Map.Entry<String, Long> jogadorQueMaisFezGolsDePenalti(String filePath) {
		List<CampeonatoBrasileiroGols> gols = golsService.loadData(filePath);
		return gols.stream().filter(gol -> "Penalty".equals(gol.getTipoDeGol()))
				.collect(Collectors.groupingBy(CampeonatoBrasileiroGols::getAtleta, Collectors.counting())).entrySet()
				.stream().max(Map.Entry.comparingByValue()).orElse(null);
	}

	public Map.Entry<String, Long> jogadorQueMaisFezGolsContra(String filePath) {
		List<CampeonatoBrasileiroGols> gols = golsService.loadData(filePath);
		return gols.stream().filter(gol -> "Gol Contra".equals(gol.getTipoDeGol()))
				.collect(Collectors.groupingBy(CampeonatoBrasileiroGols::getAtleta, Collectors.counting())).entrySet()
				.stream().max(Map.Entry.comparingByValue()).orElse(null);
	}

	public Map.Entry<String, Long> jogadorQueMaisRecebeuCartoesAmarelos(String filePath) {
		List<CampeonatoBrasileiroCartoes> cartoes = cartoesService.loadData(filePath);
		return cartoes.stream().filter(cartao -> "Amarelo".equals(cartao.getCartao()))
				.collect(Collectors.groupingBy(CampeonatoBrasileiroCartoes::getAtleta, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
	}

	public Map.Entry<String, Long> jogadorQueMaisRecebeuCartoesVermelhos(String filePath) {
		List<CampeonatoBrasileiroCartoes> cartoes = cartoesService.loadData(filePath);
		return cartoes.stream().filter(cartao -> "Vermelho".equals(cartao.getCartao()))
				.collect(Collectors.groupingBy(CampeonatoBrasileiroCartoes::getAtleta, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
	}

	public CampeonatoBasileiroFull partidaComMaisGols(String filePath) {
		List<CampeonatoBasileiroFull> partidas = fullService.loadData(filePath);
		return partidas.stream()
				.max(Comparator.comparingInt(partida -> partida.getMandantePlacar() + partida.getVisitantePlacar()))
				.orElse(null);
	}

	public Map.Entry<String, Long> timeQueMaisVenceu2008(String filePath) {
		List<CampeonatoBasileiroFull> partidas = fullService.loadData(filePath);
		return partidas.stream().filter(partida -> partida.getData().getYear() == 2008)
				.collect(Collectors.groupingBy(CampeonatoBasileiroFull::getVencedor, Collectors.counting())).entrySet()
				.stream().max(Map.Entry.comparingByValue()).orElse(null);
	}
	
	public Map.Entry<String, Long> timeQueMaisVenceu2008Dois(String filePath) {
	    List<CampeonatoBasileiroFull> partidas = fullService.loadData(filePath);
	    return partidas.stream()
	        .filter(partida -> partida.getData().getYear() == 2008 && !"-".equals(partida.getVencedor()))
	        .collect(Collectors.groupingBy(CampeonatoBasileiroFull::getVencedor, Collectors.counting()))
	        .entrySet().stream()
	        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
	        .skip(1)
	        .findFirst()
	        .orElse(null);
	}
	
	public Map.Entry<String, Long> timeComMenosJogos(String filePath) {
	    List<CampeonatoBasileiroFull> partidas = fullService.loadData(filePath);
	    Map.Entry<String, Long> estadoComMenosJogos = partidas.stream()
	        .filter(partida -> partida.getData().getYear() >= 2003 && partida.getData().getYear() <= 2022)
	        .collect(Collectors.groupingBy(CampeonatoBasileiroFull::getMandanteEstado, Collectors.counting()))
	        .entrySet().stream()
	        .min(Map.Entry.comparingByValue())
	        .orElse(null);

	    if (estadoComMenosJogos != null) {
	        String abreviacaoEstado = estadoComMenosJogos.getKey();
	        String nomeCompletoEstado = Estado.valueOf(abreviacaoEstado).getNomeCompleto();
	        return new AbstractMap.SimpleEntry<>(nomeCompletoEstado, estadoComMenosJogos.getValue());
	    } else {
	        return null;
	    }
	}
}
