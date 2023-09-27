package br.com.ada.controller;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.ada.entity.CampeonatoBasileiroFull;
import br.com.ada.service.CampeonatoBasileiroFullService;

public class PartidaController {

	private CampeonatoBasileiroFullService fullService;

	public PartidaController(CampeonatoBasileiroFullService fullService) {
		this.fullService = fullService;
	}

	public void createAndShowGUI() {
		JFrame frame = new JFrame("Partidas");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 600);

		List<CampeonatoBasileiroFull> partidas = fullService
				.loadData("src/br/com/ada/arquivosCSV/campeonato-brasileiro-full.csv");
		String[] columnNames = { "ID", "Rodada", "Data", "Hora", "Mandante", "Visitante", "Formação Mandante",
				"Formação Visitante", "Técnico Mandante", "Técnico Visitante", "Vencedor", "Arena", "Placar Mandante",
				"Placar Visitante", "Estado Mandante", "Estado Visitante" };
		Object[][] data = new Object[partidas.size()][16];
		for (int i = 0; i < partidas.size(); i++) {
			CampeonatoBasileiroFull partida = partidas.get(i);
			data[i][0] = partida.getID();
			data[i][1] = partida.getRodada();
			data[i][2] = partida.getData();
			data[i][3] = partida.getHora();
			data[i][4] = partida.getMandante();
			data[i][5] = partida.getVisitante();
			data[i][6] = partida.getFormacaoMandante();
			data[i][7] = partida.getFormacaoVisitante();
			data[i][8] = partida.getTecnicoMandante();
			data[i][9] = partida.getTecnicoVisitante();
			data[i][10] = partida.getVencedor();
			data[i][11] = partida.getArena();
			data[i][12] = partida.getMandantePlacar();
			data[i][13] = partida.getVisitantePlacar();
			data[i][14] = partida.getMandanteEstado();
			data[i][15] = partida.getVisitanteEstado();
		}

		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
