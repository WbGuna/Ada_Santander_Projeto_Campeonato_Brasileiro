package br.com.ada.service;

import java.util.List;

import br.com.ada.entity.CampeonatoBrasileiroGols;
import br.com.ada.repository.CampeonatoBrasileiroGolsRepository;

public class CampeonatoBrasileiroGolsService {

	private CampeonatoBrasileiroGolsRepository repository;

	public CampeonatoBrasileiroGolsService(CampeonatoBrasileiroGolsRepository repository) {
		this.repository = repository;
	}

	public List<CampeonatoBrasileiroGols> loadData(String filePath) {
		return repository.loadData(filePath);
	}
}
