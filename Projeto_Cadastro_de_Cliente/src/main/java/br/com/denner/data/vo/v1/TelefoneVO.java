package br.com.denner.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

public class TelefoneVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String tipo;
	private String numero;
	
	public TelefoneVO() {}

	public TelefoneVO(Long id, String tipo, String numero) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, numero, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TelefoneVO other = (TelefoneVO) obj;
		return Objects.equals(id, other.id) && Objects.equals(numero, other.numero) && Objects.equals(tipo, other.tipo);
	}
	
	

	
	
	
	
	
	
	
}
