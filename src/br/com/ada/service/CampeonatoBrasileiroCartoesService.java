package br.com.ada.service;

import java.util.List;

import br.com.ada.entity.CampeonatoBrasileiroCartoes;
import br.com.ada.repository.CampeonatoBrasileiroCartoesRepository;

public class CampeonatoBrasileiroCartoesService {

	private CampeonatoBrasileiroCartoesRepository repository;

	public CampeonatoBrasileiroCartoesService(CampeonatoBrasileiroCartoesRepository repository) {
		this.repository = repository;
	}

	public List<CampeonatoBrasileiroCartoes> loadData(String filePath) {
		return repository.loadData(filePath);
	}
}
