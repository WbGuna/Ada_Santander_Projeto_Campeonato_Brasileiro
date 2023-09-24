package br.com.ada.service;

import java.util.List;

import br.com.ada.entity.CampeonatoBasileiroFull;
import br.com.ada.repository.CampeonatoBasileiroFullRepository;

public class CampeonatoBasileiroFullService {

	private CampeonatoBasileiroFullRepository repository;

	public CampeonatoBasileiroFullService(CampeonatoBasileiroFullRepository repository) {
		this.repository = repository;
	}

	public List<CampeonatoBasileiroFull> loadData(String filePath) {
		return repository.loadData(filePath);
	}
}
