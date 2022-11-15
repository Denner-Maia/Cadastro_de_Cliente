package br.com.denner.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")	 
public class Cliente implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome", nullable = false, length = 30)
	private String nome;
	
	@Column(name = "email", nullable = false, length = 50, unique = true)
	private String email;
	
	@Column(name = "cpf", nullable = false, length = 11, unique = true)
	private String cpf;
	
	@Column(name = "sexo", nullable = false, length = 1)
	private String sexo;
	
	
	public Cliente() {}
	
	


	public Cliente(long id, String nome, String email, String cpf, String sexo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.sexo = sexo;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(sexo, cpf, email, id, nome);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(sexo, other.sexo) && Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email)
				&& id == other.id && Objects.equals(nome, other.nome);
	}

	
	
}
