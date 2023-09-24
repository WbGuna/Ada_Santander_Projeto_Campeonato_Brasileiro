package br.com.ada.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.ada.entity.CampeonatoBasileiroFull;
import br.com.ada.utils.CSVReader;

public class CampeonatoBasileiroFullRepository {

	private List<CampeonatoBasileiroFull> partidas;

	public CampeonatoBasileiroFullRepository() {
		this.partidas = new ArrayList<>();
	}
		
	public List<CampeonatoBasileiroFull> getData() {
	    return partidas;
	}
	
	public List<CampeonatoBasileiroFull> loadData(String filePath) {
	    this.partidas = CSVReader.readPartidasCSV(filePath);
	    return this.partidas;
	}

}
