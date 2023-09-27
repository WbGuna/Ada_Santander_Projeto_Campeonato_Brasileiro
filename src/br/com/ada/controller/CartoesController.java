package br.com.ada.controller;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.ada.entity.CampeonatoBrasileiroCartoes;
import br.com.ada.service.CampeonatoBrasileiroCartoesService;

public class CartoesController {

	private CampeonatoBrasileiroCartoesService cartoesService;

	public CartoesController(CampeonatoBrasileiroCartoesService cartoesService) {
		this.cartoesService = cartoesService;
	}

	public void createAndShowGUI() {
		JFrame frame = new JFrame("Cartões");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 600);

		List<CampeonatoBrasileiroCartoes> cartoes = cartoesService
				.loadData("src/br/com/ada/arquivosCSV/campeonato-brasileiro-cartoes.csv");
		String[] columnNames = { "Partida ID", "Rodada", "Clube", "Cartão", "Atleta", "Número da Camisa", "Posição",
				"Minuto" };
		Object[][] data = new Object[cartoes.size()][8];
		for (int i = 0; i < cartoes.size(); i++) {
			CampeonatoBrasileiroCartoes cartao = cartoes.get(i);
			data[i][0] = cartao.getPartida_id();
			data[i][1] = cartao.getRodada();
			data[i][2] = cartao.getClube();
			data[i][3] = cartao.getCartao();
			data[i][4] = cartao.getAtleta();
			data[i][5] = cartao.getNum_camisa();
			data[i][6] = cartao.getPosicao();
			data[i][7] = cartao.getMinuto();
		}

		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
