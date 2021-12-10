package model;

import java.io.Serializable;
import java.util.Objects;

public class Assistente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idAssistente;
	private int Status;
	
	
	
	public Assistente() {
		super();
	}

	public Assistente(int idAssistente, int Status) {
		super();
		this.idAssistente = idAssistente;
		this.Status = Status;
	}
	
	public int getIdAssistente() {
		return idAssistente;
	}
	public void setIdAssistente(int idAssistente) {
		this.idAssistente = idAssistente;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		this.Status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assistente other = (Assistente) obj;
		return Status == other.Status;
	}

	@Override
	public String toString() {
		return "Assistente [idAssistente=" + idAssistente + ", Status=" + Status + "]";
	}
	
	
	

}
