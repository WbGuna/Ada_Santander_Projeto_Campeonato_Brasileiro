package br.com.ada.service;

import java.util.List;

import br.com.ada.entity.CampeonatoBrasileiroEstatisticaFull;
import br.com.ada.repository.CampeonatoBrasileiroEstatisticaFullRepository;

public class CampeonatoBrasileiroEstatisticaFullService {

	private CampeonatoBrasileiroEstatisticaFullRepository repository;

	public CampeonatoBrasileiroEstatisticaFullService(CampeonatoBrasileiroEstatisticaFullRepository repository) {
		this.repository = repository;
	}

	public List<CampeonatoBrasileiroEstatisticaFull> loadData(String filePath) {
		return repository.loadData(filePath);
	}
}
