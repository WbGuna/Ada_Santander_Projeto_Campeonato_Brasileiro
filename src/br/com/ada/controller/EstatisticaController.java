package br.com.ada.controller;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.ada.entity.CampeonatoBrasileiroEstatisticaFull;
import br.com.ada.service.CampeonatoBrasileiroEstatisticaFullService;

public class EstatisticaController {

	private CampeonatoBrasileiroEstatisticaFullService estatisticaService;

	public EstatisticaController(CampeonatoBrasileiroEstatisticaFullService estatisticaService) {
		this.estatisticaService = estatisticaService;
	}

	public void createAndShowGUI() {
		JFrame frame = new JFrame("Estatísticas");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 600);

		List<CampeonatoBrasileiroEstatisticaFull> estatisticas = estatisticaService
				.loadData("src/br/com/ada/arquivosCSV/campeonato-brasileiro-estatisticas-full.csv");
		String[] columnNames = { "Partida ID", "Rodada", "Clube", "Chutes", "Chutes no alvo", "Posse de bola", "Passes",
				"Precisão passes", "Faltas", "Cartão amarelo", "Cartão vermelho", "Impedimentos", "Escanteios" };
		Object[][] data = new Object[estatisticas.size()][13];
		for (int i = 0; i < estatisticas.size(); i++) {
			CampeonatoBrasileiroEstatisticaFull estatistica = estatisticas.get(i);
			data[i][0] = estatistica.getPartida_id();
			data[i][1] = estatistica.getRodada();
			data[i][2] = estatistica.getClube();
			data[i][3] = estatistica.getChutes();
			data[i][4] = estatistica.getChutes_no_alvo();
			data[i][5] = estatistica.getPosse_de_bola();
			data[i][6] = estatistica.getPasses();
			data[i][7] = estatistica.getPrecisao_passes();
			data[i][8] = estatistica.getFaltas();
			data[i][9] = estatistica.getCartao_amarelo();
			data[i][10] = estatistica.getCartao_vermelho();
			data[i][11] = estatistica.getImpedimentos();
			data[i][12] = estatistica.getEscanteios();
		}

		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
