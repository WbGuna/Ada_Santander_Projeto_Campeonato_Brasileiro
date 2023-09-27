package br.com.ada.controller;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import br.com.ada.repository.CampeonatoBasileiroFullRepository;
import br.com.ada.repository.CampeonatoBrasileiroCartoesRepository;
import br.com.ada.repository.CampeonatoBrasileiroEstatisticaFullRepository;
import br.com.ada.repository.CampeonatoBrasileiroGolsRepository;
import br.com.ada.service.CampeonatoBasileiroFullService;
import br.com.ada.service.CampeonatoBrasileiroCartoesService;
import br.com.ada.service.CampeonatoBrasileiroEstatisticaFullService;
import br.com.ada.service.CampeonatoBrasileiroGolsService;
import br.com.ada.service.PerguntasService;

public class PrincipalController {

	public static void main(String[] args) {
		CampeonatoBrasileiroGolsRepository golsRepository = new CampeonatoBrasileiroGolsRepository();
		CampeonatoBasileiroFullRepository partidasRepository = new CampeonatoBasileiroFullRepository();
		CampeonatoBrasileiroEstatisticaFullRepository estatisticasRepository = new CampeonatoBrasileiroEstatisticaFullRepository();
		CampeonatoBrasileiroCartoesRepository cartoesRepository = new CampeonatoBrasileiroCartoesRepository();

		golsRepository.loadData("src/br/com/ada/arquivosCSV/campeonato-brasileiro-gols.csv");
		partidasRepository.loadData("src/br/com/ada/arquivosCSV/campeonato-brasileiro-full.csv");
		estatisticasRepository.loadData("src/br/com/ada/arquivosCSV/campeonato-brasileiro-estatisticas-full.csv");
		cartoesRepository.loadData("src/br/com/ada/arquivosCSV/campeonato-brasileiro-cartoes.csv");

		CampeonatoBrasileiroGolsService golsService = new CampeonatoBrasileiroGolsService(golsRepository);
		CampeonatoBasileiroFullService fullService = new CampeonatoBasileiroFullService(partidasRepository);
		CampeonatoBrasileiroEstatisticaFullService estatisticaService = new CampeonatoBrasileiroEstatisticaFullService(
				estatisticasRepository);
		CampeonatoBrasileiroCartoesService cartoesService = new CampeonatoBrasileiroCartoesService(cartoesRepository);

		PerguntasService perguntasService = new PerguntasService(golsService, cartoesService, fullService,
				estatisticaService);

		JFrame frame = new JFrame("Campeonato Brasileiro");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(315, 210);

		JPanel panel = new JPanel(null);

		JButton golsButton = new JButton("Gols");
		golsButton.setBounds(25, 10, 120, 25);
		golsButton.addActionListener(e -> {
			GolsController golsController = new GolsController(golsService);
			golsController.createAndShowGUI();
		});
		JButton estatisticaButton = new JButton("Estatísticas");
		estatisticaButton.setBounds(155, 10, 120, 25);
		estatisticaButton.addActionListener(e -> {
			EstatisticaController estatisticasController = new EstatisticaController(estatisticaService);
			estatisticasController.createAndShowGUI();
		});
		JButton cartoesButton = new JButton("Cartões");
		cartoesButton.setBounds(25, 45, 120, 25);
		cartoesButton.addActionListener(e -> {
			CartoesController cartoesController = new CartoesController(cartoesService);
			cartoesController.createAndShowGUI();
		});
		JButton partidasButton = new JButton("Partidas");
		partidasButton.setBounds(155, 45, 120, 25);
		partidasButton.addActionListener(e -> {
			PartidaController partidasController = new PartidaController(fullService);
			partidasController.createAndShowGUI();
		});
		JButton curiosidadesButton = new JButton("Curiosidades");
		curiosidadesButton.setBounds(25, 80, 120, 25);
		curiosidadesButton.addActionListener(e -> {
			CuriosidadeController curiosidadeController = new CuriosidadeController(perguntasService);
			curiosidadeController.createAndShowGUI();
		});
		JButton comentariosButton = new JButton("Sobre");
		comentariosButton.setBounds(155, 80, 120, 25);
		comentariosButton.addActionListener(e -> {
			JOptionPane.showMessageDialog(null,
					"Trabalho Ada_Santander - Técnica de programação\n\n"
					+ "Este trabalho emprega o uso de expressões lambda e streams para a leitura eficiente de arquivos CSV.");
		});
		JButton fecharButton = new JButton("Fechar");
		fecharButton.setBounds(155, 115, 120, 25);
		fecharButton.addActionListener(e -> {
			System.exit(0);
		});
		JButton creditosButton = new JButton("Créditos");
		creditosButton.setBounds(25, 115, 120, 25);
		creditosButton.addActionListener(e -> {
		    JOptionPane.showMessageDialog(null, "Participantes :\nWillian Barbosa\nWillian Barbosa\n\nProfessor :\nWillian Barbosa");
		});
		JLabel texto = new JLabel("ADA @ SANTANDER", SwingConstants.CENTER);
		texto.setBounds(80, 130, 150, 50); 

		panel.add(golsButton);
		panel.add(estatisticaButton);
		panel.add(cartoesButton);
		panel.add(partidasButton);
		panel.add(curiosidadesButton);
		panel.add(comentariosButton);
		panel.add(fecharButton);
		panel.add(creditosButton);
		panel.add(texto);

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
