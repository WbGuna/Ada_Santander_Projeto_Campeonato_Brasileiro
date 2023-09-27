package br.com.ada.controller;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.ada.entity.CampeonatoBrasileiroGols;
import br.com.ada.service.CampeonatoBrasileiroGolsService;

public class GolsController {

	private CampeonatoBrasileiroGolsService golsService;

	public GolsController(CampeonatoBrasileiroGolsService golsService) {
		this.golsService = golsService;
	}

	public void createAndShowGUI() {
		JFrame frame = new JFrame("Gols");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 600);

		List<CampeonatoBrasileiroGols> gols = golsService
				.loadData("src/br/com/ada/arquivosCSV/campeonato-brasileiro-gols.csv");
		String[] columnNames = { "Partida ID", "Rodada", "Clube", "Atleta", "Minutos", "Tipo de Gol" };
		Object[][] data = new Object[gols.size()][6];
		for (int i = 0; i < gols.size(); i++) {
			CampeonatoBrasileiroGols gol = gols.get(i);
			data[i][0] = gol.getPartidaID();
			data[i][1] = gol.getRodada();
			data[i][2] = gol.getClube();
			data[i][3] = gol.getAtleta();
			data[i][4] = gol.getMinutos();
			data[i][5] = gol.getTipoDeGol();
		}

		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
