package br.org.generation.lojagames.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 2, max = 100)
	private String nome;
	
	@NotNull
	@Size(min = 2, max = 100)
	@Email
	private String usuario;
	
	@NotNull
	@Size(min = 5)
	private String senha;
	
	@NotNull
	private boolean admin;
	
	@Column(name = "data_nascimento")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	public Usuario() {
		
	}
	
	public Usuario(long id, String nome, String usuario, String senha, boolean admin, LocalDate dataNasc) {
		
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.admin = admin;
		this.dataNascimento = dataNasc;
	}
	
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List <Produtos> produto;

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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNasc) {
		this.dataNascimento = dataNasc;
	}

	public List<Produtos> getProduto() {
		return produto;
	}

	public void setProduto(List<Produtos> produto) {
		this.produto = produto;
	}

	

}