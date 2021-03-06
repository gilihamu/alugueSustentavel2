package br.Empresa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.sun.xml.bind.CycleRecoverable;

@Entity(name = "horariofuncionamento")
public class HorarioFuncionamento implements Serializable, CycleRecoverable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int idHorarioFuncionamento;
	@ManyToOne
	@JoinColumn(name = "idEmpresa")
	private Empresa empresa;
	@OneToOne
	@JoinColumn(name = "idDiaDaSemana")
	private DiaDaSemana diaDaSemana;
	private String horaInicio;
	private String horaFim;
	private boolean ativo;

	public int getIdHorarioFuncionamento() {
		return idHorarioFuncionamento;
	}

	public void setIdHorarioFuncionamento(int idHorarioFuncionamento) {
		this.idHorarioFuncionamento = idHorarioFuncionamento;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result
				+ ((diaDaSemana == null) ? 0 : diaDaSemana.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((horaFim == null) ? 0 : horaFim.hashCode());
		result = prime * result
				+ ((horaInicio == null) ? 0 : horaInicio.hashCode());
		result = prime * result + idHorarioFuncionamento;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HorarioFuncionamento other = (HorarioFuncionamento) obj;
		if (ativo != other.ativo)
			return false;
		if (diaDaSemana == null) {
			if (other.diaDaSemana != null)
				return false;
		} else if (!diaDaSemana.equals(other.diaDaSemana))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (horaFim == null) {
			if (other.horaFim != null)
				return false;
		} else if (!horaFim.equals(other.horaFim))
			return false;
		if (horaInicio == null) {
			if (other.horaInicio != null)
				return false;
		} else if (!horaInicio.equals(other.horaInicio))
			return false;
		if (idHorarioFuncionamento != other.idHorarioFuncionamento)
			return false;
		return true;
	}

	@Override
	public Object onCycleDetected(Context arg0) {
		HorarioFuncionamento h = new HorarioFuncionamento();
		h.setIdHorarioFuncionamento(this.idHorarioFuncionamento);
		return h;

	}

}
