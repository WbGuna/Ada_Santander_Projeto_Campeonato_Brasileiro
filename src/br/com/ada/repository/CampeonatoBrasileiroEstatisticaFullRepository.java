package br.com.ada.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.ada.entity.CampeonatoBrasileiroEstatisticaFull;
import br.com.ada.utils.CSVReader;

public class CampeonatoBrasileiroEstatisticaFullRepository {

	private List<CampeonatoBrasileiroEstatisticaFull> estatisticas;

	public CampeonatoBrasileiroEstatisticaFullRepository() {
		this.estatisticas = new ArrayList<>();
	}
	
	public List<CampeonatoBrasileiroEstatisticaFull> getData() {
	    return estatisticas;
	}
	
	public List<CampeonatoBrasileiroEstatisticaFull> loadData(String filePath) {
	    this.estatisticas = CSVReader.readEstatisticasCSV(filePath);
	    return this.estatisticas;
	}
}
