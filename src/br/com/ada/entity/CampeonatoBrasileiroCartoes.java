package br.com.ada.entity;

import java.util.Objects;

public class CampeonatoBrasileiroCartoes {

	private Integer partida_id;
    private Integer rodada;
    private String clube;
    private String cartao;
    private String atleta;
    private Integer num_camisa;
    private String posicao;
    private Integer minuto;
    
	public CampeonatoBrasileiroCartoes() {}

	public CampeonatoBrasileiroCartoes(Integer partida_id, Integer rodada, String clube, String cartao, String atleta,
			Integer num_camisa, String posicao, Integer minuto) {
		this.partida_id = partida_id;
		this.rodada = rodada;
		this.clube = clube;
		this.cartao = cartao;
		this.atleta = atleta;
		this.num_camisa = num_camisa;
		this.posicao = posicao;
		this.minuto = minuto;
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

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getAtleta() {
		return atleta;
	}

	public void setAtleta(String atleta) {
		this.atleta = atleta;
	}

	public Integer getNum_camisa() {
		return num_camisa;
	}

	public void setNum_camisa(Integer num_camisa) {
		this.num_camisa = num_camisa;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Integer getMinuto() {
		return minuto;
	}

	public void setMinuto(Integer minuto) {
		this.minuto = minuto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(atleta, cartao, clube, minuto, num_camisa, partida_id, posicao, rodada);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampeonatoBrasileiroCartoes other = (CampeonatoBrasileiroCartoes) obj;
		return Objects.equals(atleta, other.atleta) && Objects.equals(cartao, other.cartao)
				&& Objects.equals(clube, other.clube) && Objects.equals(minuto, other.minuto)
				&& Objects.equals(num_camisa, other.num_camisa) && Objects.equals(partida_id, other.partida_id)
				&& Objects.equals(posicao, other.posicao) && Objects.equals(rodada, other.rodada);
	}

	@Override
	public String toString() {
		return "CampeonatoBrasileiroCartoes [partida_id=" + partida_id + ", rodada=" + rodada + ", clube=" + clube
				+ ", cartao=" + cartao + ", atleta=" + atleta + ", num_camisa=" + num_camisa + ", posicao=" + posicao
				+ ", minuto=" + minuto + "]";
	}  
}
