package br.com.ada.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.ada.entity.CampeonatoBrasileiroCartoes;
import br.com.ada.utils.CSVReader;

public class CampeonatoBrasileiroCartoesRepository {

	private List<CampeonatoBrasileiroCartoes> cartoes;

	public CampeonatoBrasileiroCartoesRepository() {
		this.cartoes = new ArrayList<>();
	}

	public List<CampeonatoBrasileiroCartoes> getData() {
	    return cartoes;
	}

	public List<CampeonatoBrasileiroCartoes> loadData(String filePath) {
	    this.cartoes = CSVReader.readCartoesCSV(filePath);
	    return this.cartoes;
	}
}
