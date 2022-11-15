package br.com.denner.model;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "telefone")
public class Telefone implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "numero")
	private String numero;
	
	@ManyToOne
	private Cliente cliente;
	
	public Telefone() {}
	
	


	public Telefone(Long id, String tipo, String numero) {
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
		Telefone other = (Telefone) obj;
		return Objects.equals(id, other.id) && Objects.equals(numero, other.numero) && Objects.equals(tipo, other.tipo);
	}
	
	
	
	

}
