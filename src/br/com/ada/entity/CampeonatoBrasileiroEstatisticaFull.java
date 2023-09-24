package br.com.ada.entity;

import java.util.Objects;

public class CampeonatoBrasileiroEstatisticaFull {

	private Integer partida_id;
	private Integer rodada;
	private String clube;
	private Integer chutes;
	private Integer chutes_no_alvo;
	private String posse_de_bola;
	private Integer passes;
	private String precisao_passes;
	private Integer faltas;
	private Integer cartao_amarelo;
	private Integer cartao_vermelho;
	private Integer impedimentos;
	private Integer escanteios;
	
	public CampeonatoBrasileiroEstatisticaFull() {}

	public CampeonatoBrasileiroEstatisticaFull(Integer partida_id, Integer rodada, String clube, Integer chutes,
			Integer chutes_no_alvo, String posse_de_bola, Integer passes, String precisao_passes, Integer faltas,
			Integer cartao_amarelo, Integer cartao_vermelho, Integer impedimentos, Integer escanteios) {
		this.partida_id = partida_id;
		this.rodada = rodada;
		this.clube = clube;
		this.chutes = chutes;
		this.chutes_no_alvo = chutes_no_alvo;
		this.posse_de_bola = posse_de_bola;
		this.passes = passes;
		this.precisao_passes = precisao_passes;
		this.faltas = faltas;
		this.cartao_amarelo = cartao_amarelo;
		this.cartao_vermelho = cartao_vermelho;
		this.impedimentos = impedimentos;
		this.escanteios = escanteios;
	}

	public Integer getPartida_id() {
		return partida_id;
	}

	public void setPartida_id(Integer partida_id) {
		this.partida_id = partida_id;
	}

	public Integer getRodada() {
		return rodada;
	}

	public void setRodada(Integer rodada) {
		this.rodada = rodada;
	}

	public String getClube() {
		return clube;
	}

	public void setClube(String clube) {
		this.clube = clube;
	}

	public Integer getChutes() {
		return chutes;
	}

	public void setChutes(Integer chutes) {
		this.chutes = chutes;
	}

	public Integer getChutes_no_alvo() {
		return chutes_no_alvo;
	}

	public void setChutes_no_alvo(Integer chutes_no_alvo) {
		this.chutes_no_alvo = chutes_no_alvo;
	}

	public String getPosse_de_bola() {
		return posse_de_bola;
	}

	public void setPosse_de_bola(String posse_de_bola) {
		this.posse_de_bola = posse_de_bola;
	}

	public Integer getPasses() {
		return passes;
	}

	public void setPasses(Integer passes) {
		this.passes = passes;
	}

	public String getPrecisao_passes() {
		return precisao_passes;
	}

	public void setPrecisao_passes(String precisao_passes) {
		this.precisao_passes = precisao_passes;
	}

	public Integer getFaltas() {
		return faltas;
	}

	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}

	public Integer getCartao_amarelo() {
		return cartao_amarelo;
	}

	public void setCartao_amarelo(Integer cartao_amarelo) {
		this.cartao_amarelo = cartao_amarelo;
	}

	public Integer getCartao_vermelho() {
		return cartao_vermelho;
	}

	public void setCartao_vermelho(Integer cartao_vermelho) {
		this.cartao_vermelho = cartao_vermelho;
	}

	public Integer getImpedimentos() {
		return impedimentos;
	}

	public void setImpedimentos(Integer impedimentos) {
		this.impedimentos = impedimentos;
	}

	public Integer getEscanteios() {
		return escanteios;
	}

	public void setEscanteios(Integer escanteios) {
		this.escanteios = escanteios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartao_amarelo, cartao_vermelho, chutes, chutes_no_alvo, clube, escanteios, faltas,
				impedimentos, partida_id, passes, posse_de_bola, precisao_passes, rodada);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampeonatoBrasileiroEstatisticaFull other = (CampeonatoBrasileiroEstatisticaFull) obj;
		return Objects.equals(cartao_amarelo, other.cartao_amarelo)
				&& Objects.equals(cartao_vermelho, other.cartao_vermelho) && Objects.equals(chutes, other.chutes)
				&& Objects.equals(chutes_no_alvo, other.chutes_no_alvo) && Objects.equals(clube, other.clube)
				&& Objects.equals(escanteios, other.escanteios) && Objects.equals(faltas, other.faltas)
				&& Objects.equals(impedimentos, other.impedimentos) && Objects.equals(partida_id, other.partida_id)
				&& Objects.equals(passes, other.passes) && Objects.equals(posse_de_bola, other.posse_de_bola)
				&& Objects.equals(precisao_passes, other.precisao_passes) && Objects.equals(rodada, other.rodada);
	}

	@Override
	public String toString() {
		return "CampeonatoBrasileiroEstatisticaFull [partida_id=" + partida_id + ", rodada=" + rodada + ", clube="
				+ clube + ", chutes=" + chutes + ", chutes_no_alvo=" + chutes_no_alvo + ", posse_de_bola="
				+ posse_de_bola + ", passes=" + passes + ", precisao_passes=" + precisao_passes + ", faltas=" + faltas
				+ ", cartao_amarelo=" + cartao_amarelo + ", cartao_vermelho=" + cartao_vermelho + ", impedimentos="
				+ impedimentos + ", escanteios=" + escanteios + "]";
	}
}
