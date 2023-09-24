package br.com.ada.entity;

import java.util.Objects;

public class CampeonatoBrasileiroGols {

	private Integer partidaID;
	private Integer rodada;
	private String clube;
	private String atleta;
	private String minutos;
	private String tipoDeGol;
	
	public CampeonatoBrasileiroGols() {}

	public CampeonatoBrasileiroGols(Integer partidaID, Integer rodada, String clube, String atleta, String minutos,
			String tipoDeGol) {
		this.partidaID = partidaID;
		this.rodada = rodada;
		this.clube = clube;
		this.atleta = atleta;
		this.minutos = minutos;
		this.tipoDeGol = tipoDeGol;
	}

	public Integer getPartidaID() {
		return partidaID;
	}

	public void setPartidaID(Integer partidaID) {
		this.partidaID = partidaID;
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

	public String getAtleta() {
		return atleta;
	}

	public void setAtleta(String atleta) {
		this.atleta = atleta;
	}

	public String getMinutos() {
		return minutos;
	}

	public void setMinutos(String minutos) {
		this.minutos = minutos;
	}

	public String getTipoDeGol() {
		return tipoDeGol;
	}

	public void setTipoDeGol(String tipoDeGol) {
		this.tipoDeGol = tipoDeGol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(atleta, clube, minutos, partidaID, rodada, tipoDeGol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampeonatoBrasileiroGols other = (CampeonatoBrasileiroGols) obj;
		return Objects.equals(atleta, other.atleta) && Objects.equals(clube, other.clube)
				&& Objects.equals(minutos, other.minutos) && Objects.equals(partidaID, other.partidaID)
				&& Objects.equals(rodada, other.rodada) && Objects.equals(tipoDeGol, other.tipoDeGol);
	}

	@Override
	public String toString() {
		return "CampeonatoBrasileiro [partidaID=" + partidaID + ", rodada=" + rodada + ", clube=" + clube + ", atleta="
				+ atleta + ", minutos=" + minutos + ", tipoDeGol=" + tipoDeGol + "]";
	}
}
