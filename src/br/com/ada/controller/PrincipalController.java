package br.com.ada.controller;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		frame.setSize(300, 200);

		JPanel panel = new JPanel(new GridLayout(5, 1));

		JButton golsButton = new JButton("Gols");
        golsButton.addActionListener(e -> {
            GolsController golsController = new GolsController(golsService);
            golsController.createAndShowGUI();
        });
        JButton estatisticaButton = new JButton("Estatísticas");
        estatisticaButton.addActionListener(e -> {
            EstatisticaController estatisticasController = new EstatisticaController(estatisticaService);
            estatisticasController.createAndShowGUI();
        });
        JButton cartoesButton = new JButton("Cartões");
        cartoesButton.addActionListener(e -> {
            CartoesController cartoesController = new CartoesController(cartoesService);
            cartoesController.createAndShowGUI();
        });
        JButton partidasButton = new JButton("Partidas");
        partidasButton.addActionListener(e -> {
            PartidaController partidasController = new PartidaController(fullService);
            partidasController.createAndShowGUI();
        });
        JButton curiosidadesButton = new JButton("Curiosidades");
        curiosidadesButton.addActionListener(e -> {
            CuriosidadeController curiosidadeController = new CuriosidadeController(perguntasService);
            curiosidadeController.createAndShowGUI();
        });

		panel.add(golsButton);
		panel.add(estatisticaButton);
		panel.add(cartoesButton);
		panel.add(partidasButton);
		panel.add(curiosidadesButton);

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
