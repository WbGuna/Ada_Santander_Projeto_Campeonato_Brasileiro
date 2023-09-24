package br.com.ada.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.ada.entity.CampeonatoBrasileiroGols;
import br.com.ada.utils.CSVReader;

public class CampeonatoBrasileiroGolsRepository {

	private List<CampeonatoBrasileiroGols> gols;

	public CampeonatoBrasileiroGolsRepository() {
		this.gols = new ArrayList<>();
	}
		
	public List<CampeonatoBrasileiroGols> getData() {
	    return gols;
	}
	
	public List<CampeonatoBrasileiroGols> loadData(String filePath) {
	    this.gols = CSVReader.readGolsCSV(filePath);
	    return this.gols;
	}
}
