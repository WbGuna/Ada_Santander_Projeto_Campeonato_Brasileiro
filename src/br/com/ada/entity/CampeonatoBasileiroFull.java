package br.com.ada.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class CampeonatoBasileiroFull {

	private Integer ID;
    private Integer rodada;
    private LocalDate data;
    private LocalTime hora;
    private String mandante;
    private String visitante;
    private String formacaoMandante;
    private String formacaoVisitante;
    private String tecnicoMandante;
    private String tecnicoVisitante;
    private String vencedor;
    private String arena;
    private Integer mandantePlacar;
    private Integer visitantePlacar;
    private String mandanteEstado;
    private String visitanteEstado;
    
	public CampeonatoBasileiroFull() {}

	public CampeonatoBasileiroFull(Integer iD, Integer rodada, LocalDate data, LocalTime hora, String mandante,
			String visitante, String formacaoMandante, String formacaoVisitante, String tecnicoMandante,
			String tecnicoVisitante, String vencedor, String arena, Integer mandantePlacar, Integer visitantePlacar,
			String mandanteEstado, String visitanteEstado) {
		ID = iD;
		this.rodada = rodada;
		this.data = data;
		this.hora = hora;
		this.mandante = mandante;
		this.visitante = visitante;
		this.formacaoMandante = formacaoMandante;
		this.formacaoVisitante = formacaoVisitante;
		this.tecnicoMandante = tecnicoMandante;
		this.tecnicoVisitante = tecnicoVisitante;
		this.vencedor = vencedor;
		this.arena = arena;
		this.mandantePlacar = mandantePlacar;
		this.visitantePlacar = visitantePlacar;
		this.mandanteEstado = mandanteEstado;
		this.visitanteEstado = visitanteEstado;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getRodada() {
		return rodada;
	}

	public void setRodada(Integer rodada) {
		this.rodada = rodada;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getMandante() {
		return mandante;
	}

	public void setMandante(String mandante) {
		this.mandante = mandante;
	}

	public String getVisitante() {
		return visitante;
	}

	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}

	public String getFormacaoMandante() {
		return formacaoMandante;
	}

	public void setFormacaoMandante(String formacaoMandante) {
		this.formacaoMandante = formacaoMandante;
	}

	public String getFormacaoVisitante() {
		return formacaoVisitante;
	}

	public void setFormacaoVisitante(String formacaoVisitante) {
		this.formacaoVisitante = formacaoVisitante;
	}

	public String getTecnicoMandante() {
		return tecnicoMandante;
	}

	public void setTecnicoMandante(String tecnicoMandante) {
		this.tecnicoMandante = tecnicoMandante;
	}

	public String getTecnicoVisitante() {
		return tecnicoVisitante;
	}

	public void setTecnicoVisitante(String tecnicoVisitante) {
		this.tecnicoVisitante = tecnicoVisitante;
	}

	public String getVencedor() {
		return vencedor;
	}

	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}

	public String getArena() {
		return arena;
	}

	public void setArena(String arena) {
		this.arena = arena;
	}

	public Integer getMandantePlacar() {
		return mandantePlacar;
	}

	public void setMandantePlacar(Integer mandantePlacar) {
		this.mandantePlacar = mandantePlacar;
	}

	public Integer getVisitantePlacar() {
		return visitantePlacar;
	}

	public void setVisitantePlacar(Integer visitantePlacar) {
		this.visitantePlacar = visitantePlacar;
	}

	public String getMandanteEstado() {
		return mandanteEstado;
	}

	public void setMandanteEstado(String mandanteEstado) {
		this.mandanteEstado = mandanteEstado;
	}

	public String getVisitanteEstado() {
		return visitanteEstado;
	}

	public void setVisitanteEstado(String visitanteEstado) {
		this.visitanteEstado = visitanteEstado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, arena, data, formacaoMandante, formacaoVisitante, hora, mandante, mandanteEstado,
				mandantePlacar, rodada, tecnicoMandante, tecnicoVisitante, vencedor, visitante, visitanteEstado,
				visitantePlacar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampeonatoBasileiroFull other = (CampeonatoBasileiroFull) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(arena, other.arena) && Objects.equals(data, other.data)
				&& Objects.equals(formacaoMandante, other.formacaoMandante)
				&& Objects.equals(formacaoVisitante, other.formacaoVisitante) && Objects.equals(hora, other.hora)
				&& Objects.equals(mandante, other.mandante) && Objects.equals(mandanteEstado, other.mandanteEstado)
				&& Objects.equals(mandantePlacar, other.mandantePlacar) && Objects.equals(rodada, other.rodada)
				&& Objects.equals(tecnicoMandante, other.tecnicoMandante)
				&& Objects.equals(tecnicoVisitante, other.tecnicoVisitante) && Objects.equals(vencedor, other.vencedor)
				&& Objects.equals(visitante, other.visitante) && Objects.equals(visitanteEstado, other.visitanteEstado)
				&& Objects.equals(visitantePlacar, other.visitantePlacar);
	}

	@Override
	public String toString() {
		return "CampeonatoBasileiroFull [ID=" + ID + ", rodada=" + rodada + ", data=" + data + ", hora=" + hora
				+ ", mandante=" + mandante + ", visitante=" + visitante + ", formacaoMandante=" + formacaoMandante
				+ ", formacaoVisitante=" + formacaoVisitante + ", tecnicoMandante=" + tecnicoMandante
				+ ", tecnicoVisitante=" + tecnicoVisitante + ", vencedor=" + vencedor + ", arena=" + arena
				+ ", mandantePlacar=" + mandantePlacar + ", visitantePlacar=" + visitantePlacar + ", mandanteEstado="
				+ mandanteEstado + ", visitanteEstado=" + visitanteEstado + "]";
	}  
}
